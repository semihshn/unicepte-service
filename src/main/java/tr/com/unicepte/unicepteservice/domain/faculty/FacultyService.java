package tr.com.unicepte.unicepteservice.domain.faculty;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.unicepte.unicepteservice.domain.port.FacultyPort;
import tr.com.unicepte.unicepteservice.domain.util.exception.ExceptionType;
import tr.com.unicepte.unicepteservice.domain.util.exception.UcepteDataNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyPort facultyPort;

    public Faculty create(Faculty faculty){
        Faculty createdFaculty = facultyPort.create(faculty);
        return createdFaculty;
    }

    public List<Faculty> retrieveAll(){
        List<Faculty> facultyList = facultyPort.retrieveAll();
        checkIfEmpty(facultyList);
        return facultyList;
    }

    public Faculty retrieve(Long facultyId){
        Faculty faculty = facultyPort.retrieve(facultyId);
        checkIfNull(faculty);
        return faculty;
    }

    public Faculty update(Faculty faculty){
        retrieve(faculty.getFacultyId());

        Faculty updatedFaculty = facultyPort.update(faculty);

        return updatedFaculty;
    }

    public void delete(Long facultyId){
        retrieve(facultyId);

        facultyPort.delete(facultyId);
    }

    private void checkIfNull(Faculty faculty) {
        if (faculty == null) {
            throw new UcepteDataNotFoundException(ExceptionType.FACULTY_DATA_NOT_FOUND, "Fakülte bilgisi bulunamadı");
        }
    }

    private void checkIfEmpty(List<Faculty> facultyList) {
        if (facultyList.isEmpty()) {
            throw new UcepteDataNotFoundException(ExceptionType.FACULTY_DATA_NOT_FOUND, "Fakülte bilgileri bulunamadı");
        }
    }
}
