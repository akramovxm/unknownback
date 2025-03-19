package uz.akramovxm.unknownback.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.admin.AdminAnswerDTO;
import uz.akramovxm.unknownback.entity.Answer;

@Component
public class AnswerMapper {
    @Autowired
    private UserMapper userMapper;

    public AdminAnswerDTO toAdminAnswerDTO(Answer answer) {
        if (answer == null) return null;

        return AdminAnswerDTO.builder()
                .id(answer.getId())
                .valueUz(answer.getValueUz())
                .valueRu(answer.getValueRu())
                .correct(answer.isCorrect())
                .createdAt(answer.getCreatedAt())
                .updatedAt(answer.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(answer.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(answer.getUpdatedBy()))
                .build();
    }
}
