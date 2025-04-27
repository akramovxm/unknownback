package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.TaskSnapshot;

@Repository
public interface TaskSnapshotRepository extends JpaRepository<TaskSnapshot, Long> {
}
