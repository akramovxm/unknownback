package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.dto.request.SourceRequest;
import uz.akramovxm.unknownback.entity.Source;

import java.util.List;
import java.util.Optional;

public interface SourceService {
    List<Source> findAll();

    Optional<Source> findById(Long id);

    Source getById(Long id);

    Source create(SourceRequest request);

    Source update(SourceRequest request, Long id);

    void deleteById(Long id);
}
