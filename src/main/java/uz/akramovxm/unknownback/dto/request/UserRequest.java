package uz.akramovxm.unknownback.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.akramovxm.unknownback.entity.Role;
import uz.akramovxm.unknownback.marker.OnCreate;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "firstName must not be null", groups = OnCreate.class)
    @NotBlank(message = "firstName must not be empty")
    private String firstName;

    @NotNull(message = "lastName must not be null", groups = OnCreate.class)
    @NotBlank(message = "lastName must not be empty")
    private String lastName;

    @NotNull(message = "email must not be null", groups = OnCreate.class)
    @NotBlank(message = "email must not be empty")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "email is not valid")
    private String email;

    private String phoneNumber;

    private LocalDate birthDate;

    private Role role;

    private boolean locked;
}
