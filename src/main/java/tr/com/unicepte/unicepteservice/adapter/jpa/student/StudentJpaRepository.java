package tr.com.unicepte.unicepteservice.adapter.jpa.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findAllByIdIn(List<Long> ids);
}
