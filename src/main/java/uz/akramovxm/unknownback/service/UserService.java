package uz.akramovxm.unknownback.service;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import uz.akramovxm.unknownback.dto.request.UpdatePasswordRequest;
import uz.akramovxm.unknownback.entity.AuthProvider;
import uz.akramovxm.unknownback.entity.Role;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.security.oauth2.user.OAuth2UserInfo;

import java.time.LocalDate;

public interface UserService {
    User findByEmail(String email);
    User create(String firstName, String lastName, String email, String password,
                String phoneNumber, LocalDate birthDate, Role role, AuthProvider provider,
                boolean locked, boolean enabled);
    User create(OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo);
    User update(User user, OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo);
    User save(User user);
    void updatePassword(UpdatePasswordRequest request);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumberAndPhoneNumberNotNull(String phoneNumber);
}
