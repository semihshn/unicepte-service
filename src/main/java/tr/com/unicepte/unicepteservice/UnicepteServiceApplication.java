package tr.com.unicepte.unicepteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UnicepteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnicepteServiceApplication.class, args);
    }

}
