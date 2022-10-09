package tr.com.unicepte.unicepteservice.adapter.rest.student.request;

import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class StudentUpdateRequest {

    @NotNull
    private Long studentId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private LocalDate birthDate;

    public Student convertToStudent() {
        return Student.builder()
                .studentId(studentId)
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .build();
    }
}
