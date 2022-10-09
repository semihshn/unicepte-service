package tr.com.unicepte.unicepteservice.domain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.unicepte.unicepteservice.domain.port.StudentPort;
import tr.com.unicepte.unicepteservice.domain.util.exception.ExceptionType;
import tr.com.unicepte.unicepteservice.domain.util.exception.UcepteDataNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentPort studentPort;

    public Student create(Student student) {
        Student createdStudent = studentPort.create(student);

        return createdStudent;
    }

    public List<Student> retrieveAll() {
        List<Student> studentList = studentPort.retrieveAll();

        checkIfEmpty(studentList);

        return studentList;
    }

    public Student retrieve(Long studentId) {
        Student student = studentPort.retrieve(studentId);
        checkIfNull(student);

        return student;
    }

    public Student update(Student student) {
        retrieve(student.getStudentId());

        Student updatedStudent = studentPort.update(student);

        return updatedStudent;
    }

    public void delete(Long studentId) {
        retrieve(studentId);

        studentPort.delete(studentId);
    }

    private void checkIfNull(Student student) {
        if (student == null) {
            throw new UcepteDataNotFoundException(ExceptionType.STUDENT_DATA_NOT_FOUND, "Öğrenci bilgisi bulunamadı");
        }
    }

    private void checkIfEmpty(List<Student> studentList) {
        if (studentList.isEmpty()) {
            throw new UcepteDataNotFoundException(ExceptionType.STUDENT_DATA_NOT_FOUND, "Öğrenci bilgileri bulunamadı");
        }
    }
}
