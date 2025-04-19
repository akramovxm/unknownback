package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.entity.VerifyCode;
import uz.akramovxm.unknownback.service.MessageService;
import uz.akramovxm.unknownback.service.SendCodeService;
import uz.akramovxm.unknownback.service.VerifyCodeService;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class SendCodeServiceImpl implements SendCodeService {
    @Autowired
    private VerifyCodeService verifyCodeService;
    @Autowired
    private MessageService messageService;

    @Override
    public LocalDateTime send(User user) {
        Random random = new Random();
        String code = String.format("%04d", random.nextInt(10000));

        VerifyCode verifyCode = verifyCodeService.findByUserId(user.getId()).orElse(
                new VerifyCode(user)
        );

        verifyCode.setCode(code);

        verifyCode.setExpiresAt(LocalDateTime.now().plusMinutes(10));

        verifyCodeService.save(verifyCode);

        messageService.sendVerifyCode(user.getEmail(), code);

        return verifyCode.getExpiresAt();
    }
}
