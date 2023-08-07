package az.ingress.mstickets;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class MsTicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsTicketsApplication.class, args);
    }

    @PostConstruct
    public void test() {
        log.info("Running");
    }
}
