package tr.com.unicepte.unicepteservice.adapter.rest.group.response;

import lombok.*;
import tr.com.unicepte.unicepteservice.domain.group.Group;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupUpdateResponse {

    private Long groupId;

    public static GroupUpdateResponse from(Group group) {
        return GroupUpdateResponse.builder()
                .groupId(group.getGroupId())
                .build();
    }

}
