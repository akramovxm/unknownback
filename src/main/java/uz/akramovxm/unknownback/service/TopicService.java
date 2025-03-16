package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.dto.request.TopicRequest;
import uz.akramovxm.unknownback.dto.request.TopicSeqRequest;
import uz.akramovxm.unknownback.entity.Topic;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TopicService {
    List<Topic> findAll(String search);

    List<Topic> findAllByParentIsNullOrderBySeqAsc();

    Optional<Topic> findById(Long id);

    Topic getById(Long id);

    Topic getByPath(String path);

    void update(Collection<TopicSeqRequest> requests);

    Topic updateById(TopicRequest request, Long id);

    Topic create(TopicRequest request);

    void deleteById(Long id);
}
