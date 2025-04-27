package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.dto.request.TestRequest;
import uz.akramovxm.unknownback.entity.*;
import uz.akramovxm.unknownback.exception.BadRequestException;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.TestSessionRepository;
import uz.akramovxm.unknownback.security.CurrentUserService;
import uz.akramovxm.unknownback.service.SubjectService;
import uz.akramovxm.unknownback.service.TaskService;
import uz.akramovxm.unknownback.service.TestSessionService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class TestSessionServiceImpl implements TestSessionService {
    @Autowired
    private TestSessionRepository testSessionRepository;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private CurrentUserService currentUserService;
    @Autowired
    private TaskService taskService;

    @Override
    public TestSession start(TestRequest request) {
        boolean hasCurrentTest = testSessionRepository.existsByUserIdAndStatus(
                currentUserService.getCurrentUser().getId(), TestStatus.IN_PROCESS);
        if (hasCurrentTest) {
            throw new BadRequestException("Test session already exists");
        }

        TestSession testSession = new TestSession();

        List<TaskGroup> taskGroups = new ArrayList<>();

        int seq = 1;

        taskGroups.add(createTaskGroup(testSession, request.getFirstSubjectId(),
                GroupType.SPECIALITY, seq, 30));

        seq++;

        if (request.getSecondSubjectId() != null) {
            taskGroups.add(createTaskGroup(testSession, request.getSecondSubjectId(),
                GroupType.SPECIALITY, seq, 30));

            seq++;


        }

        testSession.setStartTime(LocalDateTime.now());
        testSession.setEndTime(LocalDateTime.now().plusHours(1));
        testSession.setStatus(TestStatus.IN_PROCESS);
        testSession.setUser(currentUserService.getCurrentUser());
        testSession.setTaskGroups(taskGroups);

        return testSessionRepository.save(testSession);
    }

    private TaskGroup createTaskGroup(TestSession testSession, Long subjectId,
                                      GroupType type, int seq, int tasksCount) {
        Subject subject = subjectService.getById(subjectId);

        TaskGroup taskGroup = new TaskGroup();

        taskGroup.setType(type);
        taskGroup.setSeq(seq);
        taskGroup.setSubject(subject);
        taskGroup.setTestSession(testSession);
        taskGroup.setTasks(createTaskSnapshots(taskGroup, subjectId, tasksCount));

        return taskGroup;
    }

    private List<TaskSnapshot> createTaskSnapshots(TaskGroup taskGroup, Long subjectId, int tasksCount) {
        PageRequest request = PageRequest.of(0, tasksCount);

        List<Task> tasks = taskService.getBySubjectId(subjectId, request);

        return tasks.stream().map(task -> {
            TaskSnapshot taskSnapshot = new TaskSnapshot();

            List<AnswerSnapshot> answerSnapshots = createAnswerSnapshots(task, taskSnapshot);

            taskSnapshot.setContentUz(task.getContentUz());
            taskSnapshot.setContentRu(task.getContentRu());
            taskSnapshot.setLevel(task.getLevel());
            taskSnapshot.setType(task.getType());
            taskSnapshot.setRowAnswers(task.isRowAnswers());
            taskSnapshot.setSubject(task.getSubject());
            taskSnapshot.setTopic(task.getTopic());
            taskSnapshot.setSource(task.getSource());
            taskSnapshot.setAnswers(answerSnapshots);
            taskSnapshot.setTaskGroup(taskGroup);
            taskSnapshot.setTask(task);
            return taskSnapshot;
        }).toList();
    }

    private List<AnswerSnapshot> createAnswerSnapshots(Task task, TaskSnapshot taskSnapshot) {
        return task.getAnswers().stream().map(answer -> new AnswerSnapshot(
                answer.getValueUz(),
                answer.getValueRu(),
                answer.isCorrect(),
                taskSnapshot,
                answer
        )).toList();
    }

    @Override
    public TestSession getByIdForCurrentUser(Long id) {
        return testSessionRepository.findByUserIdAndId(currentUserService.getCurrentUser().getId(), id).orElseThrow(
                () -> new ResourceNotFoundException(TestSession.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public Optional<TestSession> findInProgressForCurrentUser() {
        return testSessionRepository.findByUserIdAndStatus(currentUserService.getCurrentUser().getId(), TestStatus.IN_PROCESS);
    }

    @Override
    public TestSession finishTestForCurrentUser() {
        Optional<TestSession> session = findInProgressForCurrentUser();

        session.ifPresent(testSession -> {
            testSession.setFinishTime(LocalDateTime.now());
            testSession.setStatus(TestStatus.COMPLETED);
            testSessionRepository.save(session.get());
        });

        return session.orElse(null);
    }

    @Override
    public List<TestSession> findAllForCurrentUser() {
        return testSessionRepository.findAllByUserIdAndStatusNotOrderByCreatedAtDesc(
                currentUserService.getCurrentUser().getId(), TestStatus.IN_PROCESS
        );
    }

    @Override
    public TestSession timeoutTestForCurrentUser() {
        Optional<TestSession> session = findInProgressForCurrentUser();

        session.ifPresent(testSession -> {
            testSession.setFinishTime(LocalDateTime.now());
            AtomicReference<TestStatus> status = new AtomicReference<>(TestStatus.COMPLETED);
            testSession.getTaskGroups().forEach(taskGroup -> {
                taskGroup.getTasks().forEach(task -> {
                    if (task.getSelectedAnswer() == null) {
                        status.set(TestStatus.TIMEOUT);
                    }
                });
            });
            testSession.setStatus(status.get());
            testSessionRepository.save(session.get());
        });

        return session.orElse(null);
    }
}
