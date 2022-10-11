package tr.com.unicepte.unicepteservice.domain.port;

import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.group.Group;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import java.util.List;

public interface GroupPort {

    Group create(Group group, Student student);

    Group retrieve(Long groupId);

    List<Group> retrieveAll();

    Group update(Group group, Student student);

    void delete(Long groupId);

}
