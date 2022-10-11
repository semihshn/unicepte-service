package tr.com.unicepte.unicepteservice.adapter.rest.faculty;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.unicepte.unicepteservice.adapter.rest.faculty.request.FacultyCreateRequest;
import tr.com.unicepte.unicepteservice.adapter.rest.faculty.request.FacultyUpdateRequest;
import tr.com.unicepte.unicepteservice.adapter.rest.faculty.response.FacultyCreateResponse;
import tr.com.unicepte.unicepteservice.adapter.rest.faculty.response.FacultyResponse;
import tr.com.unicepte.unicepteservice.adapter.rest.faculty.response.FacultyUpdateResponse;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.faculty.FacultyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/faculties")
public class FacultyController {
    private final FacultyService facultyService;


    @PostMapping()
    public ResponseEntity<FacultyCreateResponse> create(@RequestBody @Valid FacultyCreateRequest request){
        Faculty faculty = facultyService.create(request.convertToFaculty());
        FacultyCreateResponse facultyCreateResponse = FacultyCreateResponse.builder()
                .facultyId(faculty.getFacultyId())
                .build();
        return new ResponseEntity<>(facultyCreateResponse, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<FacultyResponse>> retrieveAll(){
        List<Faculty> facultyList = facultyService.retrieveAll();
        List<FacultyResponse> facultyResponseList = facultyList.stream().map(FacultyResponse::from).toList();
        return new ResponseEntity<>(facultyResponseList, HttpStatus.OK);
    }

    @GetMapping("/{facultyId}")
    public ResponseEntity<FacultyResponse> retrieve(@PathVariable Long facultyId){
        Faculty faculty = facultyService.retrieve(facultyId);
        FacultyResponse facultyResponse = FacultyResponse.from(faculty);
        return new ResponseEntity<>(facultyResponse, HttpStatus.OK);
    }


    @PutMapping()
    public ResponseEntity<FacultyUpdateResponse> update(@RequestBody @Valid FacultyUpdateRequest request) {
        Faculty faculty = facultyService.update(request.convertToFaculty());
        FacultyUpdateResponse facultyUpdateResponse = FacultyUpdateResponse.builder()
                .facultyId(faculty.getFacultyId())
                .build();
        return new ResponseEntity<>(facultyUpdateResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{facultyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long facultyId) {
        facultyService.delete(facultyId);
    }



}
