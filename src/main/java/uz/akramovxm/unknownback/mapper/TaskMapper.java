package uz.akramovxm.unknownback.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.admin.AdminTaskDTO;
import uz.akramovxm.unknownback.entity.Task;

@Component
public class TaskMapper {
    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private SourceMapper sourceMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private UserMapper userMapper;

    public AdminTaskDTO toAdminTaskDTO(Task task) {
        if (task == null) return null;

        return AdminTaskDTO.builder()
                .id(task.getId())
                .contentUz(task.getContentUz())
                .contentRu(task.getContentRu())
                .level(task.getLevel())
                .type(task.getType())
                .topic(topicMapper.toAdminTopicTreeDTO(task.getTopic()))
                .source(sourceMapper.toAdminSourceDTO(task.getSource()))
                .answers(task.getAnswers().stream().map(answerMapper::toAdminAnswerDTO).toList())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(task.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(task.getUpdatedBy()))
                .build();
    }
}
