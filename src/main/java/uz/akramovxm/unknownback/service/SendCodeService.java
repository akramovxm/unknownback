package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.entity.User;

import java.time.LocalDateTime;

public interface SendCodeService {
    LocalDateTime send(User user);
}
