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
                "Xojiakbar",
                "Akramov",
                "akramovxm@gmail.com",
                "123",
                "909118611",
                LocalDate.now(),
                Role.ADMIN,
                AuthProvider.local,
                false,
                true
        );

        userService.create(
                "Makkamov",
                "Xikmatullo",
                "makkamovxq@gmail.com",
                "123",
                "901139969",
                LocalDate.now(),
                Role.ADMIN,
                AuthProvider.local,
                false,
                true
        );

        userService.create(
                "Makkamov",
                "Nig'matullo",
                "makkamovnq@gmail.com",
                "123",
                "909162404",
                LocalDate.now(),
                Role.ADMIN,
                AuthProvider.local,
                false,
                true
        );

        userService.create(
                "Kulchaboyev",
                "Maxmud",
                "kulchaboyevmx@gmail.com",
                "123",
                "901528474",
                LocalDate.now(),
                Role.ADMIN,
                AuthProvider.local,
                false,
                true
        );

        for (int i = 2; i <= 20; i++) {
            userService.create(
                    "pupil" + i,
                    "pupil" + i,
                    "pupil" + i + "@mail.com",
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
}
