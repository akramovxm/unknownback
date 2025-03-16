package uz.akramovxm.unknownback.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.admin.AdminTopicDTO;
import uz.akramovxm.unknownback.dto.view.admin.AdminTopicTreeDTO;
import uz.akramovxm.unknownback.dto.view.admin.BasicTopicDTO;
import uz.akramovxm.unknownback.entity.Topic;
import uz.akramovxm.unknownback.service.TopicService;

@Component
public class TopicMapper {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TopicService topicService;

    public AdminTopicTreeDTO toAdminTopicTreeDTO(Topic topic) {
        if (topic == null) return null;

        AdminTopicTreeDTO.AdminTopicTreeDTOBuilder builder = AdminTopicTreeDTO.builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .path(topic.getPath())
                .seq(topic.getSeq())
                .parent(toBasicTopicDTO(topic.getParent()))
                .children(topic.getChildren().stream().map(this::toAdminTopicTreeDTO).toList())
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .createdBy(userMapper.toAuditUserDTO(topic.getCreatedBy()))
                .updatedBy(userMapper.toAuditUserDTO(topic.getUpdatedBy()));

        if (topic.getPrevId() != null) {
            Topic prev = topicService.findById(topic.getPrevId()).orElse(null);
            builder.prev(toBasicTopicDTO(prev));
        }
        if (topic.getNextId() != null) {
            Topic next = topicService.findById(topic.getNextId()).orElse(null);
            builder.next(toBasicTopicDTO(next));
        }

        return builder.build();
    }

    public AdminTopicDTO toAdminTopicDTO(Topic topic) {
        if (topic == null) return null;

        AdminTopicDTO.AdminTopicDTOBuilder builder = AdminTopicDTO.builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .path(topic.getPath())
                .seq(topic.getSeq())
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .createdBy(userMapper.toAuditUserDTO(topic.getCreatedBy()))
                .updatedBy(userMapper.toAuditUserDTO(topic.getUpdatedBy()));

        if (topic.getPrevId() != null) {
            Topic prev = topicService.findById(topic.getPrevId()).orElse(null);
            builder.prev(toBasicTopicDTO(prev));
        }
        if (topic.getNextId() != null) {
            Topic next = topicService.findById(topic.getNextId()).orElse(null);
            builder.next(toBasicTopicDTO(next));
        }

        return builder.build();
    }

    public BasicTopicDTO toBasicTopicDTO(Topic topic) {
        if (topic == null) return null;

        return BasicTopicDTO.builder()
                .id(topic.getId())
                .title(topic.getTitle())
                .path(topic.getPath())
                .build();
    }
}
