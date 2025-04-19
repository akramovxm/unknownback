package uz.akramovxm.unknownback.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    GET_USER, CREATE_USER, UPDATE_USER, DELETE_USER,
    GET_SUBJECT, CREATE_SUBJECT, UPDATE_SUBJECT, DELETE_SUBJECT,
    GET_TOPIC, CREATE_TOPIC, UPDATE_TOPIC, DELETE_TOPIC,
    GET_SOURCE, CREATE_SOURCE, UPDATE_SOURCE, DELETE_SOURCE,
    GET_TASK, CREATE_TASK, UPDATE_TASK, DELETE_TASK;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
