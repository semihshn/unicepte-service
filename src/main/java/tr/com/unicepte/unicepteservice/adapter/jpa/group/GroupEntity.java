package tr.com.unicepte.unicepteservice.adapter.jpa.group;

import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.BaseEntity;
import tr.com.unicepte.unicepteservice.adapter.jpa.faculty.FacultyEntity;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.group.Group;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "groups")
@Table(name = "groups")
public class GroupEntity extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private FacultyEntity faculty;

    public static GroupEntity from(Group group, Faculty faculty) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId(group.getGroupId());
        groupEntity.setFaculty(FacultyEntity.from(faculty));
        groupEntity.setCreatedDate(group.getCreatedDate());
        groupEntity.setModifiedDate(group.getModifiedDate());
        groupEntity.setStatus(group.getStatus());
        groupEntity.setName(group.getName());
        return groupEntity;
    }

    public static GroupEntity from(Group group) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId(group.getGroupId());
        groupEntity.setCreatedDate(group.getCreatedDate());
        groupEntity.setModifiedDate(group.getModifiedDate());
        groupEntity.setStatus(group.getStatus());
        groupEntity.setName(group.getName());
        return groupEntity;
    }

    public Group toModel() {
        return Group.builder()
                .groupId(id)
                .facultyId(faculty.getId())
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .status(status)
                .name(name)
                .build();
    }
}
