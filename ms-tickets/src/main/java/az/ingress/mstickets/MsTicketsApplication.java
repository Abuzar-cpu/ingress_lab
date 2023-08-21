package az.ingress.mstickets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@Slf4j
@EnableFeignClients
public class MsTicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsTicketsApplication.class, args);
    }

}
