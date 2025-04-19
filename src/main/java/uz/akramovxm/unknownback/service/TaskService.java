package uz.akramovxm.unknownback.service;

import org.hibernate.search.engine.search.query.SearchResult;
import uz.akramovxm.unknownback.dto.request.IDRequest;
import uz.akramovxm.unknownback.dto.request.TaskRequest;
import uz.akramovxm.unknownback.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    SearchResult<Task> findAllBySubjectId(String search, int page, int size, Long subjectId);

    List<Task> getByTopicId(Long topicId);

    Optional<Task> findById(Long id);

    Task getById(Long id);

    Task create(TaskRequest request);

    Task update(TaskRequest request, Long id);

    void delete(IDRequest request);
}
