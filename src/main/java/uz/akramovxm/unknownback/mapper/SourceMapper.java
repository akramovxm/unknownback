package uz.akramovxm.unknownback.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.admin.AdminSourceDTO;
import uz.akramovxm.unknownback.entity.Source;

@Component
public class SourceMapper {
    @Autowired
    private UserMapper userMapper;

    public AdminSourceDTO toAdminSourceDTO(Source source) {
        if (source == null) return null;

        return AdminSourceDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .createdAt(source.getCreatedAt())
                .updatedAt(source.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(source.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(source.getUpdatedBy()))
                .build();
    }
}
