package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.dto.view.UserDTO;
import uz.akramovxm.unknownback.entity.Level;
import uz.akramovxm.unknownback.entity.TaskType;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class AdminTaskDTO {
    private Long id;
    private String contentUz;
    private String contentRu;
    private Level level;
    private TaskType type;
    private boolean rowAnswers;
    private AdminSubjectDTO subject;
    private AdminTopicTreeDTO topic;
    private AdminSourceDTO source;
    private List<AdminAnswerDTO> answers;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UserDTO createdBy;
    private UserDTO updatedBy;
}
