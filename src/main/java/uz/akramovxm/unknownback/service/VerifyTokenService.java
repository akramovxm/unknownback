package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.entity.VerifyToken;

import java.time.LocalDateTime;
import java.util.Optional;

public interface VerifyTokenService {
    Optional<VerifyToken> findByUserId(Long userId);
    Optional<VerifyToken> findByToken(String token);

    VerifyToken save(VerifyToken verifyToken);

    void deleteAllByExpiresAtBefore(LocalDateTime dateTime);
}
