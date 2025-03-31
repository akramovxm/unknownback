package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.entity.User;

public interface SendCodeService {
    void send(User user);
}
