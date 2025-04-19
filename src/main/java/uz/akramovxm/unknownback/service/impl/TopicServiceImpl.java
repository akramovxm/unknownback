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
import uz.akramovxm.unknownback.entity.Topic;
import uz.akramovxm.unknownback.exception.RequestBodyNotValidException;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.TopicRepository;
import uz.akramovxm.unknownback.service.SubjectService;
import uz.akramovxm.unknownback.service.TopicService;

import java.util.*;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private SubjectService subjectService;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Topic> findAllBySubjectId(String search, Long subjectId) {
        SearchSession session = Search.session(entityManager);

        return session.search(Topic.class)
                .where(f -> {
                    var bool = f.bool();

                    if (search != null && !search.trim().isEmpty()) {
                        bool.must(f.bool()
                                .should(f.wildcard().field("titleUz").matching("*" + search + "*"))
                                .should(f.wildcard().field("titleRu").matching("*" + search + "*")));
                    }

                    if (subjectId != null) {
                        bool.must(f.match().field("subject.id").matching(subjectId));
                    }

                    return bool;
                })
                .fetchAll()
                .hits();
    }

    @Override
    public List<Topic> findAllBySubjectIdOrdered(Long subjectId) {
        return topicRepository.findAllBySubjectIdOrderBySeqAsc(subjectId);
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

    @Transactional
    @Override
    public Topic create(TopicRequest request) {
        Topic topic = new Topic();

        Map<String, String> errors = new HashMap<>();

        if (topicRepository.existsByTitleUz(request.getTitleUz())) {
            errors.put("titleUz", "exists");
        } else {
            topic.setTitleUz(request.getTitleUz());
        }
        if (topicRepository.existsByTitleRu(request.getTitleRu())) {
            errors.put("titleRu", "exists");
        } else {
            topic.setTitleRu(request.getTitleRu());
        }

        topic.setSubject(subjectService.getById(request.getSubjectId()));

        Topic parent = null;
        if (request.getParentId() != null) {
            parent = getById(request.getParentId());
            topic.setParent(parent);
        }

        int seq = (parent == null)
                ? topicRepository.findMaxSeqWhereParentIsNull(request.getSubjectId())
                : topicRepository.findMaxSeqByParent(parent, request.getSubjectId());

        topic.setSeq(seq + 1);

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        return topicRepository.save(topic);
    }

    @Override
    public Topic update(TopicRequest request, Long id) {
        Topic topic = getById(id);

        Map<String, String> errors = new HashMap<>();

        if (request.getTitleUz() != null && !request.getTitleUz().trim().isEmpty()) {
            if (topicRepository.existsByTitleUzAndIdNot(request.getTitleUz(), id)) {
                errors.put("titleUz", "exists");
            } else {
                topic.setTitleUz(request.getTitleUz());
            }
        }
        if (request.getTitleRu() != null && !request.getTitleRu().trim().isEmpty()) {
            if (topicRepository.existsByTitleRuAndIdNot(request.getTitleRu(), id)) {
                errors.put("titleRu", "exists");
            } else {
                topic.setTitleRu(request.getTitleRu());
            }
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        return topicRepository.save(topic);
    }

    @Override
    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }
}
