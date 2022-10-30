package tr.com.unicepte.unicepteservice.adapter.rest.faculty.response;

import lombok.*;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FacultyCreateResponse {
    private Long facultyId;

    public static FacultyCreateResponse convertToFacultyResponse(Faculty faculty) {
        return FacultyCreateResponse.builder()
                .facultyId(faculty.getFacultyId())
                .build();
    }
}
