package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.dto.request.SubjectRequest;
import uz.akramovxm.unknownback.entity.Subject;
import uz.akramovxm.unknownback.exception.RequestBodyNotValidException;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.SubjectRepository;
import uz.akramovxm.unknownback.service.SubjectService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @Override
    public Subject getById(Long id) {
        return subjectRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Subject.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public Subject create(SubjectRequest request) {
        Subject subject = new Subject();

        Map<String, String> errors = new HashMap<>();

        if (subjectRepository.existsByTitleUz(request.getTitleUz())) {
            errors.put("titleUz", "exists");
        } else {
            subject.setTitleUz(request.getTitleUz());
        }
        if (subjectRepository.existsByTitleRu(request.getTitleRu())) {
            errors.put("titleRu", "exists");
        } else {
            subject.setTitleRu(request.getTitleRu());
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        return subjectRepository.save(subject);
    }

    @Override
    public Subject update(SubjectRequest request, Long id) {
        Subject subject = getById(id);

        Map<String, String> errors = new HashMap<>();

        if (subjectRepository.existsByTitleUzAndIdNot(request.getTitleUz(), id)) {
            errors.put("titleUz", "exists");
        } else {
            subject.setTitleUz(request.getTitleUz());
        }
        if (subjectRepository.existsByTitleRuAndIdNot(request.getTitleRu(), id)) {
            errors.put("titleRu", "exists");
        } else {
            subject.setTitleRu(request.getTitleRu());
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        return subjectRepository.save(subject);
    }

    @Override
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }
}
