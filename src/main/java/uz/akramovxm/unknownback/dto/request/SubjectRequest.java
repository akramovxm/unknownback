package uz.akramovxm.unknownback.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.akramovxm.unknownback.marker.OnCreate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequest {
    @NotNull(message = "titleUz must not be null", groups = OnCreate.class)
    @NotBlank(message = "titleUz must not be empty")
    private String titleUz;

    @NotNull(message = "titleRu must not be null", groups = OnCreate.class)
    @NotBlank(message = "titleRu must not be empty")
    private String titleRu;
}
