package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.dto.view.TopicDTO;
import uz.akramovxm.unknownback.dto.view.UserDTO;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class AdminTopicTreeDTO {
    private Long id;
    private String titleUz;
    private String titleRu;
    private Integer seq;
    private TopicDTO parent;
    private List<AdminTopicTreeDTO> children;
    private Long prevId;
    private Long nextId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UserDTO createdBy;
    private UserDTO updatedBy;
}
