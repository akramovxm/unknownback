package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.Topic;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAllBySubjectIdOrderBySeqAsc(Long subjectId);

    @Query("SELECT COALESCE(MAX(t.seq), 0) FROM topics t WHERE t.parent IS NULL AND t.subject.id = :subjectId")
    int findMaxSeqWhereParentIsNull(@Param("subjectId") Long subjectId);

    @Query("SELECT COALESCE(MAX(t.seq), 0) FROM topics t WHERE t.parent = :parent AND t.subject.id = :subjectId")
    int findMaxSeqByParent(@Param("parent") Topic parent, @Param("subjectId") Long subjectId);

    boolean existsByTitleUz(String titleUz);
    boolean existsByTitleRu(String titleRu);

    boolean existsByTitleUzAndIdNot(String titleUz, Long id);
    boolean existsByTitleRuAndIdNot(String titleRu, Long id);
}
