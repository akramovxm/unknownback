package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class AdminTopicTreeDTO {
    private Long id;
    private String title;
    private String path;
    private Integer seq;
    private BasicTopicDTO parent;
    private List<AdminTopicTreeDTO> children;
    private BasicTopicDTO prev;
    private BasicTopicDTO next;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private AuditUserDTO createdBy;
    private AuditUserDTO updatedBy;
}
