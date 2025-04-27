package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.dto.view.UserDTO;
import uz.akramovxm.unknownback.entity.TestStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class AdminTestSessionDTO {
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime finishTime;
    private TestStatus status;
    private AdminUserDTO user;
    private List<AdminTaskGroupDTO> taskGroups;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UserDTO createdBy;
    private UserDTO updatedBy;
}
