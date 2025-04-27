package uz.akramovxm.unknownback.dto.view.admin;

import lombok.*;
import uz.akramovxm.unknownback.dto.view.*;
import uz.akramovxm.unknownback.entity.Level;
import uz.akramovxm.unknownback.entity.TaskType;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class AdminTaskSnapshotDTO {
    private Long id;
    private String contentUz;
    private String contentRu;
    private Level level;
    private TaskType type;
    private boolean rowAnswers;
    private AdminSubjectDTO subject;
    private AdminTopicDTO topic;
    private AdminSourceDTO source;
    private List<AdminAnswerSnapshotDTO> answers;
    private Long taskId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UserDTO createdBy;
    private UserDTO updatedBy;
}
