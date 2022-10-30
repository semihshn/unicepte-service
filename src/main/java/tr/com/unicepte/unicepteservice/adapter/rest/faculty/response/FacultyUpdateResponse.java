package tr.com.unicepte.unicepteservice.adapter.rest.faculty.response;

import lombok.*;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacultyUpdateResponse {
    private Long facultyId;

    public static FacultyUpdateResponse from(Faculty faculty) {
        return FacultyUpdateResponse.builder()
                .facultyId(faculty.getFacultyId())
                .build();
    }
}
