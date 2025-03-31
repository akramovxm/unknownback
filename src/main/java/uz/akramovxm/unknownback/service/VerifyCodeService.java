package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.entity.VerifyCode;

import java.time.LocalDateTime;

public interface VerifyCodeService {
    VerifyCode save(VerifyCode verifyCode);
    void deleteAllByExpiresAtBefore(LocalDateTime dateTime);
}
