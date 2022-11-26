package tr.com.unicepte.unicepteservice.adapter.jpa.group;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.Status;
import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.group.Group;
import tr.com.unicepte.unicepteservice.domain.port.GroupPort;
import tr.com.unicepte.unicepteservice.domain.util.exception.ExceptionType;
import tr.com.unicepte.unicepteservice.domain.util.exception.UcepteDataNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupJpaAdapter implements GroupPort {

    private final GroupJpaRepository groupJpaRepository;

    @Override
    public Group create(Group group, Faculty faculty) {
        GroupEntity groupEntity = GroupEntity.from(group, faculty);
        return groupJpaRepository.save(groupEntity).toModel();
    }

    @Override
    public Group retrieve(Long groupId) {
        return groupJpaRepository.findById(groupId)
                .orElseThrow(() -> new UcepteDataNotFoundException(ExceptionType.GROUP_DATA_NOT_FOUND))
                .toModel();
    }

    @Override
    public List<Group> retrieveAll() {
        return groupJpaRepository.findAll()
                .stream()
                .map(GroupEntity::toModel).toList();
    }

    @Override
    public Group update(Group group) {

        GroupEntity updateEntity = GroupEntity.from(group);
        return groupJpaRepository.save(updateEntity).toModel();
    }

    @Override
    public void delete(Long groupId) {
        groupJpaRepository.findById(groupId)
                .ifPresent(groupEntity -> {
                    groupEntity.setStatus(Status.DELETED);
                    groupJpaRepository.save(groupEntity);
                });
    }
}
