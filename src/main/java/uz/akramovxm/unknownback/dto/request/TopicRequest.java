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
    @NotNull(message = "title must not be null", groups = OnCreate.class)
    @NotBlank(message = "title must not be empty")
    private String title;

    @NotNull(message = "path must not be null", groups = OnCreate.class)
    @NotBlank(message = "path must not be empty")
    private String path;

    @Positive(message = "parentId must be positive")
    private Long parentId;
}
