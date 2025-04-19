package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.entity.VerifyToken;
import uz.akramovxm.unknownback.repository.VerifyTokenRepository;
import uz.akramovxm.unknownback.service.VerifyTokenService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VerifyTokenServiceImpl implements VerifyTokenService {
    @Autowired
    private VerifyTokenRepository verifyTokenRepository;

    @Override
    public Optional<VerifyToken> findByUserId(Long userId) {
        return verifyTokenRepository.findByUserId(userId);
    }

    @Override
    public Optional<VerifyToken> findByToken(String token) {
        return verifyTokenRepository.findByToken(token);
    }

    @Override
    public VerifyToken save(VerifyToken verifyToken) {
        return verifyTokenRepository.save(verifyToken);
    }

    @Override
    public void deleteAllByExpiresAtBefore(LocalDateTime dateTime) {
        verifyTokenRepository.deleteAllByExpiresAtBefore(dateTime);
    }
}
