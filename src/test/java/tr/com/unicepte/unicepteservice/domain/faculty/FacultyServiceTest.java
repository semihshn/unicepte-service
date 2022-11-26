package tr.com.unicepte.unicepteservice.domain.faculty;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tr.com.unicepte.unicepteservice.domain.port.FacultyPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FacultyServiceTest {

    FacultyService facultyService;

    @Mock
    FacultyPort facultyPort;

    @BeforeEach
    void setUp() {
        facultyService = new FacultyService(
                facultyPort
        );
    }

    @Test
    void should_create() {
        //given
        Faculty faculty = Faculty.builder().build();
        Faculty createdFaculty = Faculty.builder().build();

        //mock
        when(facultyPort.create(faculty)).thenReturn(createdFaculty);

        //when
        Faculty facultyResponse = facultyService.create(faculty);

        //then
        assertThat(facultyResponse).isEqualTo(createdFaculty);

        verify(facultyPort, times(1)).create(faculty);
    }
}
