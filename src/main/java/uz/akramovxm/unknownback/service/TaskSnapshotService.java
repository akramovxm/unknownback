package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.dto.request.SelectAnswerRequest;
import uz.akramovxm.unknownback.entity.TaskSnapshot;

public interface TaskSnapshotService {
    TaskSnapshot getById(Long id);
    TaskSnapshot selectAnswer(SelectAnswerRequest request);
}
