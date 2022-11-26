package tr.com.unicepte.unicepteservice.domain.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.port.FacultyPort;
import tr.com.unicepte.unicepteservice.domain.port.StudentPort;
import tr.com.unicepte.unicepteservice.domain.util.exception.UcepteDataNotFoundException;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
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

    @Test
    void should_retrieve_all() {
        //given

        Student student = Student.builder().build();

        //mock
        when(studentPort.retrieveAll()).thenReturn(Collections.singletonList(student));

        //when
        List<Student> responseStudents = studentService.retrieveAll();

        //then
        assertThat(responseStudents).isEqualTo(Collections.singletonList(student));

        verify(studentPort, times(1)).retrieveAll();
    }

    @Test
    void should_NOT_present_students_when_there_are_no_students_in_db() {
        //given

        //mock
        when(studentPort.retrieveAll()).thenReturn(Collections.emptyList());

        //when
        Throwable throwable = catchThrowable(() -> studentService.retrieveAll());

        //then
        assertThat(throwable)
                .isNotNull()
                .isInstanceOf(UcepteDataNotFoundException.class)
                .hasMessage("Öğrenci bulunamadı");
    }

    @Test
    void should_retrieve() {
        //given
        Long STUDENT_ID = 101L;

        Student student = Student.builder().build();

        //mock
        when(studentPort.retrieve(STUDENT_ID)).thenReturn(student);

        //when
        Student responseStudent = studentService.retrieve(STUDENT_ID);

        //then
        assertThat(responseStudent).isEqualTo(student);

        verify(studentPort, times(1)).retrieve(STUDENT_ID);
    }

    @Test
    void should_NOT_present_student_when_given_student_not_exist_in_db() {
        //given
        Long STUDENT_ID = 101L;

        //mock
        when(studentPort.retrieve(STUDENT_ID)).thenReturn(null);

        //when
        Throwable throwable = catchThrowable(() -> studentService.retrieve(STUDENT_ID));

        //then
        assertThat(throwable)
                .isNotNull()
                .isInstanceOf(UcepteDataNotFoundException.class)
                .hasMessage("Öğrenci bulunamadı");
    }

    @Test
    void should_update() {
        //given
        Long STUDENT_ID = 101L;

        Student student = Student.builder().studentId(STUDENT_ID).build();

        //mock
        when(studentPort.retrieve(STUDENT_ID)).thenReturn(student);
        when(studentPort.update(student)).thenReturn(student);

        //when
        Student responseStudent = studentService.update(student);

        //then
        assertThat(responseStudent).isEqualTo(student);

        verify(studentPort, times(1)).update(student);
    }

    @Test
    void should_delete() {
        //given
        Long STUDENT_ID = 101L;

        Student student = Student.builder().studentId(STUDENT_ID).build();

        //mock
        when(studentPort.retrieve(STUDENT_ID)).thenReturn(student);

        //when
        studentService.delete(STUDENT_ID);

        //then

        verify(studentPort, times(1)).delete(STUDENT_ID);
    }
}
