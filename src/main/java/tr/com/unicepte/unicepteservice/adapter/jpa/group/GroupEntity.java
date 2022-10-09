package tr.com.unicepte.unicepteservice.adapter.jpa.group;

import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.BaseEntity;
import tr.com.unicepte.unicepteservice.adapter.jpa.student.StudentEntity;
import tr.com.unicepte.unicepteservice.domain.group.Group;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "groups")
@Table(name = "groups")
public class GroupEntity extends BaseEntity {

    private String name;

    @ManyToOne
    private StudentEntity student;

    public static GroupEntity from(Group group, Student student){
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setId(group.getGroupId());
        groupEntity.setCreatedDate(group.getCreatedDate());
        groupEntity.setModifiedDate(group.getModifiedDate());
        groupEntity.setStatus(group.getStatus());
        groupEntity.setName(group.getName());
        groupEntity.setStudent(StudentEntity.from(student));
        return groupEntity;
    }

    public Group toModel(){
        return Group.builder()
                .groupId(id)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .status(status)
                .name(name)
                .studentId(student.getId())
                .build();
    }
}
