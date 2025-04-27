package uz.akramovxm.unknownback.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.response.ListResponse;
import uz.akramovxm.unknownback.dto.view.admin.AdminTopicDTO;
import uz.akramovxm.unknownback.dto.view.admin.AdminTopicTreeDTO;
import uz.akramovxm.unknownback.entity.Topic;
import uz.akramovxm.unknownback.mapper.TopicMapper;
import uz.akramovxm.unknownback.service.TopicService;

import java.util.List;

@RestController
@RequestMapping("/admin/subjects")
public class AdminSubjectTopicController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private TopicMapper topicMapper;

    @GetMapping("/{subjectId}/topics")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<AdminTopicDTO> getAllBySubjectId(
            @RequestParam(value = "search", defaultValue = "") String search,
            @PathVariable Long subjectId
    ) {
        List<AdminTopicDTO> topics = topicService.findAllBySubjectId(search, subjectId).stream()
                .map(topicMapper::toAdminTopicDTO).toList();

        return new ListResponse<>(HttpStatus.OK.name(), topics);
    }

    @GetMapping("/{subjectId}/topics/as-tree")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<AdminTopicTreeDTO> getAllBySubjectIdAsTree(@PathVariable Long subjectId) {
        List<Topic> flatList = topicService.findAllBySubjectIdOrdered(subjectId);

        List<AdminTopicTreeDTO> topics = topicMapper.buildTopicTree(flatList);

        return new ListResponse<>(HttpStatus.OK.name(), topics);
    }
}
