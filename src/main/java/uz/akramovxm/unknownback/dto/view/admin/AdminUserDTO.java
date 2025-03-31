package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import uz.akramovxm.unknownback.dto.view.UserDTO;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class AdminUserDTO extends UserDTO {
    private boolean locked;
    private boolean enabled;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UserDTO createdBy;
    private UserDTO updatedBy;
}
