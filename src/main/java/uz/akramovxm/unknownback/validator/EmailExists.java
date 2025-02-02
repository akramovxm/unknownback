package uz.akramovxm.unknownback.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import uz.akramovxm.unknownback.validator.impl.EmailExistsValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailExistsValidator.class)
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailExists {
    String message() default "Email is already taken";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
