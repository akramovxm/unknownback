package uz.akramovxm.unknownback.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.sort.dsl.SortOrder;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.dto.request.IDRequest;
import uz.akramovxm.unknownback.dto.request.SetPasswordRequest;
import uz.akramovxm.unknownback.dto.request.UserRequest;
import uz.akramovxm.unknownback.entity.*;
import uz.akramovxm.unknownback.exception.RequestBodyNotValidException;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.UserRepository;
import uz.akramovxm.unknownback.security.oauth2.user.OAuth2UserInfo;
import uz.akramovxm.unknownback.service.UserService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SearchResult<User> getAll(String search, int page, int size, String sortBy, String sortType) {
        SearchSession session = Search.session(entityManager);

        SearchResult<User> result;

        if (search == null || search.trim().isEmpty()) {
            result = session.search(User.class)
                    .where(SearchPredicateFactory::matchAll)
                    .sort(f -> f.field(sortBy)
                            .order("desc".equalsIgnoreCase(sortType) ? SortOrder.DESC : SortOrder.ASC))
                    .fetch(size * page, size);
        } else {
            result = session.search(User.class)
                    .where(f -> f.bool()
                            .should(f.wildcard().fields(
                                    "firstName",
                                    "lastName",
                                    "email",
                                    "phoneNumber",
                                    "role"
                            ).matching("*" + search + "*")))
                    .sort(f -> f.field(sortBy)
                            .order("desc".equalsIgnoreCase(sortType) ? SortOrder.DESC : SortOrder.ASC))
                    .fetch(size * page, size);
        }

        return result;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(User.class.getSimpleName(), "id", id)
        );
    }

    @Override
    public User getByEmail(String email) {
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
                .role(role)
                .provider(provider)
                .locked(locked)
                .enabled(enabled)
                .build();

        Map<String, String> errors = new HashMap<>();

        if (email != null && !email.isEmpty()) {
            if (userRepository.existsByEmail(email)) {
                errors.put("email", "Email is already taken");
            } else {
                user.setEmail(email);
            }
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            if (userRepository.existsByPhoneNumberAndPhoneNumberNotNull(phoneNumber)) {
                errors.put("phoneNumber", "Phone number is already taken");
            } else {
                user.setPhoneNumber(phoneNumber);
            }
        }
        if (password != null && !password.isEmpty()) {
            user.setPassword(passwordEncoder.encode(password));
        }
        if (birthDate != null) {
            user.setBirthDate(birthDate);
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
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
    public User create(UserRequest request) {
        return create(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                null,
                request.getPhoneNumber(),
                request.getBirthDate(),
                request.getRole(),
                AuthProvider.local,
                request.isLocked(),
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
    public User update(UserRequest request, Long id) {
        User user = getById(id);

        setFields(request, user);

        return userRepository.save(user);
    }

    @Override
    public User update(UserRequest request, Authentication authentication) {
        User user = getByEmail(authentication.getName());

        setFields(request, user);

        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void setPassword(SetPasswordRequest request) {
        User user = getByEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }

    @Override
    public void delete(IDRequest request) {
        userRepository.deleteAllById(request.getIds());
    }

    @Override
    public void lock(IDRequest request) {
        List<User> users = userRepository.findAllById(request.getIds());

        users.forEach(user -> {
            user.setLocked(true);
        });

        userRepository.saveAll(users);
    }

    @Override
    public void unlock(IDRequest request) {
        List<User> users = userRepository.findAllById(request.getIds());

        users.forEach(user -> {
            user.setLocked(false);
        });

        userRepository.saveAll(users);
    }

    private void setFields(UserRequest request, User user) {
        Map<String, String> errors = new HashMap<>();

        if (request.getFirstName() != null && !request.getFirstName().isEmpty()) {
            user.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null && !request.getLastName().isEmpty()) {
            user.setLastName(request.getLastName());
        }
        if (request.getPhoneNumber() != null && !request.getPhoneNumber().isEmpty()) {
            if (userRepository.existsByPhoneNumberAndPhoneNumberNotNullAndIdNot(request.getPhoneNumber(), user.getId())) {
                errors.put("phoneNumber", "Phone number is already taken");
            } else {
                user.setPhoneNumber(request.getPhoneNumber());
            }
        }
        if (request.getBirthDate() != null) {
            user.setBirthDate(request.getBirthDate());
        }
        if (request.getRole() != null) {
            user.setRole(request.getRole());
        }

        user.setLocked(request.isLocked());

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }
    }
}
