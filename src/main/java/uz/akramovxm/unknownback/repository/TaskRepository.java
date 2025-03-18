package uz.akramovxm.unknownback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.akramovxm.unknownback.entity.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByTopicId(Long topicId);

    boolean existsByContentUz(String contentUz);

    boolean existsByContentRu(String contentRu);

    boolean existsByContentUzAndIdNot(String contentUz, Long id);

    boolean existsByContentRuAndIdNot(String contentRu, Long id);
}
