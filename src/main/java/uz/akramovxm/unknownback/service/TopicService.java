package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.dto.request.TopicRequest;
import uz.akramovxm.unknownback.dto.request.TopicSeqRequest;
import uz.akramovxm.unknownback.entity.Topic;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TopicService {
    List<Topic> findAllOrdered();

    List<Topic> findAll(String search);

    Optional<Topic> findById(Long id);

    Topic getById(Long id);

    Topic create(TopicRequest request);

    Topic update(TopicRequest request, Long id);

    void deleteById(Long id);
}
