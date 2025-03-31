package uz.akramovxm.unknownback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Response<T> {
    private String message;
    private T data;

    public Response(String message) {
        this.message = message;
    }
}
