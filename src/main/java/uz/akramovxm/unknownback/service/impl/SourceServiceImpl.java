package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.dto.request.SourceRequest;
import uz.akramovxm.unknownback.entity.Source;
import uz.akramovxm.unknownback.exception.RequestBodyNotValidException;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.SourceRepository;
import uz.akramovxm.unknownback.service.SourceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SourceServiceImpl implements SourceService {
    @Autowired
    private SourceRepository sourceRepository;

    @Override
    public List<Source> findAll() {
        return sourceRepository.findAll();
    }

    @Override
    public Optional<Source> findById(Long id) {
        return sourceRepository.findById(id);
    }

    @Override
    public Source getById(Long id) {
        return findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Source.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public Source create(SourceRequest request) {
        Source source = new Source();

        Map<String, String> errors = new HashMap<>();

        if (sourceRepository.existsByName(request.getName())) {
            errors.put("name", "Name already exists");
        } else {
            source.setName(request.getName());
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        return sourceRepository.save(source);
    }

    @Override
    public Source update(SourceRequest request, Long id) {
        Source source = getById(id);

        Map<String, String> errors = new HashMap<>();

        if (request.getName() != null && !request.getName().trim().isEmpty()) {
            if (sourceRepository.existsByNameAndIdNot(request.getName(), id)) {
                errors.put("name", "Name already exists");
            } else {
                source.setName(request.getName());
            }
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        return sourceRepository.save(source);
    }

    @Override
    public void deleteById(Long id) {
        sourceRepository.deleteById(id);
    }
}
