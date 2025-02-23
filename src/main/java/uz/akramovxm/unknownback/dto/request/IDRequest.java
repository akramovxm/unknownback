package uz.akramovxm.unknownback.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IDRequest {
    @NotNull(message = "ids must not be null")
    @NotEmpty(message = "ids must not be empty")
    private List<Long> ids;
}
