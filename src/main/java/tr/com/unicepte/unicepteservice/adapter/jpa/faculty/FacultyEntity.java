package tr.com.unicepte.unicepteservice.adapter.jpa.faculty;

import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.BaseEntity;
import tr.com.unicepte.unicepteservice.adapter.jpa.group.GroupEntity;
import tr.com.unicepte.unicepteservice.adapter.jpa.student.StudentEntity;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity(name = "faculties")
@Table(name = "faculties")
public class FacultyEntity extends BaseEntity {
    private String name;
    private String declaration;

    @OneToMany(mappedBy = "faculty")
    private List<StudentEntity> studentEntityList;

    @OneToMany(mappedBy = "faculty")
    private List<GroupEntity> groupEntityList;

    public static FacultyEntity from(Faculty faculty){
        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setId(faculty.getFacultyId());
        facultyEntity.setCreatedDate(faculty.getCreatedDate());
        facultyEntity.setModifiedDate(faculty.getModifiedDate());
        facultyEntity.setStatus(faculty.getStatus());
        facultyEntity.setName(faculty.getName());
        facultyEntity.setDeclaration(faculty.getDeclaration());
        return facultyEntity;
    }

    public Faculty toModel(){
        return Faculty.builder()
                .facultyId(id)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .status(status)
                .name(name)
                .declaration(declaration)
                .build();
    }

}
