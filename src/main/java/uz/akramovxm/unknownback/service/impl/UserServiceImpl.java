package uz.akramovxm.unknownback.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.dto.request.UpdatePasswordRequest;
import uz.akramovxm.unknownback.entity.AuthProvider;
import uz.akramovxm.unknownback.entity.Role;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.UserRepository;
import uz.akramovxm.unknownback.security.oauth2.user.OAuth2UserInfo;
import uz.akramovxm.unknownback.service.UserService;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException(User.class.getSimpleName(), "email", email)
        );
    }

    @Override
    public User create(String firstName, String lastName, String email, String password,
                       String phoneNumber, LocalDate birthDate, Role role, AuthProvider provider,
                       boolean locked, boolean enabled) {
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .role(role)
                .provider(provider)
                .locked(locked)
                .enabled(enabled)
                .build();

        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            user.setPhoneNumber(phoneNumber);
        }

        if (password != null && !password.isEmpty()) {
            user.setPassword(passwordEncoder.encode(password));
        }
        if (birthDate != null) {
            user.setBirthDate(birthDate);
        }

        return userRepository.save(user);
    }

    @Override
    public User create(OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo) {
        return create(
                oAuth2UserInfo.getFirstName(),
                oAuth2UserInfo.getLastName(),
                oAuth2UserInfo.getEmail(),
                null,
                null,
                null,
                Role.PUPIL,
                AuthProvider.valueOf(userRequest.getClientRegistration().getRegistrationId()),
                false,
                true
        );
    }

    @Override
    public User update(User user, OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo) {
        if (oAuth2UserInfo.getFirstName() != null && !oAuth2UserInfo.getFirstName().isEmpty()) {
            user.setFirstName(oAuth2UserInfo.getFirstName());
        }
        if (oAuth2UserInfo.getLastName() != null && !oAuth2UserInfo.getLastName().isEmpty()) {
            user.setLastName(oAuth2UserInfo.getLastName());
        }

        user.setProvider(AuthProvider.valueOf(userRequest.getClientRegistration().getRegistrationId()));

        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updatePassword(UpdatePasswordRequest request) {
        User user = findByEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhoneNumberAndPhoneNumberNotNull(String phoneNumber) {
        return userRepository.existsByPhoneNumberAndPhoneNumberNotNull(phoneNumber);
    }
}
