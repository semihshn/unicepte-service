package tr.com.unicepte.unicepteservice.adapter.rest.student.response;

import lombok.*;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateResponse {

    private Long studentId;

    public static StudentUpdateResponse from(Student student) {
        return StudentUpdateResponse.builder()
                .studentId(student.getStudentId())
                .build();
    }

    public static List<StudentUpdateResponse> from(List<Student> students) {
        return students.stream()
                .map(StudentUpdateResponse::from)
                .toList();
    }

}
