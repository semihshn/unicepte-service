package tr.com.unicepte.unicepteservice.adapter.rest.faculty.request;

import lombok.*;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacultyCreateRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String declaration;

    public Faculty convertToFaculty(){
        return Faculty.builder()
                .name(name)
                .declaration(declaration)
                .build();
    }
}
