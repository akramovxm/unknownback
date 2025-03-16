package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.Topic;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAllByParentIsNullOrderBySeqAsc();
    Optional<Topic> findByPath(String path);
    boolean existsByTitle(String title);
    boolean existsByPath(String path);
    boolean existsByTitleAndIdNot(String title, Long id);
    boolean existsByPathAndIdNot(String path, Long id);
}
