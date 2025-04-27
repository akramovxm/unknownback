package uz.akramovxm.unknownback.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectAnswerRequest {
    @NotNull(message = "taskSnapshotId must not be null")
    @Positive(message = "taskSnapshotId must be positive")
    private Long taskSnapshotId;

    @NotNull(message = "answerSnapshotId must not be null")
    @Positive(message = "answerSnapshotId must be positive")
    private Long answerSnapshotId;
}
