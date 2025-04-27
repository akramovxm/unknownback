package uz.akramovxm.unknownback.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.SubjectDTO;
import uz.akramovxm.unknownback.dto.view.admin.AdminSubjectDTO;
import uz.akramovxm.unknownback.entity.Subject;

@Component
public class SubjectMapper {
    @Autowired
    private UserMapper userMapper;

    public AdminSubjectDTO toAdminSubjectDTO(Subject subject) {
        if (subject == null) return null;

        return AdminSubjectDTO.builder()
                .id(subject.getId())
                .titleUz(subject.getTitleUz())
                .titleRu(subject.getTitleRu())
                .createdAt(subject.getCreatedAt())
                .updatedAt(subject.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(subject.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(subject.getUpdatedBy()))
                .build();
    }

    public SubjectDTO toSubjectDTO(Subject subject) {
        if (subject == null) return null;

        return SubjectDTO.builder()
                .id(subject.getId())
                .titleUz(subject.getTitleUz())
                .titleRu(subject.getTitleRu())
                .build();
    }
}
