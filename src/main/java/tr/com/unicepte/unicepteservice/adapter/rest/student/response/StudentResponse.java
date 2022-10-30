package tr.com.unicepte.unicepteservice.adapter.rest.student.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Long facultyId;

    public static StudentResponse from(Student student) {
        return StudentResponse.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .birthDate(student.getBirthDate())
                .facultyId(student.getFacultyId())
                .build();
    }

    public static List<StudentResponse> from(List<Student> students) {
        return students.stream()
                .map(StudentResponse::from)
                .toList();
    }
}
