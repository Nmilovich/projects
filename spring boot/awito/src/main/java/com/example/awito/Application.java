package com.example.awito;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// chmod +x scripts/deploy.sh
// ./scripts/deploy.sh

//в проперти для локалки
//hostname=192.168.1.51

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
