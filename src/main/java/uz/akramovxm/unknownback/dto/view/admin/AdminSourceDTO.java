package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class AdminSourceDTO {
    private Long id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private AuditUserDTO createdBy;
    private AuditUserDTO updatedBy;
}
