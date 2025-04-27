package uz.akramovxm.unknownback.dto.view;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.entity.TestStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class TestSessionDTO {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime finishTime;
    private TestStatus status;
    private UserDTO user;
    private List<TaskGroupDTO> taskGroups;
}
