package uz.akramovxm.unknownback.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.search.engine.search.predicate.dsl.SearchPredicateFactory;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.engine.search.sort.dsl.SortOrder;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.stereotype.Service;
import uz.akramovxm.unknownback.dto.request.*;
import uz.akramovxm.unknownback.dto.request.auth.RegisterRequest;
import uz.akramovxm.unknownback.entity.*;
import uz.akramovxm.unknownback.exception.RequestBodyNotValidException;
import uz.akramovxm.unknownback.exception.ResourceNotFoundException;
import uz.akramovxm.unknownback.repository.UserRepository;
import uz.akramovxm.unknownback.security.CurrentUserService;
import uz.akramovxm.unknownback.security.oauth2.user.OAuth2UserInfo;
import uz.akramovxm.unknownback.service.UserService;
import uz.akramovxm.unknownback.service.validation.UserValidationService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CurrentUserService currentUserService;
    @Autowired
    private UserValidationService userValidationService;
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
                                    "firstName", "lastName", "email", "phoneNumber", "role"
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
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getByEmail(String email) {
        return findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException(User.class.getSimpleName(), "email", email)
        );
    }

    @Override
    public User create(String firstName, String lastName, String email, String password, Role role) {
        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(role)
                .provider(AuthProvider.local)
                .locked(false)
                .enabled(true)
                .build();

        return userRepository.save(user);
    }

    @Override
    public User create(RegisterRequest request) {
        Map<String, String> errors = new HashMap<>();

        userValidationService.validateFirstName(request.getFirstName(), errors);
        userValidationService.validateLastName(request.getLastName(), errors);
        userValidationService.validateEmail(request.getEmail(), errors);
        userValidationService.validatePassword(request.getPassword(), errors);
        userValidationService.validatePhoneNumber(request.getPhoneNumber(), errors);
        userValidationService.validateBirthDate(request.getBirthDate(), errors);

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.PUPIL)
                .provider(AuthProvider.local)
                .locked(false)
                .enabled(false)
                .build();

        if (request.getBirthDate() != null) {
            user.setBirthDate(LocalDate.parse(request.getBirthDate()));
        }

        return userRepository.save(user);
    }

    @Override
    public User create(OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo) {
        User user = User.builder()
                .firstName(oAuth2UserInfo.getFirstName())
                .lastName(oAuth2UserInfo.getLastName())
                .email(oAuth2UserInfo.getEmail())
                .role(Role.PUPIL)
                .provider(AuthProvider.valueOf(userRequest.getClientRegistration().getRegistrationId()))
                .locked(false)
                .enabled(true)
                .build();

        return userRepository.save(user);
    }

    @Override
    public User create(UserRequest request) {
        validateRequest(request, null);

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .role(Role.valueOf(request.getRole()))
                .provider(AuthProvider.local)
                .enabled(true)
                .build();

        if (request.getBirthDate() != null) {
            user.setBirthDate(LocalDate.parse(request.getBirthDate()));
        }
        if (request.getLocked() != null) {
            user.setLocked(request.getLocked());
        }

        return userRepository.save(user);
    }

    @Override
    public User updateFully(User user, OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo) {
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
    public User updateFully(UserRequest request, Long id) {
        User user = getById(id);

        validateRequest(request, id);

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRole(Role.valueOf(request.getRole()));

        if (request.getBirthDate() != null) {
            user.setBirthDate(LocalDate.parse(request.getBirthDate()));
        }
        if (request.getLocked() != null) {
            user.setLocked(request.getLocked());
        }

        return userRepository.save(user);
    }

    @Override
    public User updatePartially(UserRequest request, Long id) {
        User user = getById(id);

        Map<String, String> errors = new HashMap<>();

        if (request.getFirstName() != null && !request.getFirstName().isEmpty()) {
            user.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null && !request.getLastName().isEmpty()) {
            user.setLastName(request.getLastName());
        }
        if (request.getEmail() != null && !request.getEmail().isEmpty()) {
            if (userRepository.existsByPhoneNumberAndPhoneNumberNotNullAndIdNot(request.getEmail(), id)) {
                errors.put("email", "exists");
            } else {
                user.setEmail(request.getEmail());
            }
        }
        if (request.getPhoneNumber() != null && !request.getPhoneNumber().isEmpty()) {
            if (userRepository.existsByPhoneNumberAndPhoneNumberNotNullAndIdNot(request.getPhoneNumber(), id)) {
                errors.put("phoneNumber", "exists");
            } else {
                user.setPhoneNumber(request.getPhoneNumber());
            }
        }
        if (request.getRole() != null && !request.getRole().isEmpty()) {
            try {
                Role role = Role.valueOf(request.getRole());

                User currentUser = currentUserService.getCurrentUser();
                if (currentUser.getRole().ordinal() > role.ordinal()) {
                    errors.put("role", "notAllowed");
                } else {
                    user.setRole(role);
                }
            } catch (IllegalArgumentException e) {
                errors.put("role", "invalid");
            }
        }
        if (request.getBirthDate() != null) {
            try {
                LocalDate birthDate = LocalDate.parse(request.getBirthDate());
                user.setBirthDate(birthDate);
            } catch (IllegalArgumentException e) {
                errors.put("birthDate", "matDatepickerParse");
            }
        }
        if (request.getLocked() != null) {
            user.setLocked(request.getLocked());
        }

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }

        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(IDRequest request) {
        userRepository.deleteAllById(request.getIds());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void lock(IDRequest request) {
        List<User> users = userRepository.findAllById(request.getIds());

        users.forEach(user -> user.setLocked(true));

        userRepository.saveAll(users);
    }

    @Override
    public void unlock(IDRequest request) {
        List<User> users = userRepository.findAllById(request.getIds());

        users.forEach(user -> user.setLocked(false));

        userRepository.saveAll(users);
    }

    @Override
    public void setEnabled(User user, boolean enabled) {
        user.setEnabled(enabled);

        userRepository.save(user);
    }

    @Override
    public void setPassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);
    }

    private void validateRequest(UserRequest request, Long id) {
        Map<String, String> errors = new HashMap<>();

        userValidationService.validateFirstName(request.getFirstName(), errors);
        userValidationService.validateLastName(request.getLastName(), errors);
        if (id != null) {
            userValidationService.validateEmail(request.getEmail(), errors, id);
            userValidationService.validatePhoneNumber(request.getPhoneNumber(), errors, id);
        } else {
            userValidationService.validateEmail(request.getEmail(), errors);
            userValidationService.validatePhoneNumber(request.getPhoneNumber(), errors);
        }
        userValidationService.validateBirthDate(request.getBirthDate(), errors);
        userValidationService.validateRole(request.getRole(), errors);

        if (!errors.isEmpty()) {
            throw new RequestBodyNotValidException(errors);
        }
    }
}
