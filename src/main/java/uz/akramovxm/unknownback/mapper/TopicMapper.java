package uz.akramovxm.unknownback.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.admin.AdminTopicDTO;
import uz.akramovxm.unknownback.dto.view.admin.AdminTopicTreeDTO;
import uz.akramovxm.unknownback.dto.view.admin.BasicTopicDTO;
import uz.akramovxm.unknownback.entity.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TopicMapper {
    @Autowired
    private UserMapper userMapper;

    public AdminTopicTreeDTO toAdminTopicTreeDTOWithoutChildren(Topic topic) {
        if (topic == null) return null;
    
        return AdminTopicTreeDTO.builder()
                .id(topic.getId())
                .titleUz(topic.getTitleUz())
                .titleRu(topic.getTitleRu())
                .seq(topic.getSeq())
                .parent(toBasicTopicDTO(topic.getParent()))
                .prevId(topic.getPrevId())
                .nextId(topic.getNextId())
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(topic.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(topic.getUpdatedBy()))
                .build();
    }

    public List<AdminTopicTreeDTO> buildTopicTree(List<Topic> flatList) {
        Map<Long, AdminTopicTreeDTO> dtoMap = new HashMap<>();
        List<AdminTopicTreeDTO> roots = new ArrayList<>();

        for (Topic topic : flatList) {
            AdminTopicTreeDTO dto = toAdminTopicTreeDTOWithoutChildren(topic);
            dto.setChildren(new ArrayList<>());
            dtoMap.put(topic.getId(), dto);
        }

        for (Topic topic : flatList) {
            AdminTopicTreeDTO dto = dtoMap.get(topic.getId());
            if (topic.getParent() != null && topic.getParent().getId() != null) {
                AdminTopicTreeDTO parentDto = dtoMap.get(topic.getParent().getId());
                parentDto.getChildren().add(dto);
            } else {
                roots.add(dto);
            }
        }
    
        return roots;
    }

    public AdminTopicTreeDTO toAdminTopicTreeDTO(Topic topic) {
        if (topic == null) return null;

        return AdminTopicTreeDTO.builder()
                .id(topic.getId())
                .titleUz(topic.getTitleUz())
                .titleRu(topic.getTitleRu())
                .seq(topic.getSeq())
                .parent(toBasicTopicDTO(topic.getParent()))
                .children(topic.getChildren().stream().map(this::toAdminTopicTreeDTO).toList())
                .prevId(topic.getPrevId())
                .nextId(topic.getNextId())
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(topic.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(topic.getUpdatedBy()))
                .build();
    }

    public AdminTopicDTO toAdminTopicDTO(Topic topic) {
        if (topic == null) return null;

        return AdminTopicDTO.builder()
                .id(topic.getId())
                .titleUz(topic.getTitleUz())
                .titleRu(topic.getTitleRu())
                .seq(topic.getSeq())
                .prevId(topic.getPrevId())
                .nextId(topic.getNextId())
                .createdAt(topic.getCreatedAt())
                .updatedAt(topic.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(topic.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(topic.getUpdatedBy()))
                .build();
    }

    public BasicTopicDTO toBasicTopicDTO(Topic topic) {
        if (topic == null) return null;

        return BasicTopicDTO.builder()
                .id(topic.getId())
                .titleUz(topic.getTitleUz())
                .titleRu(topic.getTitleRu())
                .build();
    }
}
