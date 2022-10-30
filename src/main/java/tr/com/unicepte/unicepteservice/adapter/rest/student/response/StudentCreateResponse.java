package tr.com.unicepte.unicepteservice.adapter.rest.student.response;

import lombok.*;
import tr.com.unicepte.unicepteservice.domain.student.Student;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateResponse {

    private Long studentId;

    private Long facultyId;

    public static StudentCreateResponse convertToStudentResponse(Student student) {
        return StudentCreateResponse.builder()
                .studentId(student.getStudentId())
                .facultyId(student.getFacultyId())
                .build();
    }

}
