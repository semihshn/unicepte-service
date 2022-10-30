package tr.com.unicepte.unicepteservice.adapter.rest.group;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.unicepte.unicepteservice.adapter.rest.group.request.GroupCreateRequest;
import tr.com.unicepte.unicepteservice.adapter.rest.group.request.GroupUpdateRequest;
import tr.com.unicepte.unicepteservice.adapter.rest.group.response.GroupCreateResponse;
import tr.com.unicepte.unicepteservice.adapter.rest.group.response.GroupResponse;
import tr.com.unicepte.unicepteservice.adapter.rest.group.response.GroupUpdateResponse;
import tr.com.unicepte.unicepteservice.domain.group.Group;
import tr.com.unicepte.unicepteservice.domain.group.GroupService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groups")
public class GroupController {

    private final GroupService groupService;

    @PostMapping()
    public ResponseEntity<GroupCreateResponse> create(@RequestBody @Valid GroupCreateRequest request) {
        Group group = request.convertToGroup();

        Group createdGroup = groupService.create(group, request.getStudentIds());

        return new ResponseEntity<>(GroupCreateResponse.convertToGroupResponse(createdGroup), HttpStatus.CREATED);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupResponse> retrieve(@PathVariable Long groupId) {
        Group group = groupService.retrieve(groupId);

        GroupResponse groupResponse = GroupResponse.from(group);

        return new ResponseEntity<>(groupResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<GroupResponse>> retrieveAll() {
        List<Group> groupList = groupService.retrieveAll();

        return new ResponseEntity<>(GroupResponse.from(groupList), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<GroupUpdateResponse> update(@RequestBody @Valid GroupUpdateRequest request) {
        Group group = groupService.update(request.convertToGroup());

        return new ResponseEntity<>(GroupUpdateResponse.from(group), HttpStatus.OK);
    }

    @DeleteMapping("/{groupId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long groupId) {
        groupService.delete(groupId);
    }
}
