package uz.akramovxm.unknownback.entity;

import lombok.Getter;

import java.util.Set;

@Getter
public enum Role {
    SUPERADMIN(Set.of(Authority.values())),
    ADMIN(Set.of(Authority.values())),
    PUPIL(Set.of(Authority.GET_USER, Authority.GET_TOPIC, Authority.GET_TASK, Authority.GET_SOURCE));

    final Set<Authority> authorities;

    Role(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
