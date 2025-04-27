package uz.akramovxm.unknownback.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import uz.akramovxm.unknownback.dto.request.MeRequest;
import uz.akramovxm.unknownback.dto.request.SelectAnswerRequest;
import uz.akramovxm.unknownback.dto.request.TestRequest;
import uz.akramovxm.unknownback.dto.request.UpdatePasswordRequest;
import uz.akramovxm.unknownback.dto.response.ListResponse;
import uz.akramovxm.unknownback.dto.response.Response;
import uz.akramovxm.unknownback.dto.view.TaskSnapshotDTO;
import uz.akramovxm.unknownback.dto.view.TestSessionDTO;
import uz.akramovxm.unknownback.dto.view.UserDTO;
import uz.akramovxm.unknownback.entity.TaskSnapshot;
import uz.akramovxm.unknownback.entity.TestSession;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.mapper.TaskSnapshotMapper;
import uz.akramovxm.unknownback.mapper.TestSessionMapper;
import uz.akramovxm.unknownback.mapper.UserMapper;
import uz.akramovxm.unknownback.service.MeService;
import uz.akramovxm.unknownback.service.TaskSnapshotService;
import uz.akramovxm.unknownback.service.TestSessionService;

import java.util.List;

@RestController
@RequestMapping("/me")
public class MeController {
    @Autowired
    private MeService meService;
    @Autowired
    private TestSessionService testSessionService;
    @Autowired
    private TaskSnapshotService taskSnapshotService;
    @Autowired
    private TestSessionMapper testSessionMapper;
    @Autowired
    private TaskSnapshotMapper taskSnapshotMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Response<UserDTO> getMe() {
        User user = meService.getCurrentUser();

        return new Response<>(HttpStatus.OK.name(), userMapper.toUserDTO(user));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Response<UserDTO> updateMe(@Valid @RequestBody MeRequest request) {
        User user = meService.update(request);

        return new Response<>(HttpStatus.OK.name(), userMapper.toUserDTO(user));
    }

    @PutMapping("/update-password")
    @ResponseStatus(HttpStatus.OK)
    public Response<UserDTO> updatePassword(@Valid @RequestBody UpdatePasswordRequest request) {
        meService.updatePassword(request);

        return new Response<>(HttpStatus.OK.name());
    }

    @GetMapping("/test/all")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<TestSessionDTO> getTestSessions() {
        List<TestSessionDTO> testSessions = testSessionService.findAllForCurrentUser().stream()
                .map(t -> testSessionMapper.toTestSessionDTO(t, true)).toList();

        return new ListResponse<>(HttpStatus.OK.name(), testSessions);
    }

    @GetMapping("/test/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<TestSessionDTO> getTestSessionById(@PathVariable Long id) {
        TestSession testSession = testSessionService.getByIdForCurrentUser(id);

        return new Response<>(HttpStatus.OK.name(), testSessionMapper.toTestSessionDTO(testSession, true));
    }

    @GetMapping("/test/current")
    @ResponseStatus(HttpStatus.OK)
    public Response<TestSessionDTO> getTestCurrentUser() {
        TestSession testSession = testSessionService.findInProgressForCurrentUser().orElse(null);

        return new Response<>(HttpStatus.OK.name(), testSessionMapper.toTestSessionDTO(testSession, false));
    }

    @PostMapping("/test/start")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<TestSessionDTO> start(@Valid @RequestBody TestRequest request) {
        TestSession testSession = testSessionService.start(request);

        return new Response<>(HttpStatus.CREATED.name(), testSessionMapper.toTestSessionDTO(testSession, false));
    }

    @PutMapping("/test/select-answer")
    @ResponseStatus(HttpStatus.OK)
    public Response<TaskSnapshotDTO> selectAnswer(@Valid @RequestBody SelectAnswerRequest request) {
        TaskSnapshot taskSnapshot = taskSnapshotService.selectAnswer(request);

        return new Response<>(HttpStatus.OK.name(), taskSnapshotMapper.toTaskSnapshotDTO(taskSnapshot, false));
    }

    @PutMapping("/test/timeout")
    @ResponseStatus(HttpStatus.OK)
    public Response<TestSessionDTO> timeout() {
        TestSession testSession = testSessionService.timeoutTestForCurrentUser();

        return new Response<>(HttpStatus.OK.name(), testSessionMapper.toTestSessionDTO(testSession, true));
    }

    @PutMapping("/test/finish")
    @ResponseStatus(HttpStatus.OK)
    public Response<TestSessionDTO> finish() {
        TestSession testSession = testSessionService.finishTestForCurrentUser();

        return new Response<>(HttpStatus.OK.name(), testSessionMapper.toTestSessionDTO(testSession, true));
    }
}
