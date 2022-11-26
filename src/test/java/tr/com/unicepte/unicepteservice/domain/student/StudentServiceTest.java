package tr.com.unicepte.unicepteservice.domain.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.port.FacultyPort;
import tr.com.unicepte.unicepteservice.domain.port.StudentPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    StudentService studentService;

    @Mock
    StudentPort studentPort;

    @Mock
    FacultyPort facultyPort;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(
                studentPort,
                facultyPort
        );
    }

    @Test
    void should_create() {
        //given
        Long STUDENT_ID = 101L;
        Long FACULTY_ID = 102L;

        Student student = Student.builder().facultyId(FACULTY_ID).build();
        Faculty retrievedFaculty = Faculty.builder().build();
        Student createdStudent = Student.builder().studentId(STUDENT_ID).build();

        //mock
        when(facultyPort.retrieve(FACULTY_ID)).thenReturn(retrievedFaculty);
        when(studentPort.create(student, retrievedFaculty)).thenReturn(createdStudent);

        //when
        Student responseStudent = studentService.create(student);

        //then
        assertThat(responseStudent).isEqualTo(createdStudent);

        verify(facultyPort, times(1)).retrieve(FACULTY_ID);
    }
}
