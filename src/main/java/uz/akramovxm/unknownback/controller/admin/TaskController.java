package uz.akramovxm.unknownback.controller.admin;

import jakarta.validation.Valid;
import org.hibernate.search.engine.search.query.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.request.IDRequest;
import uz.akramovxm.unknownback.dto.request.TaskRequest;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.dto.view.admin.AdminTaskDTO;
import uz.akramovxm.unknownback.entity.Task;
import uz.akramovxm.unknownback.mapper.TaskMapper;
import uz.akramovxm.unknownback.marker.OnCreate;
import uz.akramovxm.unknownback.marker.OnUpdate;
import uz.akramovxm.unknownback.service.TaskService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskMapper taskMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Response getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "search", defaultValue = "") String search
    ) {
        SearchResult<Task> result = taskService.getAll(search, page, size);

        List<AdminTaskDTO> tasks = result.hits().stream().map(taskMapper::toAdminTaskDTO).toList();

        return new Response(HttpStatus.OK.name(), tasks, result.total().hitCount(), page, size);
    }

    @Validated(OnCreate.class)
    @PreAuthorize("hasAuthority('CREATE_TASK')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@Valid @RequestBody TaskRequest request) {
        Task task = taskService.create(request);

        return new Response(HttpStatus.CREATED.name(), taskMapper.toAdminTaskDTO(task));
    }

    @Validated(OnUpdate.class)
    @PreAuthorize("hasAuthority('UPDATE_TASK')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response update(@Valid @RequestBody TaskRequest request, @PathVariable Long id) {
        Task task = taskService.update(request, id);

        return new Response(HttpStatus.OK.name(), taskMapper.toAdminTaskDTO(task));
    }

    @PreAuthorize("hasAuthority('DELETE_TASK')")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Response delete(@Valid @RequestBody IDRequest request) {
        taskService.delete(request);

        return new Response(HttpStatus.OK.name());
    }
}
