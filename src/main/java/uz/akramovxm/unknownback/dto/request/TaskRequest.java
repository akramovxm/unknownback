package uz.akramovxm.unknownback.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.akramovxm.unknownback.entity.Level;
import uz.akramovxm.unknownback.entity.TaskType;
import uz.akramovxm.unknownback.marker.OnCreate;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    @NotNull(message = "subjectId must not be null", groups = OnCreate.class)
    @Positive(message = "subjectId must be positive")
    private Long subjectId;

    @Positive(message = "topicId must be positive")
    private Long topicId;

    @Positive(message = "topicId must be positive")
    private Long sourceId;

    @NotNull(message = "contentUz must not be null", groups = OnCreate.class)
    @NotBlank(message = "contentUz must not be empty")
    private String contentUz;

    @NotNull(message = "contentRu must not be null", groups = OnCreate.class)
    @NotBlank(message = "contentRu must not be empty")
    private String contentRu;

    @NotNull(message = "level must not be null", groups = OnCreate.class)
    private Level level;

    @NotNull(message = "type must not be null", groups = OnCreate.class)
    private TaskType type;

    private Boolean rowAnswers;

    @Valid
    @NotNull(message = "type must not be null", groups = OnCreate.class)
    @Size(min = 4, max = 4, message = "answers must be 4")
    private List<AnswerRequest> answers;

    public void setContentUz(String contentUz) {
        this.contentUz = contentUz != null ? contentUz.trim() : null;
    }
    public void setContentRu(String contentRu) {
        this.contentRu = contentRu != null ? contentRu.trim() : null;
    }

}
