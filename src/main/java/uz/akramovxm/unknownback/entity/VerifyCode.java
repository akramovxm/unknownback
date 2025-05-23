package uz.akramovxm.unknownback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "verify_codes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VerifyCode extends BaseEntity {
    @OneToOne(optional = false)
    private User user;

    @Column(nullable = false, length = 4)
    private String code;

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    public VerifyCode(User user) {
        this.user = user;
    }
}
