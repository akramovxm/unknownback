package uz.akramovxm.unknownback.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.UserDTO;
import uz.akramovxm.unknownback.entity.User;
import uz.akramovxm.unknownback.mapper.UserMapper;
import uz.akramovxm.unknownback.security.CurrentUserService;

@Component
public class UserDTOFactory {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CurrentUserService currentUserService;

    public UserDTO create(User user) {
        return switch (currentUserService.getRole()) {
            case SUPERADMIN, ADMIN -> userMapper.toAdminUserDTO(user);
            default -> userMapper.toUserDTO(user);
        };
    }
}
