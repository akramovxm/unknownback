package uz.akramovxm.unknownback.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetPasswordRequest {
    @NotNull(message = "token must not be null")
    @NotBlank(message = "token must not be empty")
    private String token;

    @NotNull(message = "password must not be null")
    @NotBlank(message = "password must not be empty")
    private String password;

    public void setToken(String token) {
        this.token = token != null ? token.trim() : null;
    }

    public void setPassword(String password) {
        this.password = password != null ? password.trim() : null;
    }
}
