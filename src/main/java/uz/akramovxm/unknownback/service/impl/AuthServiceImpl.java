package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.akramovxm.unknownback.dto.request.*;
import uz.akramovxm.unknownback.entity.*;
import uz.akramovxm.unknownback.exception.RequestBodyNotValidException;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.security.jwt.JWTProvider;
import uz.akramovxm.unknownback.service.AuthService;
import uz.akramovxm.unknownback.service.MessageService;
import uz.akramovxm.unknownback.service.UserService;

import java.util.Map;
import java.util.Random;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTProvider jwtProvider;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @Override
    public String login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userService.getByEmail(request.getEmail());

        Map<String, Object> claims = Map.of(
                "authorities", user.getAuthorities(),
                "role", user.getRole()
        );

        return jwtProvider.generateToken(claims, user.getUsername());
    }

    @Transactional
    @Override
    public void register(RegisterRequest request) {
        userService.create(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                request.getPhoneNumber(),
                request.getBirthDate(),
                Role.PUPIL,
                AuthProvider.local,
                false,
                false
        );

        sendCode(new SendCodeRequest(request.getEmail()));
    }

    @Transactional
    @Override
    public void verify(VerifyRequest request) {
        User user = userService.getByEmail(request.getEmail());

        VerifyCode verifyCode = user.getVerifyCode();

        if (verifyCode == null || !verifyCode.getCode().equals(request.getVerifyCode())) {
            throw new MailAuthenticationException("Verification Failed");
        }

        user.setVerifyCode(null);
        user.setEnabled(true);

        userService.save(user);
    }

    @Transactional
    @Override
    public void sendCode(SendCodeRequest request) {
        User user;

        try {
            user = userService.getByEmail(request.getEmail());
        } catch (ResourceNotFoundException e) {
            throw new RequestBodyNotValidException(Map.of("email", "Email not found"));
        }
        Random random = new Random();
        String code = String.format("%04d", random.nextInt(10000));

        if (user.getVerifyCode() == null) {
            VerifyCode verifyCode = new VerifyCode(user, code);
            user.setVerifyCode(verifyCode);
        } else {
            user.getVerifyCode().setCode(code);
        }

        userService.save(user);

        messageService.sendVerifyCode(request.getEmail(), code);
    }
}
