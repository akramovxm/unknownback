package uz.akramovxm.unknownback.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.service.VerifyCodeService;

import java.time.LocalDateTime;

@Service
public class VerifyCodeCleanService {
    @Autowired
    private VerifyCodeService verifyCodeService;

    @Scheduled(fixedRate = 60_000)
    public void clean() {
        verifyCodeService.deleteAllByExpiresAtBefore(LocalDateTime.now());
    }
}
