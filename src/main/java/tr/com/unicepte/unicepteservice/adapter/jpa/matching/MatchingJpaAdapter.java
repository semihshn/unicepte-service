package tr.com.unicepte.unicepteservice.adapter.jpa.matching;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.unicepte.unicepteservice.adapter.jpa.common.Status;
import tr.com.unicepte.unicepteservice.adapter.jpa.group.GroupEntity;
import tr.com.unicepte.unicepteservice.adapter.jpa.student.StudentEntity;
import tr.com.unicepte.unicepteservice.domain.group.Group;
import tr.com.unicepte.unicepteservice.domain.port.MatchingPort;
import tr.com.unicepte.unicepteservice.domain.student.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingJpaAdapter implements MatchingPort {

    private final MatchingJpaRepository matchingJpaRepository;

    @Override
    public void create(Group group, List<Student> students) {

        GroupEntity groupEntity = GroupEntity.from(group);

        List<MatchingEntity> matchingEntities = students.stream()
                .map(student -> {
                    StudentEntity studentEntity = StudentEntity.from(student);

                    MatchingEntity matchingEntity = new MatchingEntity();
                    matchingEntity.setGroup(groupEntity);
                    matchingEntity.setStudent(studentEntity);
                    matchingEntity.setStatus(Status.ACTIVE);
                    return matchingEntity;
                }).toList();

        matchingJpaRepository.saveAll(matchingEntities);
    }

    @Override
    public List<Student> retrieveStudentsByGroupId(Long groupId) {
        return matchingJpaRepository.findAllByGroup_Id(groupId)
                .stream()
                .map(MatchingEntity::getStudent)
                .map(StudentEntity::toModel)
                .toList();
    }

    @Override
    public List<Group> retrieveGroupsByStudentId(Long studentId) {
        return matchingJpaRepository.findAllByStudent_Id(studentId)
                .stream()
                .map(MatchingEntity::getGroup)
                .map(GroupEntity::toModel)
                .toList();
    }

    @Override
    public void delete(Long matchingId) {
        matchingJpaRepository.findById(matchingId)
                .ifPresent(matchingEntity -> {
                    matchingEntity.setStatus(Status.DELETED);
                    matchingJpaRepository.save(matchingEntity);
                });
    }
}
