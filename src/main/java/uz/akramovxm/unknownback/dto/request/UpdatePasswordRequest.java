package uz.akramovxm.unknownback.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest {
    @NotNull(message = "oldPassword must not be null")
    @NotBlank(message = "oldPassword must not be empty")
    private String oldPassword;

    @NotNull(message = "newPassword must not be null")
    @NotBlank(message = "newPassword must not be empty")
    private String newPassword;
}
