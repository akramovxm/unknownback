package uz.akramovxm.unknownback.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.*;
import uz.akramovxm.unknownback.dto.view.admin.AdminTaskSnapshotDTO;
import uz.akramovxm.unknownback.entity.TaskSnapshot;

@Component
public class TaskSnapshotMapper {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private SourceMapper sourceMapper;
    @Autowired
    private AnswerSnapshotMapper answerSnapshotMapper;
    @Autowired
    private UserMapper userMapper;

    public AdminTaskSnapshotDTO toAdminTaskSnapshotDTO(TaskSnapshot taskSnapshot) {
        if (taskSnapshot == null) return null;

        return AdminTaskSnapshotDTO.builder()
                .id(taskSnapshot.getId())
                .contentUz(taskSnapshot.getContentUz())
                .contentRu(taskSnapshot.getContentRu())
                .level(taskSnapshot.getLevel())
                .type(taskSnapshot.getType())
                .rowAnswers(taskSnapshot.isRowAnswers())
                .taskId(taskSnapshot.getTask().getId())
                .subject(subjectMapper.toAdminSubjectDTO(taskSnapshot.getSubject()))
                .topic(topicMapper.toAdminTopicDTO(taskSnapshot.getTopic()))
                .source(sourceMapper.toAdminSourceDTO(taskSnapshot.getSource()))
                .answers(taskSnapshot.getAnswers().stream().map(answerSnapshotMapper::toAdminAnswerSnapshotDTO).toList())
                .createdAt(taskSnapshot.getCreatedAt())
                .updatedAt(taskSnapshot.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(taskSnapshot.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(taskSnapshot.getUpdatedBy()))
                .build();
    }

    public TaskSnapshotDTO toTaskSnapshotDTO(TaskSnapshot taskSnapshot, boolean withCorrect) {
        if (taskSnapshot == null) return null;

        return TaskSnapshotDTO.builder()
                .id(taskSnapshot.getId())
                .contentUz(taskSnapshot.getContentUz())
                .contentRu(taskSnapshot.getContentRu())
                .level(taskSnapshot.getLevel())
                .type(taskSnapshot.getType())
                .rowAnswers(taskSnapshot.isRowAnswers())
                .taskId(taskSnapshot.getTask().getId())
                .subject(subjectMapper.toSubjectDTO(taskSnapshot.getSubject()))
                .topic(topicMapper.toTopicDTO(taskSnapshot.getTopic()))
                .source(sourceMapper.toSourceDTO(taskSnapshot.getSource()))
                .answers(taskSnapshot.getAnswers().stream().map(a -> answerSnapshotMapper.toAnswerSnapshotDTO(a, withCorrect)).toList())
                .selectedAnswer(answerSnapshotMapper.toAnswerSnapshotDTO(taskSnapshot.getSelectedAnswer(), withCorrect))
                .build();
    }
}
