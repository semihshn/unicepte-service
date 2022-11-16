package tr.com.unicepte.unicepteservice.domain.group;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.Status;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class Group {

    protected Long groupId;

    protected LocalDateTime createdDate;

    protected LocalDateTime modifiedDate;

    protected Status status;

    private String name;

    private Long facultyId;

    private List<Student> students;
}
