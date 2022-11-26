package tr.com.unicepte.unicepteservice.adapter.jpa.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    @Column(nullable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    protected LocalDateTime modifiedDate;

    @Enumerated(value = EnumType.STRING)
    protected Status status;

    @PrePersist
    void fillPersistent() {
        if (status == null) {
            this.status = Status.ACTIVE;
        }
    }
}
