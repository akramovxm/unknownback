package uz.akramovxm.unknownback.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TopicSeqRequest {
    @NotNull(message = "id must not be null")
    @Positive(message = "id must be positive")
    private Long id;

    @NotNull(message = "seq must not be null")
    @Positive(message = "seq must be positive")
    private Integer seq;

    @NotNull(message = "prevId must not be null")
    @Positive(message = "prevId must be positive")
    private Long prevId;

    @NotNull(message = "lastNextId must not be null")
    @Positive(message = "lastNextId must be positive")
    private Long lastNextId;

    @Positive(message = "parentId must be positive")
    private Long parentId;
}
