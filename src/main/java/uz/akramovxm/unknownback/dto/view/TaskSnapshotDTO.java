package uz.akramovxm.unknownback.dto.view;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.entity.*;

import java.util.List;

@Data
@Builder
public class TaskSnapshotDTO {
    private Long id;
    private String contentUz;
    private String contentRu;
    private Level level;
    private TaskType type;
    private boolean rowAnswers;
    private SubjectDTO subject;
    private TopicDTO topic;
    private SourceDTO source;
    private List<AnswerSnapshotDTO> answers;
    private AnswerSnapshotDTO selectedAnswer;
    private Long taskId;
}
