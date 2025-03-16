package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class AdminTopicDTO {
    private Long id;
    private String title;
    private String path;
    private Integer seq;
    private BasicTopicDTO prev;
    private BasicTopicDTO next;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private AuditUserDTO createdBy;
    private AuditUserDTO updatedBy;
}
