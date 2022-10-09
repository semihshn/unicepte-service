package tr.com.unicepte.unicepteservice.adapter.rest.group.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tr.com.unicepte.unicepteservice.domain.group.Group;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponse {
    private Long groupId;
    private Long studentId;
    private String name;

    public static GroupResponse from(Group group) {
        return GroupResponse.builder()
                .groupId(group.getGroupId())
                .studentId(group.getStudentId())
                .name(group.getName())
                .build();
    }
}
