package uz.akramovxm.unknownback.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestRequest {
    @NotNull(message = "firstSubjectId must not be null")
    @Positive(message = "firstSubjectId must be positive")
    private Long firstSubjectId;

    @Positive(message = "secondSubjectId must be positive")
    private Long secondSubjectId;
}
