package uz.akramovxm.unknownback.service;

import org.hibernate.search.engine.search.query.SearchResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import uz.akramovxm.unknownback.dto.request.IDRequest;
import uz.akramovxm.unknownback.dto.request.SetPasswordRequest;
import uz.akramovxm.unknownback.dto.request.UpdatePasswordRequest;
import uz.akramovxm.unknownback.dto.request.UserRequest;
import uz.akramovxm.unknownback.entity.AuthProvider;
import uz.akramovxm.unknownback.entity.Role;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.security.oauth2.user.OAuth2UserInfo;

import java.time.LocalDate;

public interface UserService {
    SearchResult<User> getAll(String search, int page, int size, String sortBy, String sortType);

    User getById(Long id);

    User getByEmail(String email);

    User create(String firstName, String lastName, String email, String password,
                String phoneNumber, LocalDate birthDate, Role role, AuthProvider provider,
                boolean locked, boolean enabled);

    User create(OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo);

    User create(UserRequest request);

    User update(User user, OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo);

    User update(UserRequest request, Long id);

    User update(UserRequest request, Authentication authentication);

    void updatePassword(UpdatePasswordRequest request, Authentication authentication);

    User save(User user);

    void setPassword(SetPasswordRequest request);

    void delete(IDRequest request);

    void lock(IDRequest request);

    void unlock(IDRequest request);
}
