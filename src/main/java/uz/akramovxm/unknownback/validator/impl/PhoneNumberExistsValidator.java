package uz.akramovxm.unknownback.validator.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import uz.akramovxm.unknownback.service.UserService;
import uz.akramovxm.unknownback.validator.PhoneNumberExists;

public class PhoneNumberExistsValidator implements ConstraintValidator<PhoneNumberExists, String> {
    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        if (phoneNumber.isEmpty()) {
            phoneNumber = null;
        }
        return !userService.existsByPhoneNumberAndPhoneNumberNotNull(phoneNumber);
    }
}
