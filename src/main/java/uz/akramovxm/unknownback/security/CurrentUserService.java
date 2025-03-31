package uz.akramovxm.unknownback.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.entity.Role;
import uz.akramovxm.unknownback.entity.User;

@Component
public class CurrentUserService {
    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
            throw new RuntimeException("Пользователь не аутентифицирован");
        }

        Object principal = auth.getPrincipal();
        if (principal instanceof User user) {
            return user;
        }

        throw new RuntimeException("Principal не является User: " + principal.getClass());
    }

    public Role getRole() {
        return getCurrentUser().getRole();
    }

    public String getEmail() {
        return getCurrentUser().getEmail();
    }
}
