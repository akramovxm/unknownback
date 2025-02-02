package uz.akramovxm.unknownback.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import uz.akramovxm.unknownback.validator.impl.PhoneNumberExistsValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberExistsValidator.class)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberExists {
    String message() default "Phone Number is already taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
