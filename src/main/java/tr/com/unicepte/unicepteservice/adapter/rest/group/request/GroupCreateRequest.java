package tr.com.unicepte.unicepteservice.adapter.rest.group.request;

import lombok.Getter;
import lombok.Setter;
import tr.com.unicepte.unicepteservice.domain.group.Group;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GroupCreateRequest {

    @NotNull
    private Long studentId;

    @NotBlank
    private String name;

    public Group convertToGroup(){
        return Group.builder()
                .studentId(studentId)
                .name(name)
                .build();
    }
}
