package uz.akramovxm.unknownback.dto.view;

import lombok.Builder;
import lombok.Data;
import uz.akramovxm.unknownback.entity.GroupType;

import java.util.List;

@Data
@Builder
public class TaskGroupDTO {
    private Long id;
    private GroupType type;
    private int seq;
    private SubjectDTO subject;
    private List<TaskSnapshotDTO> tasks;
}
