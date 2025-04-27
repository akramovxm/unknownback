package uz.akramovxm.unknownback.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "task_groups")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TaskGroup extends BaseEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GroupType type;

    @Column(nullable = false)
    private int seq;

    @ManyToOne(optional = false)
    private Subject subject;

    @ManyToOne(optional = false)
    private TestSession testSession;

    @OrderBy("createdAt asc")
    @OneToMany(mappedBy = "taskGroup", cascade = CascadeType.ALL)
    private List<TaskSnapshot> tasks = new ArrayList<>();
}
