package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.AnswerSnapshot;

@Repository
public interface AnswerSnapshotRepository extends JpaRepository<AnswerSnapshot, Long> {
}
