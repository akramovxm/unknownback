package uz.akramovxm.unknownback.dto.view.admin;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.dto.view.UserDTO;
import uz.akramovxm.unknownback.entity.GroupType;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
public class AdminTaskGroupDTO {
    private Long id;
    private GroupType type;
    private int seq;
    private AdminSubjectDTO subject;
    private List<AdminTaskSnapshotDTO> tasks;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private UserDTO createdBy;
    private UserDTO updatedBy;
}
