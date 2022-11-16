package tr.com.unicepte.unicepteservice.adapter.rest.group.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tr.com.unicepte.unicepteservice.adapter.rest.student.response.StudentResponse;
import tr.com.unicepte.unicepteservice.domain.group.Group;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponse {
    private Long groupId;
    private String name;
    private List<StudentResponse> students;

    public static GroupResponse from(Group group) {
        return GroupResponse.builder()
                .groupId(group.getGroupId())
                .name(group.getName())
                .build();
    }

    public static GroupResponse from(Group group, List<Student> students) {
        return GroupResponse.builder()
                .groupId(group.getGroupId())
                .name(group.getName())
                .students(StudentResponse.from(students))
                .build();
    }

    public static List<GroupResponse> from(List<Group> groups) {

        return groups.stream()
                .map(group -> GroupResponse.from(group, group.getStudents()))
                .toList();
    }
}
