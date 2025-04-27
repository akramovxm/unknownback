package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.dto.request.SelectAnswerRequest;
import uz.akramovxm.unknownback.entity.AnswerSnapshot;
import uz.akramovxm.unknownback.entity.TaskSnapshot;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.TaskSnapshotRepository;
import uz.akramovxm.unknownback.service.AnswerSnapshotService;
import uz.akramovxm.unknownback.service.TaskSnapshotService;

@Service
public class TaskSnapshotServiceImpl implements TaskSnapshotService {
    @Autowired
    private TaskSnapshotRepository taskSnapshotRepository;
    @Autowired
    private AnswerSnapshotService answerSnapshotService;

    @Override
    public TaskSnapshot selectAnswer(SelectAnswerRequest request) {
        TaskSnapshot taskSnapshot = getById(request.getTaskSnapshotId());

        AnswerSnapshot answerSnapshot = answerSnapshotService.getById(request.getAnswerSnapshotId());

        taskSnapshot.setSelectedAnswer(answerSnapshot);

        return taskSnapshotRepository.save(taskSnapshot);
    }

    @Override
    public TaskSnapshot getById(Long id) {
        return taskSnapshotRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(TaskSnapshot.class.getSimpleName(), "id", id)
        );
    }
}
