package uz.akramovxm.unknownback.validator.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import uz.akramovxm.unknownback.service.UserService;
import uz.akramovxm.unknownback.validator.EmailExists;

public class EmailExistsValidator implements ConstraintValidator<EmailExists, String> {
    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.existsByEmail(email);
    }
}
