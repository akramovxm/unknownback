package uz.akramovxm.unknownback.dto.view;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.entity.Level;
import uz.akramovxm.unknownback.entity.TaskType;

import java.util.List;

@Data
@Builder
public class TaskDTO {
    private Long id;
    private String contentUz;
    private String contentRu;
    private Level level;
    private TaskType type;
    private boolean rowAnswers;
    private SubjectDTO subject;
    private TopicDTO topic;
    private SourceDTO source;
    private List<AnswerDTO> answers;
}
