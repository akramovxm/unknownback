package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.TestSession;
import uz.akramovxm.unknownback.entity.TestStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestSessionRepository extends JpaRepository<TestSession, Long> {
    List<TestSession> findAllByUserIdAndStatusNotOrderByCreatedAtDesc(Long userId, TestStatus status);
    Optional<TestSession> findByUserIdAndId(Long userId, Long id);
    Optional<TestSession> findByUserIdAndStatus(Long userId, TestStatus status);
    boolean existsByUserIdAndStatus(Long userId, TestStatus status);
}
