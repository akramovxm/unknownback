package uz.akramovxm.unknownback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Indexed
@Entity(name = "answers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Answer extends BaseEntity {
    @FullTextField(analyzer = "nameAnalyzer")
    @Column(nullable = false)
    private String valueUz;

    @FullTextField(analyzer = "nameAnalyzer")
    @Column(nullable = false)
    private String valueRu;

    @Column(nullable = false)
    private boolean correct;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(optional = false)
    private Task task;
}
