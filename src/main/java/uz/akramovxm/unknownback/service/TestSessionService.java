package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.dto.request.TestRequest;
import uz.akramovxm.unknownback.entity.TestSession;

import java.util.List;
import java.util.Optional;

public interface TestSessionService {
    TestSession start(TestRequest request);

    TestSession getByIdForCurrentUser(Long id);

    Optional<TestSession> findInProgressForCurrentUser();

    TestSession finishTestForCurrentUser();

    List<TestSession> findAllForCurrentUser();

    TestSession timeoutTestForCurrentUser();
}
