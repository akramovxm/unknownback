package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.VerifyToken;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface VerifyTokenRepository extends JpaRepository<VerifyToken, Long> {
    Optional<VerifyToken> findByToken(String token);
    void deleteAllByExpiresAtBefore(LocalDateTime dateTime);
}
