package uz.akramovxm.unknownback.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.request.auth.*;
import uz.akramovxm.unknownback.dto.response.AuthResponse;
import uz.akramovxm.unknownback.entity.VerifyToken;
import uz.akramovxm.unknownback.service.AuthService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        String token = authService.login(request);

        return new AuthResponse(HttpStatus.OK.name(), token);
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        LocalDateTime expiresAt = authService.register(request);

        return new AuthResponse(HttpStatus.CREATED.name(), expiresAt);
    }

    @PostMapping("/verify-registration")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse verifyRegistration(@Valid @RequestBody VerifyRequest request) {
        authService.verifyRegistration(request);

        return new AuthResponse(HttpStatus.OK.name());
    }

    @PostMapping("/verify-recovery")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse verifyRecovery(@Valid @RequestBody VerifyRequest request) {
        VerifyToken verifyToken = authService.verifyRecovery(request);

        return new AuthResponse(HttpStatus.OK.name(), verifyToken.getToken(), verifyToken.getExpiresAt());
    }

    @PostMapping("/send-code")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse sendCode(@Valid @RequestBody SendCodeRequest request) {
        LocalDateTime expiresAt = authService.sendCode(request);

        return new AuthResponse(HttpStatus.OK.name(), expiresAt);
    }

    @PostMapping("/set-password")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse setPassword(@Valid @RequestBody SetPasswordRequest request) {
        authService.setPassword(request);

        return new AuthResponse(HttpStatus.OK.name());
    }
}
