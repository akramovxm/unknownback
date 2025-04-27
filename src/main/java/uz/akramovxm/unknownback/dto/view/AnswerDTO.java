package uz.akramovxm.unknownback.dto.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDTO {
    private Long id;
    private String valueUz;
    private String valueRu;
}
