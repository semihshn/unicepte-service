package tr.com.unicepte.unicepteservice.adapter.jpa.faculty;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.Status;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.port.FacultyPort;
import tr.com.unicepte.unicepteservice.domain.util.exception.ExceptionType;
import tr.com.unicepte.unicepteservice.domain.util.exception.UcepteDataNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyJpaAdapter implements FacultyPort {

    private final FacultyJpaRepository facultyJpaRepository;

    @Override
    public Faculty create(Faculty faculty) {
        FacultyEntity facultyEntity = FacultyEntity.from(faculty);
        return facultyJpaRepository.save(facultyEntity).toModel();
    }

    @Override
    public Faculty retrieve(Long facultyId) {
        return facultyJpaRepository.findById(facultyId)
                .orElseThrow(()-> new UcepteDataNotFoundException(ExceptionType.FACULTY_DATA_NOT_FOUND))
                .toModel();
    }

    @Override
    public List<Faculty> retrieveAll() {
        return facultyJpaRepository.findAll()
                .stream()
                .map(FacultyEntity::toModel)
                .toList();
    }

    @Override
    public Faculty update(Faculty faculty) {
        FacultyEntity updateEntity = FacultyEntity.from(faculty);
        return facultyJpaRepository.save(updateEntity).toModel();
    }

    @Override
    public void delete(Long facultyId) {
        facultyJpaRepository.findById(facultyId)
                .ifPresent(facultyEntity -> {
                    facultyEntity.setStatus(Status.DELETED);
                    facultyJpaRepository.save(facultyEntity);
                });
    }
}
