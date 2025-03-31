package uz.akramovxm.unknownback.service;

import org.hibernate.search.engine.search.query.SearchResult;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import uz.akramovxm.unknownback.dto.request.*;
import uz.akramovxm.unknownback.dto.request.auth.RegisterRequest;
import uz.akramovxm.unknownback.entity.Role;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.security.oauth2.user.OAuth2UserInfo;

import java.util.Optional;

public interface UserService {
    SearchResult<User> getAll(String search, int page, int size, String sortBy, String sortType);

    User getById(Long id);

    Optional<User> findByEmail(String email);

    User getByEmail(String email);

    User create(String firstName, String lastName, String email, String password, Role role);

    User create(RegisterRequest request);

    User create(OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo);

    User create(UserRequest request);

    User updateFully(User user, OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo);

    User updateFully(UserRequest request, Long id);

    User updatePartially(UserRequest request, Long id);

    User save(User user);

    void delete(IDRequest request);

    void deleteById(Long id);

    void lock(IDRequest request);

    void unlock(IDRequest request);

    void setEnabled(User user, boolean enabled);

    void setPassword(User user, String password);
}
