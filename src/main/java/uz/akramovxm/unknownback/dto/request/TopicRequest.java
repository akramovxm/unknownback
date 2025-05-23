package uz.akramovxm.unknownback.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.akramovxm.unknownback.marker.OnCreate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicRequest {
    @NotNull(message = "subjectId must not be null", groups = OnCreate.class)
    @Positive(message = "subjectId must be positive")
    private Long subjectId;

    @Positive(message = "parentId must be positive")
    private Long parentId;

    @NotNull(message = "titleUz must not be null", groups = OnCreate.class)
    @NotBlank(message = "titleUz must not be empty")
    private String titleUz;

    @NotNull(message = "titleRu must not be null", groups = OnCreate.class)
    @NotBlank(message = "titleRu must not be empty")
    private String titleRu;

    public void setTitleUz(String titleUz) {
        this.titleUz = titleUz != null ? titleUz.trim() : null;
    }
    public void setTitleRu(String titleRu) {
        this.titleRu = titleRu != null ? titleRu.trim() : null;
    }
}
