package uz.akramovxm.unknownback.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.service.VerifyTokenService;

import java.time.LocalDateTime;

@Service
public class VerifyTokenCleanService {
    @Autowired
    private VerifyTokenService verifyTokenService;

    @Scheduled(fixedRate = 60_000)
    public void clean() {
        verifyTokenService.deleteAllByExpiresAtBefore(LocalDateTime.now());
    }
}
