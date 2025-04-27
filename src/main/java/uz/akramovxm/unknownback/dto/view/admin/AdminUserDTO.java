package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.dto.view.UserDTO;
import uz.akramovxm.unknownback.entity.AuthProvider;
import uz.akramovxm.unknownback.entity.Role;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Builder
public class AdminUserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthDate;
    private Role role;
    private AuthProvider provider;
    private boolean locked;
    private boolean enabled;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UserDTO createdBy;
    private UserDTO updatedBy;
}
