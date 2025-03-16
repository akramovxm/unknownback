package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.entity.Answer;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.AnswerRepository;
import uz.akramovxm.unknownback.service.AnswerService;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer getById(Long id) {
        return answerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Answer.class.getSimpleName(), "id", id)
        );
    }
}
