package tr.com.unicepte.unicepteservice.domain.port;

import tr.com.unicepte.unicepteservice.domain.faculty.Faculty;
import tr.com.unicepte.unicepteservice.domain.group.Group;

import java.util.List;

public interface GroupPort {

    Group create(Group group, Faculty faculty);

    Group retrieve(Long groupId);

    List<Group> retrieveAll();

    Group update(Group group);

    void delete(Long groupId);

}
