package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.VerifyCode;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface VerifyCodeRepository extends JpaRepository<VerifyCode, Long> {
    Optional<VerifyCode> findByUserId(Long userId);
    void deleteAllByExpiresAtBefore(LocalDateTime dateTime);
}
