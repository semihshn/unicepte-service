package tr.com.unicepte.unicepteservice.domain.port;

import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;

import java.util.List;

public interface FacultyPort {
    Faculty create(Faculty faculty);

    Faculty retrieve(Long facultyId);

    List<Faculty> retrieveAll();

    Faculty update(Faculty faculty);

    void delete(Long facultyId);
}
