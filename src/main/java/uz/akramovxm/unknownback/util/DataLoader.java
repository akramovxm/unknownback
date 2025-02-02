package uz.akramovxm.unknownback.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.entity.AuthProvider;
import uz.akramovxm.unknownback.entity.Role;
import uz.akramovxm.unknownback.service.UserService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        userService.create(
                "admin",
                "admin",
                "admin@mail.com",
                "123",
                "909118611",
                LocalDate.now(),
                Role.ADMIN,
                AuthProvider.local,
                false,
                true
        );

        userService.create(
                "pupil",
                "pupil",
                "pupil@mail.com",
                "123",
                null,
                LocalDate.now(),
                Role.PUPIL,
                AuthProvider.local,
                false,
                true
        );
    }
}
