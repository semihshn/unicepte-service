package tr.com.unicepte.unicepteservice.adapter.rest.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.unicepte.unicepteservice.adapter.rest.student.request.StudentCreateRequest;
import tr.com.unicepte.unicepteservice.adapter.rest.student.request.StudentUpdateRequest;
import tr.com.unicepte.unicepteservice.adapter.rest.student.response.StudentCreateResponse;
import tr.com.unicepte.unicepteservice.adapter.rest.student.response.StudentResponse;
import tr.com.unicepte.unicepteservice.adapter.rest.student.response.StudentUpdateResponse;
import tr.com.unicepte.unicepteservice.domain.student.Student;
import tr.com.unicepte.unicepteservice.domain.student.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping()
    public ResponseEntity<StudentCreateResponse> create(@RequestBody @Valid StudentCreateRequest request) {
        Student student = studentService.create(request.convertToStudent());

        return new ResponseEntity<>(StudentCreateResponse.convertToStudentResponse(student), HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponse> retrieve(@PathVariable Long studentId) {
        Student student = studentService.retrieve(studentId);
        StudentResponse studentResponse = StudentResponse.from(student);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<StudentResponse>> retrieveAll() {
        List<Student> studentList = studentService.retrieveAll();

        return new ResponseEntity<>(StudentResponse.from(studentList), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<StudentUpdateResponse> update(@RequestBody @Valid StudentUpdateRequest request) {
        Student student = studentService.update(request.convertToStudent());

        return new ResponseEntity<>(StudentUpdateResponse.from(student), HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }
}
