package uz.akramovxm.unknownback.dto.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectDTO {
    private Long id;
    private String titleUz;
    private String titleRu;
}
