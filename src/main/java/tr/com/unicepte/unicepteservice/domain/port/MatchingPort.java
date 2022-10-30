package tr.com.unicepte.unicepteservice.domain.port;

import tr.com.unicepte.unicepteservice.domain.group.Group;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import java.util.List;

public interface MatchingPort {

    void create(Group group, List<Student> students);

    List<Student> retrieveStudentsByGroupId(Long groupId);

    List<Group> retrieveGroupsByStudentId(Long studentId);

    void delete(Long matchingId);

}
