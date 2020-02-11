package com.estudo.helper.facilities;

import com.estudo.helper.facilities.entities.Jwt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiDbApplication.class, args);
    }

    @Bean
    public Jwt createJwtBean() {
        return new Jwt();
    }

}
