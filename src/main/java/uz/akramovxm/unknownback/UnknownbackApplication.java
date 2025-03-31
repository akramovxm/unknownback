package uz.akramovxm.unknownback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UnknownbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnknownbackApplication.class, args);
    }

}
