package uz.akramovxm.unknownback.controller.admin;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.request.SubjectRequest;
import uz.akramovxm.unknownback.dto.response.ListResponse;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.dto.view.admin.AdminSubjectDTO;
import uz.akramovxm.unknownback.entity.Subject;
import uz.akramovxm.unknownback.mapper.SubjectMapper;
import uz.akramovxm.unknownback.marker.OnCreate;
import uz.akramovxm.unknownback.marker.OnUpdate;
import uz.akramovxm.unknownback.service.SubjectService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<AdminSubjectDTO> getAll() {
        List<AdminSubjectDTO> subjects = subjectService.findAll().stream()
                .map(subjectMapper::toAdminSubjectDTO).toList();

        return new ListResponse<>(HttpStatus.OK.name(), subjects);
    }

    @Validated(OnCreate.class)
    @PreAuthorize("hasAuthority('CREATE_SUBJECT')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<AdminSubjectDTO> create(@Valid @RequestBody SubjectRequest request) {
        Subject subject = subjectService.create(request);

        return new Response<>(HttpStatus.CREATED.name(), subjectMapper.toAdminSubjectDTO(subject));
    }

    @Validated(OnUpdate.class)
    @PreAuthorize("hasAuthority('UPDATE_SUBJECT')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<AdminSubjectDTO> update(@Valid @RequestBody SubjectRequest request, @PathVariable Long id) {
        Subject subject = subjectService.update(request, id);

        return new Response<>(HttpStatus.OK.name(), subjectMapper.toAdminSubjectDTO(subject));
    }

    @PreAuthorize("hasAuthority('DELETE_SUBJECT')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<AdminSubjectDTO> delete(@PathVariable Long id) {
        subjectService.deleteById(id);

        return new Response<>(HttpStatus.OK.name());
    }
}
