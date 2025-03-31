package uz.akramovxm.unknownback.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.entity.Role;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.repository.UserRepository;
import uz.akramovxm.unknownback.security.CurrentUserService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class UserValidationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CurrentUserService currentUserService;

    private static final Pattern PATTERN = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}");

    public void validateFirstName(String firstName, Map<String, String> errors) {
        if (firstName == null) {
            errors.put("firstName", "null");
        } else if (firstName.isEmpty()) {
            errors.put("firstName", "empty");
        }
    }
    public void validateLastName(String lastName, Map<String, String> errors) {
        if (lastName == null) {
            errors.put("lastName", "null");
        } else if (lastName.isEmpty()) {
            errors.put("lastName", "empty");
        }
    }

    public void validatePassword(String password, Map<String, String> errors) {
        if (password == null) {
            errors.put("password", "null");
        } else if (password.isEmpty()) {
            errors.put("password", "empty");
        }
    }

    public void validateEmail(String email, Map<String, String> errors) {
        if (email == null) {
            errors.put("email", "null");
        } else if (email.isEmpty()) {
            errors.put("email", "empty");
        } else if (!PATTERN.matcher(email).matches()) {
            errors.put("email", "email");
        }
        else {
            if (userRepository.existsByEmail(email)) {
                errors.put("email", "exists");
            }
        }
    }

    public void validateEmail(String email, Map<String, String> errors, Long id) {
        if (email == null) {
            errors.put("email", "null");
        } else if (email.isEmpty()) {
            errors.put("email", "empty");
        } else if (!PATTERN.matcher(email).matches()) {
            errors.put("email", "email");
        }
        else {
            if (userRepository.existsByEmailAndIdNot(email, id)) {
                errors.put("email", "exists");
            }
        }
    }

    public void validatePhoneNumber(String phoneNumber, Map<String, String> errors) {
        if (phoneNumber != null) {
            if (userRepository.existsByPhoneNumberAndPhoneNumberNotNull(phoneNumber)) {
                errors.put("phoneNumber", "exists");
            }
        }
    }

    public void validatePhoneNumber(String phoneNumber, Map<String, String> errors, Long id) {
        if (phoneNumber != null) {
            if (userRepository.existsByPhoneNumberAndPhoneNumberNotNullAndIdNot(phoneNumber, id)) {
                errors.put("phoneNumber", "exists");
            }
        }
    }

    public void validateBirthDate(String birthDate, Map<String, String> errors) {
        if (birthDate != null) {
            try {
                LocalDate localDate = LocalDate.parse(birthDate);
            } catch (DateTimeParseException e) {
                errors.put("birthDate", "matDatepickerParse");
            }
        }
    }

    public void validateRole(String role, Map<String, String> errors) {
        if (role == null) {
            errors.put("role", "null");
        } else {
            Role r;

            try {
                r = Role.valueOf(role);
            } catch (IllegalArgumentException e) {
                errors.put("role", "invalid");
                return;
            }

            User currentUser = currentUserService.getCurrentUser();
            if (currentUser.getRole().ordinal() > r.ordinal()) {
                errors.put("role", "notAllowed");
            }
        }
    }
}
