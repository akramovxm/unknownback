package uz.akramovxm.unknownback.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.AnswerSnapshotDTO;
import uz.akramovxm.unknownback.dto.view.admin.AdminAnswerSnapshotDTO;
import uz.akramovxm.unknownback.entity.AnswerSnapshot;

@Component
public class AnswerSnapshotMapper {
    @Autowired
    private UserMapper userMapper;

    public AdminAnswerSnapshotDTO toAdminAnswerSnapshotDTO(AnswerSnapshot answerSnapshot) {
        if (answerSnapshot == null) return null;

        return AdminAnswerSnapshotDTO.builder()
                .id(answerSnapshot.getId())
                .valueUz(answerSnapshot.getValueUz())
                .valueRu(answerSnapshot.getValueRu())
                .correct(answerSnapshot.isCorrect())
                .answerId(answerSnapshot.getAnswer().getId())
                .createdAt(answerSnapshot.getCreatedAt())
                .updatedAt(answerSnapshot.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(answerSnapshot.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(answerSnapshot.getUpdatedBy()))
                .build();
    }

    public AnswerSnapshotDTO toAnswerSnapshotDTO(AnswerSnapshot answerSnapshot, boolean withCorrect) {
        if (answerSnapshot == null) return null;

        AnswerSnapshotDTO.AnswerSnapshotDTOBuilder builder = AnswerSnapshotDTO.builder()
                .id(answerSnapshot.getId())
                .valueUz(answerSnapshot.getValueUz())
                .valueRu(answerSnapshot.getValueRu())
                .answerId(answerSnapshot.getAnswer().getId());

        if (withCorrect) {
            builder.correct(answerSnapshot.isCorrect());
        }

        return builder.build();
    }
}
