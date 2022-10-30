package tr.com.unicepte.unicepteservice.adapter.rest.group.response;

import lombok.*;
import tr.com.unicepte.unicepteservice.domain.group.Group;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupCreateResponse {

    private Long groupId;
    private Long facultyId;

    public static GroupCreateResponse convertToGroupResponse(Group group){
        return GroupCreateResponse.builder()
                .groupId(group.getGroupId())
                .facultyId(group.getFacultyId())
                .build();
    }
}
