package tr.com.unicepte.unicepteservice.domain.group;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.Status;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class Group {

    protected Long groupId;

    protected LocalDateTime createdDate;

    protected LocalDateTime modifiedDate;

    protected Status status;

    private String name;

    private Long studentId;
}
