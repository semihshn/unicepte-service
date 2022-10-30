package tr.com.unicepte.unicepteservice.domain.group;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.port.FacultyPort;
import tr.com.unicepte.unicepteservice.domain.port.GroupPort;
import tr.com.unicepte.unicepteservice.domain.port.MatchingPort;
import tr.com.unicepte.unicepteservice.domain.port.StudentPort;
import tr.com.unicepte.unicepteservice.domain.student.Student;
import tr.com.unicepte.unicepteservice.domain.util.exception.ExceptionType;
import tr.com.unicepte.unicepteservice.domain.util.exception.UcepteDataNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupPort groupPort;
    private final StudentPort studentPort;
    private final MatchingPort matchingPort;
    private final FacultyPort facultyPort;

    public Group create(Group group, List<Long> studentIds) {

        Faculty faculty = facultyPort.retrieve(group.getFacultyId());

        List<Student> existingStudents = retrieveExistingStudents(studentIds);
        Group createdGroup = groupPort.create(group, faculty);

        matchingPort.create(createdGroup, existingStudents);
        return createdGroup;
    }

    public List<Group> retrieveAll() {
        List<Group> groupList = groupPort.retrieveAll();

        groupList.forEach(group -> {
            List<Student> students = matchingPort.retrieveStudentsByGroupId(group.getGroupId());
            group.setStudents(students);
        });

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

        Group updatedGroup = groupPort.update(group);

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

    private List<Student> retrieveExistingStudents(List<Long> studentIds) {
        if (!CollectionUtils.isEmpty(studentIds)){
            List<Student> retrievedStudents = studentPort.retrieve(studentIds);

            if (retrievedStudents.size() < studentIds.size()){
                String detail =String.format("Verilen student id db'de bulunamamıştır. Beklenen: %s, bulunan:%s", studentIds, retrievedStudents);
                throw new UcepteDataNotFoundException(ExceptionType.COLLECTION_SIZE_EXCEPTION, detail);
            }

            return retrievedStudents;
        }

        return new ArrayList<>();
    }
}
