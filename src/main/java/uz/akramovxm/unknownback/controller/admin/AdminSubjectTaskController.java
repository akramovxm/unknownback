package uz.akramovxm.unknownback.controller.admin;

import org.hibernate.search.engine.search.query.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.response.ListResponse;
import uz.akramovxm.unknownback.dto.view.admin.AdminTaskDTO;
import uz.akramovxm.unknownback.entity.Task;
import uz.akramovxm.unknownback.mapper.TaskMapper;
import uz.akramovxm.unknownback.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/admin/subjects")
public class AdminSubjectTaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;


    @GetMapping("/{subjectId}/tasks")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<AdminTaskDTO> getAllBySubjectId(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "search", defaultValue = "") String search,
            @PathVariable Long subjectId
    ) {
        SearchResult<Task> result = taskService.findAllBySubjectId(search, page, size, subjectId);

        List<AdminTaskDTO> tasks = result.hits().stream().map(taskMapper::toAdminTaskDTO).toList();

        return new ListResponse<>(HttpStatus.OK.name(), tasks, result.total().hitCount(), page, size);
    }
}
