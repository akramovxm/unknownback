package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.akramovxm.unknownback.dto.request.*;
import uz.akramovxm.unknownback.entity.AuthProvider;
import uz.akramovxm.unknownback.entity.Role;
import uz.akramovxm.unknownback.entity.User;
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

        User user = userService.findByEmail(request.getEmail());

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

        sendCode(new ResendCodeRequest(request.getEmail()));
    }

    @Override
    public void verify(VerifyRequest request) {
        User user = userService.findByEmail(request.getEmail());
        String verifyCode = user.getVerifyCode();

        if (verifyCode == null || !verifyCode.equals(request.getVerifyCode())) {
            throw new MailAuthenticationException("The verification code is invalid");
        }

        user.setVerifyCode(null);

        user.setEnabled(true);

        userService.save(user);
    }

    @Override
    public void sendCode(ResendCodeRequest request) {
        User user;

        try {
            user = userService.findByEmail(request.getEmail());
        } catch (ResourceNotFoundException e) {
            throw new RequestBodyNotValidException(Map.of("email", "Email not found"));
        }

        Random random = new Random();
        String verifyCode = String.format("%04d", random.nextInt(10000));

        user.setVerifyCode(verifyCode);

        userService.save(user);

        messageService.sendVerifyCode(request.getEmail(), verifyCode);
    }
}
