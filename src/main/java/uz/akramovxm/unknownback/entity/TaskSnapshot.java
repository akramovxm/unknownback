package uz.akramovxm.unknownback.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "task_snapshots")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TaskSnapshot extends BaseEntity {
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contentUz;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contentRu;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskType type;

    @Column(nullable = false)
    private boolean rowAnswers = false;

    @ManyToOne(optional = false)
    private Subject subject;

    @ManyToOne
    private Topic topic;

    @ManyToOne
    private Source source;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<AnswerSnapshot> answers = new ArrayList<>();

    @OneToOne
    private AnswerSnapshot selectedAnswer;

    @ManyToOne(optional = false)
    private TaskGroup taskGroup;

    @ManyToOne(optional = false)
    private Task task;
}
