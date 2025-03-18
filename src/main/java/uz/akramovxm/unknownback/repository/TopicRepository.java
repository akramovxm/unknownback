package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.Topic;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Query("SELECT t FROM topics t LEFT JOIN FETCH t.parent ORDER BY t.seq ASC")
    List<Topic> findAllOrdered();

    boolean existsByTitleUz(String titleUz);
    boolean existsByTitleRu(String titleRu);

    boolean existsByTitleUzAndIdNot(String titleUz, Long id);
    boolean existsByTitleRuAndIdNot(String titleRu, Long id);
}
