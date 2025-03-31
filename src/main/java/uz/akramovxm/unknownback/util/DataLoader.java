package uz.akramovxm.unknownback.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.entity.Role;
import uz.akramovxm.unknownback.service.UserService;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) {
        userService.create(
                "Xojiakbar",
                "Akramov",
                "akramovxm@gmail.com",
                "123",
                Role.SUPERADMIN
        );

        userService.create(
                "Makkamov",
                "Xikmatullo",
                "makkamovxq@gmail.com",
                "123",
                Role.ADMIN
        );

        userService.create(
                "Makkamov",
                "Nig'matullo",
                "makkamovnq@gmail.com",
                "123",
                Role.ADMIN
        );

        userService.create(
                "Kulchaboyev",
                "Maxmud",
                "kulchaboyevmx@gmail.com",
                "123",
                Role.ADMIN
        );

        userService.create(
                "pupil",
                "pupil",
                "pupil@mail.com",
                "123",
                Role.PUPIL
        );

//        for (int i = 0; i < 50; i++) {
//            userService.create(
//                    "pupil" + i,
//                    "pupil" + i,
//                    "pupil" + i + "@gmail.com",
//                    "123",
//                    Role.PUPIL
//            );
//        }
    }
}
