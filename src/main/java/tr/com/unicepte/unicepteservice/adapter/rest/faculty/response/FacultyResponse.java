package tr.com.unicepte.unicepteservice.adapter.rest.faculty.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacultyResponse {
    private Long facultyId;
    private String name;
    private String declaration;

    public static FacultyResponse from(Faculty faculty){
        return FacultyResponse.builder()
                .facultyId(faculty.getFacultyId())
                .name(faculty.getName())
                .declaration(faculty.getDeclaration())
                .build();
    }
}
