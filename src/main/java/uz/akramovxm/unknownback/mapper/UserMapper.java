package uz.akramovxm.unknownback.mapper;

import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.UserDTO;
import uz.akramovxm.unknownback.dto.view.admin.AdminUserDTO;
import uz.akramovxm.unknownback.entity.User;

@Component
public class UserMapper {
    public AdminUserDTO toAdminUserDTO(User user) {
        if (user == null) return null;

        return AdminUserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .birthDate(user.getBirthDate())
                .role(user.getRole())
                .provider(user.getProvider())
                .locked(user.isLocked())
                .enabled(user.isEnabled())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .createdBy(toUserDTO(user.getCreatedBy()))
                .updatedBy(toUserDTO(user.getUpdatedBy()))
                .build();
    }

    public UserDTO toUserDTO(User user) {
        if (user == null) return null;

        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .birthDate(user.getBirthDate())
                .role(user.getRole())
                .provider(user.getProvider())
                .build();
    }
}
