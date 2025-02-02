package uz.akramovxm.unknownback.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.akramovxm.unknownback.dto.request.*;
import uz.akramovxm.unknownback.dto.response.AuthResponse;
import uz.akramovxm.unknownback.service.AuthService;
import uz.akramovxm.unknownback.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;

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

    @PostMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse verify(@Valid @RequestBody VerifyRequest request) {
        authService.verify(request);

        return new AuthResponse("Verification completed successfully");
    }

    @PostMapping("/resend-code")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse resendCode(@Valid @RequestBody ResendCodeRequest request) {
        authService.sendCode(request);

        return new AuthResponse("The verification code has been re-sent. Check your mail");
    }

    @PostMapping("/update-password")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse updatePassword(@Valid @RequestBody UpdatePasswordRequest request) {
        userService.updatePassword(request);

        return new AuthResponse("Password updated successfully");
    }
}
