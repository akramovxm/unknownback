package uz.akramovxm.unknownback.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "test_sessions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TestSession extends BaseEntity {
    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column
    private LocalDateTime finishTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TestStatus status = TestStatus.IN_PROCESS;

    @ManyToOne(optional = false)
    private User user;

    @OrderBy("seq asc")
    @OneToMany(mappedBy = "testSession", cascade = CascadeType.ALL)
    private List<TaskGroup> taskGroups = new ArrayList<>();
}
