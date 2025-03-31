package uz.akramovxm.unknownback.controller.admin;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.request.SourceRequest;
import uz.akramovxm.unknownback.dto.response.ListResponse;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.dto.view.admin.AdminSourceDTO;
import uz.akramovxm.unknownback.entity.Source;
import uz.akramovxm.unknownback.mapper.SourceMapper;
import uz.akramovxm.unknownback.marker.OnCreate;
import uz.akramovxm.unknownback.marker.OnUpdate;
import uz.akramovxm.unknownback.service.SourceService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/sources")
public class SourceController {
    @Autowired
    private SourceService sourceService;
    @Autowired
    private SourceMapper sourceMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListResponse getAll() {
        List<AdminSourceDTO> sources = sourceService.findAll().stream()
                .map(sourceMapper::toAdminSourceDTO).toList();

        return new ListResponse(HttpStatus.OK.name(), sources);
    }

    @Validated(OnCreate.class)
    @PreAuthorize("hasAuthority('CREATE_SOURCE')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@Valid @RequestBody SourceRequest request) {
        Source source = sourceService.create(request);

        return new Response(HttpStatus.CREATED.name(), sourceMapper.toAdminSourceDTO(source));
    }

    @Validated(OnUpdate.class)
    @PreAuthorize("hasAuthority('UPDATE_SOURCE')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response update(@Valid @RequestBody SourceRequest request, @PathVariable Long id) {
        Source source = sourceService.update(request, id);

        return new Response(HttpStatus.OK.name(), sourceMapper.toAdminSourceDTO(source));
    }

    @PreAuthorize("hasAuthority('DELETE_SOURCE')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse delete(@PathVariable Long id) {
        sourceService.deleteById(id);

        return new ListResponse(HttpStatus.OK.name());
    }
}
