package tr.com.unicepte.unicepteservice.adapter.rest.student.request;

import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.domain.group.Group;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class StudentCreateRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private LocalDate birthDate;

    public Student convertToStudent(){
        return Student.builder()
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(birthDate)
                .build();
    }
}
