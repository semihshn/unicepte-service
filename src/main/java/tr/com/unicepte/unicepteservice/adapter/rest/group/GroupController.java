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
        Group group = groupService.create(request.convertToGroup());
        GroupCreateResponse groupCreateResponse = GroupCreateResponse.builder()
                .groupId(group.getGroupId())
                .build();

        return new ResponseEntity<>(groupCreateResponse, HttpStatus.CREATED);
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
        List<GroupResponse> groupResponseList = groupList.stream()
                .map(GroupResponse::from)
                .toList();

        return new ResponseEntity<>(groupResponseList, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<GroupUpdateResponse> update(@RequestBody @Valid GroupUpdateRequest request){
        Group group = groupService.update(request.convertToGroup());
        GroupUpdateResponse groupUpdateResponse = GroupUpdateResponse.builder()
                .groupId(group.getGroupId())
                .build();

        return new ResponseEntity<>(groupUpdateResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{groupId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long groupId){
        groupService.delete(groupId);
    }
}
