package tr.com.unicepte.unicepteservice.adapter.jpa.student;

import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.BaseEntity;
import tr.com.unicepte.unicepteservice.adapter.jpa.group.GroupEntity;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "students")
@Table(name = "students")
public class StudentEntity extends BaseEntity {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @OneToMany(mappedBy = "student")
    private List<GroupEntity> groupEntityList;

    public static StudentEntity from(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getStudentId());
        studentEntity.setCreatedDate(student.getCreatedDate());
        studentEntity.setModifiedDate(student.getModifiedDate());
        studentEntity.setStatus(student.getStatus());
        studentEntity.setFirstName(student.getFirstName());
        studentEntity.setLastName(student.getLastName());
        studentEntity.setBirthDate(student.getBirthDate());
        return studentEntity;
    }

    public Student toModel() {
        return Student.builder()
                .studentId(id)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .status(status)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .build();
    }
}
