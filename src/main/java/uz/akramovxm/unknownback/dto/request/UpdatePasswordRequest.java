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

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword != null ? oldPassword.trim() : null;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword != null ? newPassword.trim() : null;
    }
}
