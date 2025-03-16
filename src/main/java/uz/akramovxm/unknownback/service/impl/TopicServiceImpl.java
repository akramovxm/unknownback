package uz.akramovxm.unknownback.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.akramovxm.unknownback.dto.request.TopicRequest;
import uz.akramovxm.unknownback.dto.request.TopicSeqRequest;
import uz.akramovxm.unknownback.entity.Topic;
import uz.akramovxm.unknownback.exception.RequestBodyNotValidException;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.TopicRepository;
import uz.akramovxm.unknownback.service.TopicService;

import java.util.*;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Topic> findAll(String search) {
        SearchSession session = Search.session(entityManager);

        SearchResult<Topic> result;

        if (search != null && search.trim().isEmpty()) {
            result = session.search(Topic.class)
                    .where(SearchPredicateFactory::matchAll)
                    .fetchAll();
        } else {
            result = session.search(Topic.class)
                    .where(f -> f.bool()
                            .should(f.wildcard().field("title").matching("*" + search + "*")))
                    .fetchAll();
        }

        return result.hits();
    }

    @Override
    public List<Topic> findAllByParentIsNullOrderBySeqAsc() {
        return topicRepository.findAllByParentIsNullOrderBySeqAsc();
    }

    @Override
    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }

    @Override
    public Topic getById(Long id) {
        return findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Topic.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public Topic getByPath(String path) {
        return topicRepository.findByPath(path).orElseThrow(
                () -> new ResourceNotFoundException(Topic.class.getSimpleName(), "path", path)
        );
    }

    @Transactional
    @Override
    public void update(Collection<TopicSeqRequest> requests) {
        requests.forEach(request -> {
            Topic oldTopic = getById(request.getId());

            Long oldParentId = null;
            Long newParentId = request.getParentId();

            if (oldTopic.getParent() != null) {
                oldParentId = oldTopic.getParent().getId();
            }

            if ((oldParentId != null && oldParentId.equals(newParentId)) ||
                    oldParentId == null && newParentId == null) {

                List<Topic> siblings = getSiblings(oldParentId);

                updatePrevNext(oldTopic, request);

                List<Topic> updatedNewSiblings = updateNewSeq(siblings, request);

                oldTopic.setSeq(request.getSeq());
                oldTopic.setPrevId(request.getPrevId());
                Topic t = findLastTopic(oldTopic);
                t.setNextId(request.getLastNextId());

                topicRepository.saveAll(updatedNewSiblings);
            } else {

                List<Topic> oldSiblings = getSiblings(oldParentId);
                List<Topic> newSiblings = getSiblings(newParentId);

                updatePrevNext(oldTopic, request);

                List<Topic> updatedOldSiblings = updateOldSeq(oldSiblings, request);

                List<Topic> updatedNewSiblings = updateNewSeq(newSiblings, request);

                Topic sibling = newSiblings.stream().findAny().orElse(null);

                oldTopic.setParent(sibling != null ? sibling.getParent() : null);
                oldTopic.setSeq(request.getSeq());
                oldTopic.setPrevId(request.getPrevId());
                Topic t = findLastTopic(oldTopic);
                t.setNextId(request.getLastNextId());

                topicRepository.saveAll(updatedOldSiblings);
                topicRepository.saveAll(updatedNewSiblings);
            }

        });
    }

    @Override
    public Topic updateById(TopicRequest request, Long id) {
        Topic topic = getById(id);

        Map<String, String> errors = new HashMap<>();

        request.setTitle(request.getTitle().trim());
        if (request.getTitle() != null && !request.getTitle().isEmpty()) {
            if (topicRepository.existsByTitleAndIdNot(request.getTitle(), id)) {
                errors.put("title", "Title already exists");
            } else {
                topic.setTitle(request.getTitle());
            }
        }
        if (request.getPath() != null && !request.getPath().isEmpty()) {
            if (topicRepository.existsByPathAndIdNot(request.getPath(), id)) {
                errors.put("path", "Path already exists");
            } else {
                topic.setPath(request.getPath());
            }
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        return topicRepository.save(topic);
    }

    @Transactional
    @Override
    public Topic create(TopicRequest request) {
        Topic topic = new Topic();

        Map<String, String> errors = new HashMap<>();

        request.setTitle(request.getTitle().trim());
        if (request.getTitle() != null && !request.getTitle().isEmpty()) {
            if (topicRepository.existsByTitle(request.getTitle())) {
                errors.put("title", "Title already exists");
            } else {
                topic.setTitle(request.getTitle());
            }
        }
        if (request.getPath() != null && !request.getPath().isEmpty()) {
            if (topicRepository.existsByPath(request.getPath())) {
                errors.put("path", "Path already exists");
            } else {
                topic.setPath(request.getPath());
            }
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        if (request.getParentId() != null) {
            Topic parent = getById(request.getParentId());
            topic.setParent(parent);
        }

        List<Topic> siblings = getSiblings(request.getParentId());

        Topic savedTopic;

        if (siblings.isEmpty()) {
            topic.setPrevId(request.getParentId());
            topic.setSeq(1);

            savedTopic = topicRepository.save(topic);

            if (savedTopic.getParent() != null) {
                topic.setNextId(topic.getParent().getNextId());

                Topic nextTopic = getById(topic.getParent().getNextId());
                nextTopic.setPrevId(savedTopic.getId());

                topic.getParent().setNextId(savedTopic.getId());

                topicRepository.save(nextTopic);
            }
        } else {
            Topic lastSibling = siblings.getLast();

            Topic lastTopic = findLastTopic(lastSibling);

            topic.setPrevId(lastTopic.getId());

            topic.setSeq(lastSibling.getSeq() + 1);

            savedTopic = topicRepository.save(topic);

            if (lastTopic.getNextId() != null) {
                Topic nextTopic = getById(lastTopic.getNextId());
                nextTopic.setPrevId(savedTopic.getId());

                savedTopic.setNextId(nextTopic.getId());

                topicRepository.save(nextTopic);
            }

            lastTopic.setNextId(savedTopic.getId());
            topicRepository.save(lastTopic);
        }

        return savedTopic;
    }

    @Override
    public void deleteById(Long id) {
        Topic topic = getById(id);

        Topic lastTopic = findLastTopic(topic);

        if (topic.getPrevId() != null) {
            Topic prevTopic = getById(topic.getPrevId());
            prevTopic.setNextId(lastTopic.getNextId());
            topicRepository.save(prevTopic);
        }
        if (lastTopic.getNextId() != null) {
            Topic nextTopic = getById(lastTopic.getNextId());
            nextTopic.setPrevId(topic.getPrevId());
            topicRepository.save(nextTopic);
        }

        topicRepository.delete(topic);
    }

    private List<Topic> getSiblings(Long parentId) {
        if (parentId == null) {
            return findAllByParentIsNullOrderBySeqAsc();
        }
        Topic parent = getById(parentId);
        return parent.getChildren();
    }

    private void updatePrevNext(Topic oldTopic, TopicSeqRequest request) {
        Topic oldTopicLastTopic = findLastTopic(oldTopic);
        if (oldTopicLastTopic.getNextId() != null) {
            Topic beforeNextTopic = getById(oldTopicLastTopic.getNextId());
            beforeNextTopic.setPrevId(oldTopic.getPrevId());
        }

        if (oldTopic.getPrevId() != null) {
            Topic beforePrevTopic = getById(oldTopic.getPrevId());
            beforePrevTopic.setNextId(oldTopicLastTopic.getNextId());
        }

        if (request.getPrevId() != null) {
            Topic afterPrevTopic = getById(request.getPrevId());
            afterPrevTopic.setNextId(request.getId());
        }

        if (request.getLastNextId() != null) {
            Topic afterNextTopic = getById(request.getLastNextId());
            afterNextTopic.setPrevId(oldTopicLastTopic.getId());
        }
    }

    private List<Topic> updateOldSeq(List<Topic> oldSiblings, TopicSeqRequest request) {
        int seq = 1;
        for (Topic topic : oldSiblings) {
            if (topic.getId().equals(request.getId())) {
                continue;
            }
            topic.setSeq(seq);
            seq++;
        }
        return oldSiblings;
    }

    private List<Topic> updateNewSeq(List<Topic> topics, TopicSeqRequest request) {
        int seq = 1;
        for (Topic topic : topics) {
            if (seq == request.getSeq()) {
                seq++;
            }
            if (topic.getId().equals(request.getId())) {
                continue;
            }
            topic.setSeq(seq);
            seq++;
        }
        return topics;
    }

    private Topic findLastTopic(Topic topic) {
        if (topic == null) return null;
        if (topic.getChildren().isEmpty()) {
            return topic;
        }
        Topic last = topic.getChildren().getLast();
        return findLastTopic(last);
    }
}
