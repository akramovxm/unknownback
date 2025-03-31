package uz.akramovxm.unknownback.service;


import uz.akramovxm.unknownback.dto.request.auth.*;

public interface AuthService {
    String login(LoginRequest request);

    void register(RegisterRequest request);

    void verifyRegistration(VerifyRequest request);

    String verifyRecovery(VerifyRequest request);

    void sendCode(SendCodeRequest request);

    void setPassword(SetPasswordRequest request);
}
