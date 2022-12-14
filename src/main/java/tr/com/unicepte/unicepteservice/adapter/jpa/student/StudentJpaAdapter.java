package tr.com.unicepte.unicepteservice.adapter.jpa.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.Status;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.port.StudentPort;
import tr.com.unicepte.unicepteservice.domain.student.Student;
import tr.com.unicepte.unicepteservice.domain.util.exception.ExceptionType;
import tr.com.unicepte.unicepteservice.domain.util.exception.UcepteDataNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentJpaAdapter implements StudentPort {

    private final StudentJpaRepository studentJpaRepository;

    @Override
    public Student create(Student student, Faculty faculty) {
        StudentEntity studentEntity = StudentEntity.from(student, faculty);
        return studentJpaRepository.save(studentEntity).toModel();
    }

    @Override
    public List<Student> create(List<Student> students) {
        List<StudentEntity> studentEntities = students.stream()
                .map(StudentEntity::from)
                .toList();

        return studentJpaRepository.saveAll(studentEntities)
                .stream()
                .map(StudentEntity::toModel)
                .toList();
    }

    @Override
    public Student retrieve(Long studentId) {
        return studentJpaRepository.findById(studentId)
                .orElseThrow(() -> new UcepteDataNotFoundException(ExceptionType.STUDENT_DATA_NOT_FOUND))
                .toModel();
    }

    @Override
    public List<Student> retrieve(List<Long> studentIds) {
        return studentJpaRepository.findAllByIdIn(studentIds)
                .stream()
                .map(StudentEntity::toModel)
                .toList();
    }

    @Override
    public List<Student> retrieveAll() {
        return studentJpaRepository.findAll()
                .stream()
                .map(StudentEntity::toModel).toList();
    }

    @Override
    public Student update(Student student) {
        StudentEntity updateEntity = StudentEntity.from(student);
        return studentJpaRepository.save(updateEntity).toModel();
    }

    @Override
    public void delete(Long studentId) {
        studentJpaRepository.findById(studentId)
                .ifPresent(studentEntity -> {
                    studentEntity.setStatus(Status.DELETED);
                    studentJpaRepository.save(studentEntity);
                });
    }
}
