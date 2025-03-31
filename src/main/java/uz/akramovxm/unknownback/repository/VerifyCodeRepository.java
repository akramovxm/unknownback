package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.VerifyCode;

import java.time.LocalDateTime;

@Repository
public interface VerifyCodeRepository extends JpaRepository<VerifyCode, Long> {
    void deleteAllByExpiresAtBefore(LocalDateTime dateTime);
}
