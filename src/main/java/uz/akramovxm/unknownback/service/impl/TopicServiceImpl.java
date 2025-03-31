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
    public List<Topic> findAllOrdered() {
        return topicRepository.findAllOrdered();
    }

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
                            .should(f.wildcard().fields("titleUz", "titleRu").matching("*" + search + "*")))
                    .fetchAll();
        }

        return result.hits();
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

        if (request.getTitleUz() != null && !request.getTitleUz().trim().isEmpty()) {
            if (topicRepository.existsByTitleUz(request.getTitleUz())) {
                errors.put("titleUz", "exists");
            } else {
                topic.setTitleUz(request.getTitleUz());
            }
        }
        if (request.getTitleRu() != null && !request.getTitleRu().trim().isEmpty()) {
            if (topicRepository.existsByTitleRu(request.getTitleRu())) {
                errors.put("titleRu", "exists");
            } else {
                topic.setTitleRu(request.getTitleRu());
            }
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        if (request.getParentId() != null) {
            Topic parent = getById(request.getParentId());
            topic.setParent(parent);
        }

        topic.setSeq(1); //i must fix this case (sequence)!!!

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
