package uz.akramovxm.unknownback.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.*;
import uz.akramovxm.unknownback.dto.view.admin.AdminTaskGroupDTO;
import uz.akramovxm.unknownback.entity.TaskGroup;

@Component
public class TaskGroupMapper {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private TaskSnapshotMapper taskSnapshotMapper;
    @Autowired
    private UserMapper userMapper;

    public AdminTaskGroupDTO toAdminTaskGroupDTO(TaskGroup taskGroup) {
        if (taskGroup == null) return null;

        return AdminTaskGroupDTO.builder()
                .id(taskGroup.getId())
                .type(taskGroup.getType())
                .seq(taskGroup.getSeq())
                .subject(subjectMapper.toAdminSubjectDTO(taskGroup.getSubject()))
                .tasks(taskGroup.getTasks().stream().map(taskSnapshotMapper::toAdminTaskSnapshotDTO).toList())
                .createdAt(taskGroup.getCreatedAt())
                .updatedAt(taskGroup.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(taskGroup.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(taskGroup.getUpdatedBy()))
                .build();
    }

    public TaskGroupDTO toTaskGroupDTO(TaskGroup taskGroup, boolean withCorrect) {
        if (taskGroup == null) return null;

        return TaskGroupDTO.builder()
                .id(taskGroup.getId())
                .type(taskGroup.getType())
                .seq(taskGroup.getSeq())
                .subject(subjectMapper.toSubjectDTO(taskGroup.getSubject()))
                .tasks(taskGroup.getTasks().stream().map(t -> taskSnapshotMapper.toTaskSnapshotDTO(t, withCorrect)).toList())
                .build();
    }
}
