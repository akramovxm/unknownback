package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.entity.VerifyCode;

import java.time.LocalDateTime;
import java.util.Optional;

public interface VerifyCodeService {
    Optional<VerifyCode> findByUserId(Long userId);
    VerifyCode save(VerifyCode verifyCode);
    void deleteAllByExpiresAtBefore(LocalDateTime dateTime);
}
