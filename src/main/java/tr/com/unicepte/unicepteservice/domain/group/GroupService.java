package tr.com.unicepte.unicepteservice.domain.group;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.unicepte.unicepteservice.domain.port.GroupPort;
import tr.com.unicepte.unicepteservice.domain.port.StudentPort;
import tr.com.unicepte.unicepteservice.domain.student.Student;
import tr.com.unicepte.unicepteservice.domain.util.exception.ExceptionType;
import tr.com.unicepte.unicepteservice.domain.util.exception.UcepteDataNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupPort groupPort;
    private final StudentPort studentPort;

    public Group create(Group group) {
        Student student = studentPort.retrieve(group.getStudentId());

        Group createdGroup = groupPort.create(group, student);

        return createdGroup;
    }

    public List<Group> retrieveAll() {
        List<Group> groupList = groupPort.retrieveAll();

        checkIfEmpty(groupList);

        return groupList;
    }

    public Group retrieve(Long groupId) {
        Group group = groupPort.retrieve(groupId);
        checkIfNull(group);

        return group;
    }

    public Group update(Group group) {
        retrieve(group.getGroupId());

        Student student = studentPort.retrieve(group.getStudentId());
        Group updatedGroup = groupPort.update(group, student);

        return updatedGroup;
    }

    public void delete(Long groupId) {
        retrieve(groupId);

        groupPort.delete(groupId);
    }

    private void checkIfNull(Group group) {
        if (group == null) {
            throw new UcepteDataNotFoundException(ExceptionType.GROUP_DATA_NOT_FOUND, "Grup bilgisi bulunamadı");
        }
    }

    private void checkIfEmpty(List<Group> groupList) {
        if (groupList.isEmpty()) {
            throw new UcepteDataNotFoundException(ExceptionType.GROUP_DATA_NOT_FOUND, "Grup bilgileri bulunamadı");
        }
    }
}
