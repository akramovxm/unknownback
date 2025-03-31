package uz.akramovxm.unknownback.service;

import uz.akramovxm.unknownback.dto.request.MeRequest;
import uz.akramovxm.unknownback.dto.request.UpdatePasswordRequest;
import uz.akramovxm.unknownback.entity.User;

public interface MeService {
    User getCurrentUser();

    User update(MeRequest request);

    void updatePassword(UpdatePasswordRequest request);
}
