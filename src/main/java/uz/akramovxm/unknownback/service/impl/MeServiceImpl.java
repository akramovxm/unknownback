package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.dto.request.MeRequest;
import uz.akramovxm.unknownback.dto.request.UpdatePasswordRequest;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.exception.RequestBodyNotValidException;
import uz.akramovxm.unknownback.security.CurrentUserService;
import uz.akramovxm.unknownback.service.MeService;
import uz.akramovxm.unknownback.service.UserService;
import uz.akramovxm.unknownback.service.validation.UserValidationService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class MeServiceImpl implements MeService {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidationService userValidationService;
    @Autowired
    private CurrentUserService currentUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getCurrentUser() {
        return userService.getByEmail(currentUserService.getEmail());
    }

    @Override
    public User update(MeRequest request) {
        User user = getCurrentUser();

        Map<String, String> errors = new HashMap<>();

        userValidationService
                .validateFirstName(request.getFirstName(), errors)
                .validateLastName(request.getLastName(), errors)
                .validatePhoneNumber(request.getPhoneNumber(), errors, user.getId())
                .validateBirthDate(request.getBirthDate(), errors);

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());

        LocalDate birthDate = null;
        if (request.getBirthDate() != null) {
            birthDate = LocalDate.parse(request.getBirthDate());
        }
        user.setBirthDate(birthDate);

        return userService.save(user);
    }

    @Override
    public void updatePassword(UpdatePasswordRequest request) {
        User user = getCurrentUser();

        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            Map<String, String> errors = Map.of("oldPassword", "incorrect");
            throw new RequestBodyNotValidException(errors);
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        userService.save(user);
    }
}
