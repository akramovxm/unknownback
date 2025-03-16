package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicTopicDTO {
    private Long id;
    private String title;
    private String path;
}
