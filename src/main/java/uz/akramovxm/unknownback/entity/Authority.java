package uz.akramovxm.unknownback.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    GET_TASK, CREATE_TASK, UPDATE_TASK, DELETE_TASK;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
