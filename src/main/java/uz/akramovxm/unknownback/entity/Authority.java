package uz.akramovxm.unknownback.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    GET_USER, CREATE_USER, UPDATE_USER, DELETE_USER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
