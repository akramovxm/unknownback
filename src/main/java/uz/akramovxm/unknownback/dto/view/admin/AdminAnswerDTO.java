package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class AdminAnswerDTO {
    private Long id;
    private String valueUz;
    private String valueRu;
    private boolean correct;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private AuditUserDTO createdBy;
    private AuditUserDTO updatedBy;
}
