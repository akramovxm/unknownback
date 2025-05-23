package uz.akramovxm.unknownback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Indexed
@Entity(name = "topics")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Topic extends BaseEntity {
    @FullTextField(analyzer = "nameAnalyzer")
    @Column(nullable = false, unique = true)
    private String titleUz;

    @FullTextField(analyzer = "nameAnalyzer")
    @Column(nullable = false, unique = true)
    private String titleRu;

    @Column(nullable = false)
    private Integer seq;

    @IndexedEmbedded(includePaths = "id")
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(optional = false)
    private Subject subject;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Topic parent;

    @OrderBy("seq asc")
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Topic> children = new ArrayList<>();

    @Column
    private Long prevId;

    @Column
    private Long nextId;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "topic")
    private Set<Task> tasks = new HashSet<>();
}
