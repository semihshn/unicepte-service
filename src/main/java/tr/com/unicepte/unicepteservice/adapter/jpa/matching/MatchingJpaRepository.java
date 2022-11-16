package tr.com.unicepte.unicepteservice.adapter.jpa.matching;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchingJpaRepository extends JpaRepository<MatchingEntity, Long> {

    List<MatchingEntity> findAllByGroup_Id(Long groupId);

    List<MatchingEntity> findAllByStudent_Id(Long studentId);

}
