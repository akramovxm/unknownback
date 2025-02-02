package uz.akramovxm.unknownback.service;


import uz.akramovxm.unknownback.dto.request.*;

public interface AuthService {
    String login(LoginRequest request);

    void register(RegisterRequest request);

    void verify(VerifyRequest request);

    void sendCode(ResendCodeRequest request);
}
