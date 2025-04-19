package uz.akramovxm.unknownback.service;


import uz.akramovxm.unknownback.dto.request.auth.*;
import uz.akramovxm.unknownback.entity.VerifyToken;

import java.time.LocalDateTime;

public interface AuthService {
    String login(LoginRequest request);

    LocalDateTime register(RegisterRequest request);

    void verifyRegistration(VerifyRequest request);

    VerifyToken verifyRecovery(VerifyRequest request);

    LocalDateTime sendCode(SendCodeRequest request);

    void setPassword(SetPasswordRequest request);
}
