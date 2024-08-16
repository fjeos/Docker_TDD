package com.example.dockercomposedetmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerComposeDetmoApplication {

    @GetMapping("/api/health")
    public String health() {
        return "okay";
    }
    public static void main(String[] args) {
        SpringApplication.run(DockerComposeDetmoApplication.class, args);
    }

}
