package uz.akramovxm.unknownback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.response.ListResponse;
import uz.akramovxm.unknownback.dto.view.SubjectDTO;
import uz.akramovxm.unknownback.mapper.SubjectMapper;
import uz.akramovxm.unknownback.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<SubjectDTO> getAll() {
        List<SubjectDTO> subjects = subjectService.findAll().stream()
                .map(subjectMapper::toSubjectDTO).toList();

        return new ListResponse<>(HttpStatus.OK.name(), subjects);
    }
}
