package uz.akramovxm.unknownback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity(name = "answer_snapshots")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AnswerSnapshot extends BaseEntity {
    @Column(nullable = false)
    private String valueUz;

    @Column(nullable = false)
    private String valueRu;

    @Column(nullable = false)
    private boolean correct;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(optional = false)
    private TaskSnapshot task;

    @ManyToOne(optional = false)
    private Answer answer;
}
