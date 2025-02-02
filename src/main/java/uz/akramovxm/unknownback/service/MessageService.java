package uz.akramovxm.unknownback.service;

public interface MessageService {
    void sendVerifyCode(String email, String verifyCode);
}
