package uz.akramovxm.unknownback.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.request.auth.*;
import uz.akramovxm.unknownback.dto.response.AuthResponse;
import uz.akramovxm.unknownback.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        String token = authService.login(request);

        return new AuthResponse(token, HttpStatus.OK.name());
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);

        return new AuthResponse("Registration completed successfully. Check and verify your email");
    }

    @PostMapping("/verify-registration")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse verifyRegistration(@Valid @RequestBody VerifyRequest request) {
        authService.verifyRegistration(request);

        return new AuthResponse("Verification completed successfully");
    }

    @PostMapping("/verify-recovery")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse verifyRecovery(@Valid @RequestBody VerifyRequest request) {
        String token = authService.verifyRecovery(request);

        return new AuthResponse(token, "Verification completed successfully");
    }

    @PostMapping("/send-code")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse sendCode(@Valid @RequestBody SendCodeRequest request) {
        authService.sendCode(request);

        return new AuthResponse("The verification code has been sent. Check your mail");
    }

    @PostMapping("/set-password")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse setPassword(@Valid @RequestBody SetPasswordRequest request) {
        authService.setPassword(request);

        return new AuthResponse("Password set successfully");
    }
}
