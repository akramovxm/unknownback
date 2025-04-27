package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.entity.AnswerSnapshot;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.AnswerSnapshotRepository;
import uz.akramovxm.unknownback.service.AnswerSnapshotService;

@Service
public class AnswerSnapshotServiceImpl implements AnswerSnapshotService {
    @Autowired
    private AnswerSnapshotRepository answerSnapshotRepository;

    @Override
    public AnswerSnapshot getById(Long id) {
        return answerSnapshotRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(AnswerSnapshot.class.getSimpleName(), "id", id)
        );
    }
}
