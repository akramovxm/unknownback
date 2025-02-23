package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.entity.Role;

@Data
@Builder
public class AuditUserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Role role;
}
