package tr.com.unicepte.unicepteservice.domain.port;

import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import java.util.List;

public interface StudentPort {

    Student create(Student student, Faculty faculty);

    List<Student> create(List<Student> students);

    Student retrieve(Long studentId);

    List<Student> retrieve(List<Long> studentIds);

    List<Student> retrieveAll();

    Student update(Student student);

    void delete(Long groupId);

}
