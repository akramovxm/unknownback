package uz.akramovxm.unknownback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Response {
    private String message;
    private Object data;
    private long totalElements;
    private long page;
    private long size;

    public Response(String message) {
        this.message = message;
    }

    public Response(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
