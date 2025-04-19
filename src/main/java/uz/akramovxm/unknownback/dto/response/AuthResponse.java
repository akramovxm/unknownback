package uz.akramovxm.unknownback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String message;
    private String token;
    private LocalDateTime expiresAt;

    public AuthResponse(String message) {
        this.message = message;
    }

    public AuthResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public AuthResponse(String message, LocalDateTime expiresAt) {
        this.message = message;
        this.expiresAt = expiresAt;
    }
}
