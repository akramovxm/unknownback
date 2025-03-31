package uz.akramovxm.unknownback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ListResponse<T> {
    private String message;
    private List<T> data;
    private long totalElements;
    private long page;
    private long size;

    public ListResponse(String message) {
        this.message = message;
    }

    public ListResponse(String message, List<T> data) {
        this.message = message;
        this.data = data;
    }
}
