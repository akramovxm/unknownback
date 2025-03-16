package uz.akramovxm.unknownback.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.dto.view.admin.AdminTaskDTO;
import uz.akramovxm.unknownback.mapper.TaskMapper;
import uz.akramovxm.unknownback.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicTaskController {
//    @Autowired
//    private TaskService taskService;
//    @Autowired
//    private TaskMapper taskMapper;
//
//    @GetMapping("/{path}/tasks")
//    @ResponseStatus(HttpStatus.OK)
//    public Response getAllTopicTasks(@PathVariable String path) {
//        List<AdminTaskDTO> tasks = taskService.getByTopicPath(path).stream()
//                .map(taskMapper::toAdminTaskDTO).toList();
//
//        return new Response(HttpStatus.OK.name(), tasks);
//    }
}
