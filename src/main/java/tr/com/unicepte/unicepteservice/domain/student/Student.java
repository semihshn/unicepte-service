package tr.com.unicepte.unicepteservice.domain.student;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Student {

    protected Long studentId;

    protected LocalDateTime createdDate;

    protected LocalDateTime modifiedDate;

    protected Status status;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private Long facultyId;
}
