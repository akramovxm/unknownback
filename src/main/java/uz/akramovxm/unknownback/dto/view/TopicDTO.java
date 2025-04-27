package uz.akramovxm.unknownback.dto.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TopicDTO {
    private Long id;
    private String titleUz;
    private String titleRu;
    private Integer seq;
    private Long prevId;
    private Long nextId;
}
