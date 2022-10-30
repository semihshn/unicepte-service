package tr.com.unicepte.unicepteservice.adapter.jpa.matching;

import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.BaseEntity;
import tr.com.unicepte.unicepteservice.adapter.jpa.group.GroupEntity;
import tr.com.unicepte.unicepteservice.adapter.jpa.student.StudentEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "matching")
@Table(name = "matching")
public class MatchingEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;
}
