package az.ingress.msorder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
@EnableFeignClients
public class MsOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class, args);
    }
}
