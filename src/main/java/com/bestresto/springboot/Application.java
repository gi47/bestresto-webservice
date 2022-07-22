package com.bestresto.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing //JpaAuditing 어노테이션을 모두 활성화
@SpringBootApplication	// {1}
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}
