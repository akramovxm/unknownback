package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    boolean existsByTitleUz(String titleUz);
    boolean existsByTitleRu(String titleRu);
    boolean existsByTitleUzAndIdNot(String titleUz, Long id);
    boolean existsByTitleRuAndIdNot(String titleRu, Long id);
}
