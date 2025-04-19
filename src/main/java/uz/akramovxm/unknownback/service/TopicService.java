package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.dto.request.TopicRequest;
import uz.akramovxm.unknownback.entity.Topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface TopicService {
    List<Topic> findAllBySubjectId(String search, Long subjectId);

    List<Topic> findAllBySubjectIdOrdered(Long subjectId);

    Optional<Topic> findById(Long id);

    Topic getById(Long id);

    Topic create(TopicRequest request);

    Topic update(TopicRequest request, Long id);

    void deleteById(Long id);
}
