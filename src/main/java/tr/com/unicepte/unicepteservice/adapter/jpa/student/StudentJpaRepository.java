package tr.com.unicepte.unicepteservice.adapter.jpa.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {
}
