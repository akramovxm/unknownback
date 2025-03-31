package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.akramovxm.unknownback.dto.request.auth.*;
import uz.akramovxm.unknownback.entity.*;
import uz.akramovxm.unknownback.exception.BadRequestException;
import uz.akramovxm.unknownback.exception.RequestBodyNotValidException;
import uz.akramovxm.unknownback.security.jwt.JWTProvider;
import uz.akramovxm.unknownback.service.AuthService;
import uz.akramovxm.unknownback.service.SendCodeService;
import uz.akramovxm.unknownback.service.UserService;
import uz.akramovxm.unknownback.service.VerifyTokenService;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTProvider jwtProvider;
    @Autowired
    private UserService userService;
    @Autowired
    private VerifyTokenService verifyTokenService;
    @Autowired
    private SendCodeService sendCodeService;

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
        User user = userService.create(request);

        sendCodeService.send(user);
    }

    @Transactional
    @Override
    public void verifyRegistration(VerifyRequest request) {
        User user = userService.getByEmail(request.getEmail());

        verify(user, request);

        userService.setEnabled(user, true);
    }

    @Override
    public String verifyRecovery(VerifyRequest request) {
        User user = userService.getByEmail(request.getEmail());

        verify(user, request);

        String token = UUID.randomUUID().toString();

        VerifyToken verifyToken = new VerifyToken(user, token, LocalDateTime.now().plusMinutes(10));

        verifyTokenService.save(verifyToken);

        return token;
    }

    @Transactional
    @Override
    public void sendCode(SendCodeRequest request) {
        User user = userService.findByEmail(request.getEmail()).orElseThrow(
                () -> new RequestBodyNotValidException(Map.of("email", "notFound"))
        );

        sendCodeService.send(user);
    }

    @Transactional
    @Override
    public void setPassword(SetPasswordRequest request) {
        VerifyToken verifyToken = verifyTokenService.findByToken(request.getToken()).orElseThrow(
                () -> new BadRequestException("Invalid or expired token")
        );

        User user = verifyToken.getUser();

        user.setVerifyToken(null);

        userService.setPassword(user, request.getPassword());
    }

    private void verify(User user, VerifyRequest request) {
        VerifyCode verifyCode = user.getVerifyCode();

        if (verifyCode == null || !verifyCode.getCode().equals(request.getVerifyCode())) {
            throw new RequestBodyNotValidException(Map.of("verifyCode", "incorrect"));
        }

        user.setVerifyCode(null);
    }
}
