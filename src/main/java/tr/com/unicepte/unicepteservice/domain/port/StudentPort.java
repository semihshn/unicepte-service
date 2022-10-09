package tr.com.unicepte.unicepteservice.domain.port;

import tr.com.unicepte.unicepteservice.domain.group.Group;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import java.util.List;

public interface StudentPort {

    Student create(Student student);

    Student retrieve(Long studentId);

    List<Student> retrieveAll();

    Student update(Student student);

    void delete(Long groupId);

}
