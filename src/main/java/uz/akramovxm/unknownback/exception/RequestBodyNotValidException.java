package uz.akramovxm.unknownback.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class RequestBodyNotValidException extends RuntimeException {
    public Map<String, String> errors;

    public RequestBodyNotValidException(Map<String, String> errors) {
        this.errors = errors;
    }
}
