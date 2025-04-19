package uz.akramovxm.unknownback.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.akramovxm.unknownback.marker.OnCreate;
import uz.akramovxm.unknownback.marker.OnUpdate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequest {
    @NotNull(message = "id must not be null", groups = OnUpdate.class)
    @Positive(message = "id must be positive")
    private Long id;

    @NotNull(message = "valueUz must not be null", groups = OnCreate.class)
    @NotBlank(message = "valueUz must not be empty")
    private String valueUz;

    @NotNull(message = "valueRu must not be null", groups = OnCreate.class)
    @NotBlank(message = "valueRu must not be empty")
    private String valueRu;

    @NotNull(message = "correct must not be null", groups = OnCreate.class)
    private boolean correct;

    public void setValueUz(String valueUz) {
        this.valueUz = valueUz != null ? valueUz.trim() : null;
    }
    public void setValueRu(String valueRu) {
        this.valueRu = valueRu != null ? valueRu.trim() : null;
    }
}
