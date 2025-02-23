package uz.akramovxm.unknownback.mapper;

import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.admin.AdminUserDTO;
import uz.akramovxm.unknownback.dto.view.admin.AuditUserDTO;
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
                .createdBy(toAuditUserDTO(user.getCreatedBy()))
                .updatedBy(toAuditUserDTO(user.getUpdatedBy()))
                .build();
    }

    public AuditUserDTO toAuditUserDTO(User user) {
        if (user == null) return null;

        return AuditUserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .build();
    }
}
