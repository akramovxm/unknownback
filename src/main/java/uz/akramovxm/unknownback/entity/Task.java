package uz.akramovxm.unknownback.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

import java.util.ArrayList;
import java.util.List;

@Indexed
@Entity(name = "tasks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Task extends BaseEntity {
    @FullTextField(analyzer = "nameAnalyzer")
    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String contentUz;

    @FullTextField(analyzer = "nameAnalyzer")
    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String contentRu;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskType type;

    @Column(nullable = false)
    private boolean rowAnswers = false;

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private Source source;

    @IndexedEmbedded(includePaths = {"valueUz", "valueRu"})
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();
}
