package uz.akramovxm.unknownback.dto.view;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import uz.akramovxm.unknownback.entity.AuthProvider;
import uz.akramovxm.unknownback.entity.Role;

import java.time.LocalDate;

@Data
@SuperBuilder
public class UserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthDate;
    private Role role;
    private AuthProvider provider;
}
