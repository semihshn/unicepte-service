package tr.com.unicepte.unicepteservice.adapter.rest.faculty.request;

import lombok.*;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class FacultyUpdateRequest {

    @NotNull
    private long facultyId;

    @NotBlank
    private String name;

    @NotBlank
    private String declaration;

    public Faculty convertToFaculty(){
        return Faculty.builder()
                .facultyId(facultyId)
                .name(name)
                .declaration(declaration)
                .build();
    }


}
