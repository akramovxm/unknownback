package uz.akramovxm.unknownback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.automaticindexing.ReindexOnUpdate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexingDependency;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @GenericField(name = "id_sort", sortable = Sortable.YES)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GenericField(name = "createdAt_sort", sortable = Sortable.YES)
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @GenericField(name = "updatedAt_sort", sortable = Sortable.YES)
    @Column(nullable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;

    @IndexedEmbedded(includeDepth = 1, name = "createdBy")
    @IndexingDependency(reindexOnUpdate = ReindexOnUpdate.SHALLOW)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(updatable = false)
    @CreatedBy
    @ManyToOne
    private User createdBy;

    @IndexedEmbedded(includeDepth = 1, name = "updatedBy")
    @IndexingDependency(reindexOnUpdate = ReindexOnUpdate.SHALLOW)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @LastModifiedBy
    @ManyToOne
    private User updatedBy;
}
