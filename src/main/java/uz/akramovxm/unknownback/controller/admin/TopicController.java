package uz.akramovxm.unknownback.controller.admin;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.request.TopicRequest;
import uz.akramovxm.unknownback.dto.request.TopicSeqRequest;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.dto.view.admin.AdminTopicDTO;
import uz.akramovxm.unknownback.dto.view.admin.AdminTopicTreeDTO;
import uz.akramovxm.unknownback.entity.Topic;
import uz.akramovxm.unknownback.mapper.TopicMapper;
import uz.akramovxm.unknownback.marker.OnCreate;
import uz.akramovxm.unknownback.service.TopicService;

import java.util.Collection;
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
    public Response getAll(@RequestParam(value = "search", defaultValue = "") String search) {
        List<AdminTopicDTO> topics = topicService.findAll(search).stream()
                .map(topicMapper::toAdminTopicDTO).toList();

        return new Response(HttpStatus.OK.name(), topics);
    }

    @GetMapping("/as-tree")
    @ResponseStatus(HttpStatus.OK)
    public Response getAllAsTree() {
        List<AdminTopicTreeDTO> topics = topicService.findAllByParentIsNullOrderBySeqAsc().stream()
                .map(topicMapper::toAdminTopicTreeDTO).toList();

        return new Response(HttpStatus.OK.name(), topics);
    }

    @GetMapping("/{path}")
    @ResponseStatus(HttpStatus.OK)
    public Response getByPath(@PathVariable String path) {
        Topic topic = topicService.getByPath(path);

        return new Response(HttpStatus.OK.name(), topicMapper.toAdminTopicTreeDTO(topic));
    }

    @PreAuthorize("hasAuthority('UPDATE_TOPIC')")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Response update(@RequestBody Collection<TopicSeqRequest> requests) {
        topicService.update(requests);

        return new Response(HttpStatus.OK.name());
    }

    @PreAuthorize("hasAuthority('UPDATE_TOPIC')")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response updateById(@Valid @RequestBody TopicRequest request, @PathVariable Long id) {
        Topic topic = topicService.updateById(request, id);

        return new Response(HttpStatus.OK.name(), topicMapper.toAdminTopicTreeDTO(topic));
    }

    @PreAuthorize("hasAuthority('CREATE_TOPIC')")
    @Validated(OnCreate.class)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response create(@Valid @RequestBody TopicRequest request) {
        Topic topic = topicService.create(request);

        return new Response(HttpStatus.CREATED.name(), topicMapper.toAdminTopicTreeDTO(topic));
    }

    @PreAuthorize("hasAuthority('DELETE_TOPIC')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response delete(@PathVariable Long id) {
        topicService.deleteById(id);

        return new Response(HttpStatus.OK.name());
    }
}
