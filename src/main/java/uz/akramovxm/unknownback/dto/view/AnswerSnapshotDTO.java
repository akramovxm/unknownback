package uz.akramovxm.unknownback.dto.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerSnapshotDTO {
    private Long id;
    private String valueUz;
    private String valueRu;
    private boolean correct;
    private Long answerId;
}
