package tr.com.unicepte.unicepteservice.adapter.rest.student.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tr.com.unicepte.unicepteservice.domain.group.Group;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long studentId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public static StudentResponse from(Student student) {
        return StudentResponse.builder()
                .studentId(student.getStudentId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .birthDate(student.getBirthDate())
                .build();
    }
}
