package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.entity.VerifyCode;
import uz.akramovxm.unknownback.repository.VerifyCodeRepository;
import uz.akramovxm.unknownback.service.VerifyCodeService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Autowired
    private VerifyCodeRepository verifyCodeRepository;

    @Override
    public Optional<VerifyCode> findByUserId(Long userId) {
        return verifyCodeRepository.findByUserId(userId);
    }

    @Override
    public VerifyCode save(VerifyCode verifyCode) {
        return verifyCodeRepository.save(verifyCode);
    }

    @Override
    public void deleteAllByExpiresAtBefore(LocalDateTime dateTime) {
        verifyCodeRepository.deleteAllByExpiresAtBefore(dateTime);
    }
}
