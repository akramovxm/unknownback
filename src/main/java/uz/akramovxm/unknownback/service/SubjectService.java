package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.dto.request.SubjectRequest;
import uz.akramovxm.unknownback.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();

    Subject getById(Long id);

    Subject create(SubjectRequest request);

    Subject update(SubjectRequest request, Long id);

    void deleteById(Long id);
}
