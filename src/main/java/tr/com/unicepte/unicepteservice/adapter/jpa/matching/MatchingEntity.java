package tr.com.unicepte.unicepteservice.adapter.jpa.matching;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
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
@Where(clause = "status <> 'DELETED'")
public class MatchingEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;
}
