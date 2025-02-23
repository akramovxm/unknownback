package uz.akramovxm.unknownback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

@Indexed
@Entity(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements UserDetails {
    @FullTextField(analyzer = "nameAnalyzer")
    @KeywordField(name = "email_sort", sortable = Sortable.YES)
    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String password;

    @FullTextField(analyzer = "nameAnalyzer")
    @KeywordField(name = "firstName_sort", sortable = Sortable.YES)
    @Column(nullable = false)
    private String firstName;

    @FullTextField(analyzer = "nameAnalyzer")
    @KeywordField(name = "lastName_sort", sortable = Sortable.YES)
    @Column(nullable = false)
    private String lastName;

    @KeywordField
    @Column(unique = true)
    private String phoneNumber;

    @Column
    private LocalDate birthDate;

    @FullTextField(analyzer = "nameAnalyzer")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    @GenericField(name = "locked_sort", sortable = Sortable.YES)
    @Column(nullable = false)
    private boolean locked = false;

    @GenericField(name = "enabled_sort", sortable = Sortable.YES)
    @Column(nullable = false)
    private boolean enabled = false;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private VerifyCode verifyCode;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }
}
