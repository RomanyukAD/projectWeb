package qa.stub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.boot.SpringApplication.run;


@SpringBootApplication
public class StubServer {
    public static void main(String[] args) {

        SpringApplication.run(StubServer.class, args);
    }
}