package uz.akramovxm.unknownback.controller.admin;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.request.TopicRequest;
import uz.akramovxm.unknownback.dto.response.ListResponse;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.dto.view.admin.AdminTopicDTO;
import uz.akramovxm.unknownback.dto.view.admin.AdminTopicTreeDTO;
import uz.akramovxm.unknownback.entity.Topic;
import uz.akramovxm.unknownback.mapper.TopicMapper;
import uz.akramovxm.unknownback.marker.OnCreate;
import uz.akramovxm.unknownback.marker.OnUpdate;
import uz.akramovxm.unknownback.service.TopicService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicMapper topicMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListResponse getAll(@RequestParam(value = "search", defaultValue = "") String search) {
        List<AdminTopicDTO> topics = topicService.findAll(search).stream()
                .map(topicMapper::toAdminTopicDTO).toList();

        return new ListResponse(HttpStatus.OK.name(), topics);
    }

    @GetMapping("/as-tree")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse getAllAsTree() {
        List<Topic> flatList = topicService.findAllOrdered();
        
        List<AdminTopicTreeDTO> topics = topicMapper.buildTopicTree(flatList);

        return new ListResponse(HttpStatus.OK.name(), topics);
    }

    @PreAuthorize("hasAuthority('CREATE_TOPIC')")
    @Validated(OnCreate.class)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@Valid @RequestBody TopicRequest request) {
        Topic topic = topicService.create(request);

        return new Response(HttpStatus.CREATED.name(), topicMapper.toAdminTopicTreeDTO(topic));
    }

    @PreAuthorize("hasAuthority('UPDATE_TOPIC')")
    @Validated(OnUpdate.class)
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response update(@Valid @RequestBody TopicRequest request, @PathVariable Long id) {
        Topic topic = topicService.update(request, id);

        return new Response(HttpStatus.CREATED.name(), topicMapper.toAdminTopicTreeDTO(topic));
    }

    @PreAuthorize("hasAuthority('DELETE_TOPIC')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse delete(@PathVariable Long id) {
        topicService.deleteById(id);

        return new ListResponse(HttpStatus.OK.name());
    }
}
