package uz.akramovxm.unknownback.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.sort.dsl.SortOrder;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.dto.request.IDRequest;
import uz.akramovxm.unknownback.dto.request.TaskRequest;
import uz.akramovxm.unknownback.entity.*;
import uz.akramovxm.unknownback.exception.RequestBodyNotValidException;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.TaskRepository;
import uz.akramovxm.unknownback.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private AnswerService answerService;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SearchResult<Task> findAllBySubjectId(String search, int page, int size, Long subjectId) {
        SearchSession session = Search.session(entityManager);

        return session.search(Task.class)
                .where(f -> {
                    var bool = f.bool();

                    if (search != null && !search.trim().isEmpty()) {
                        bool.must(f.simpleQueryString()
                                .fields("contentUz", "contentRu", "answers.valueUz", "answers.valueRu")
                                .matching(search));
                    }

                    if (subjectId != null) {
                        bool.must(f.match().field("subject.id").matching(subjectId));
                    }

                    return bool;
                })
                .sort(f -> f.field("createdAt_sort").order(SortOrder.DESC))
                .fetch(size * page, size);
    }

    @Override
    public List<Task> getByTopicId(Long topicId) {
        return taskRepository.findAllByTopicId(topicId);
    }

    @Override
    public List<Task> getBySubjectId(Long subjectId, Pageable pageable) {
        return taskRepository.findAllBySubjectId(subjectId, pageable);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task getById(Long id) {
        return findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Task.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public Task create(TaskRequest request) {
        Task task = new Task();

        Map<String, String> errors = new HashMap<>();

        if (taskRepository.existsByContentUz(request.getContentUz())) {
            errors.put("contentUz", "exists");
        } else {
            task.setContentUz(request.getContentUz());
        }
        if (taskRepository.existsByContentRu(request.getContentRu())) {
            errors.put("contentRu", "exists");
        } else {
            task.setContentRu(request.getContentRu());
        }
        if (request.getRowAnswers() != null) {
            task.setRowAnswers(request.getRowAnswers());
        }
        if (request.getSubjectId() != null) {
            Subject subject = subjectService.getById(request.getSubjectId());
            task.setSubject(subject);
        }
        if (request.getTopicId() != null) {
            Topic topic = topicService.getById(request.getTopicId());
            task.setTopic(topic);
        }
        if (request.getSourceId() != null) {
            Source source = sourceService.getById(request.getSourceId());
            task.setSource(source);
        }
        if (request.getLevel() != null) {
            task.setLevel(request.getLevel());
        }
        if (request.getType() != null) {
            task.setType(request.getType());
        }

        AtomicInteger correctAnswers = new AtomicInteger();

        List<Answer> answers = request.getAnswers().stream().map(answerRequest -> {
            if (answerRequest.isCorrect()) {
                correctAnswers.getAndIncrement();
            }
            Answer answer = new Answer();
            answer.setValueUz(answerRequest.getValueUz());
            answer.setValueRu(answerRequest.getValueRu());
            answer.setCorrect(answerRequest.isCorrect());
            answer.setTask(task);
            return answer;
        }).toList();

        task.setAnswers(answers);

        if (correctAnswers.get() > 1 || correctAnswers.get() == 0) {
            errors.put("answers", "oneCorrect");
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        return taskRepository.save(task);
    }

    @Override
    public Task update(TaskRequest request, Long id) {
        Task task = getById(id);

        Map<String, String> errors = new HashMap<>();

        if (request.getContentUz() != null && !request.getContentUz().isEmpty()) {
            if (taskRepository.existsByContentUzAndIdNot(request.getContentUz(), id)) {
                errors.put("contentUz", "exists");
            } else {
                task.setContentUz(request.getContentUz());
            }
        }
        if (request.getContentUz() != null && !request.getContentUz().isEmpty()) {
            if (taskRepository.existsByContentRuAndIdNot(request.getContentRu(), id)) {
                errors.put("contentRu", "exists");
            } else {
                task.setContentRu(request.getContentRu());
            }
        }
        if (request.getRowAnswers() != null) {
            task.setRowAnswers(request.getRowAnswers());
        }
        if (request.getSubjectId() != null) {
            Subject subject = subjectService.getById(request.getSubjectId());
            task.setSubject(subject);
        }
        if (request.getTopicId() != null) {
            Topic topic = topicService.getById(request.getTopicId());
            task.setTopic(topic);
        }
        if (request.getSourceId() != null) {
            Source source = sourceService.getById(request.getSourceId());
            task.setSource(source);
        }
        if (request.getLevel() != null) {
            task.setLevel(request.getLevel());
        }
        if (request.getType() != null) {
            task.setType(request.getType());
        }

        AtomicInteger correctAnswers = new AtomicInteger();

        request.getAnswers().forEach(answerRequest -> {
            if (answerRequest.isCorrect()) {
                correctAnswers.getAndIncrement();
            }
            Answer answer = answerService.getById(answerRequest.getId());
            if (answerRequest.getValueUz() != null && !answerRequest.getValueUz().isEmpty()) {
                answer.setValueUz(answerRequest.getValueUz());
            }
            if (answerRequest.getValueRu() != null && !answerRequest.getValueRu().isEmpty()) {
                answer.setValueRu(answerRequest.getValueRu());
            }
            answer.setCorrect(answerRequest.isCorrect());
        });

        if (correctAnswers.get() > 1 || correctAnswers.get() == 0) {
            errors.put("answers", "oneCorrect");
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        return taskRepository.save(task);
    }

    @Override
    public void delete(IDRequest request) {
        taskRepository.deleteAllById(request.getIds());
    }
}
