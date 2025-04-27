package uz.akramovxm.unknownback.dto.view;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.entity.Role;

import java.time.LocalDate;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthDate;
    private Role role;
}
