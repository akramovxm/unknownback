package uz.akramovxm.unknownback.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.akramovxm.unknownback.dto.view.*;
import uz.akramovxm.unknownback.dto.view.admin.AdminTestSessionDTO;
import uz.akramovxm.unknownback.entity.TestSession;

@Component
public class TestSessionMapper {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TaskGroupMapper taskGroupMapper;

    public AdminTestSessionDTO toAdminTestSessionDTO(TestSession testSession) {
        if (testSession == null) return null;

        return AdminTestSessionDTO.builder()
                .id(testSession.getId())
                .startTime(testSession.getStartTime())
                .endTime(testSession.getEndTime())
                .finishTime(testSession.getFinishTime())
                .status(testSession.getStatus())
                .user(userMapper.toAdminUserDTO(testSession.getUser()))
                .taskGroups(testSession.getTaskGroups().stream().map(taskGroupMapper::toAdminTaskGroupDTO).toList())
                .createdAt(testSession.getCreatedAt())
                .updatedAt(testSession.getUpdatedAt())
                .createdBy(userMapper.toUserDTO(testSession.getCreatedBy()))
                .updatedBy(userMapper.toUserDTO(testSession.getUpdatedBy()))
                .build();
    }

    public TestSessionDTO toTestSessionDTO(TestSession testSession, boolean withCorrect) {
        if (testSession == null) return null;

        return TestSessionDTO.builder()
                .id(testSession.getId())
                .startTime(testSession.getStartTime())
                .endTime(testSession.getEndTime())
                .finishTime(testSession.getFinishTime())
                .status(testSession.getStatus())
                .user(userMapper.toUserDTO(testSession.getUser()))
                .taskGroups(testSession.getTaskGroups().stream().map(t -> taskGroupMapper.toTaskGroupDTO(t, withCorrect)).toList())
                .build();
    }
}
