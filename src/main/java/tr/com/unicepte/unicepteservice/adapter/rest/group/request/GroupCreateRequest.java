package tr.com.unicepte.unicepteservice.adapter.rest.group.request;

import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.domain.group.Group;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class GroupCreateRequest {

    private List<Long> studentIds;

    @NotBlank
    private String name;

    @NotNull
    private Long facultyId;

    public Group convertToGroup() {
        return Group.builder()
                .name(name)
                .facultyId(facultyId)
                .build();
    }
}
