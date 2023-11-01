package com.bob.bobpal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.bob.bobpal.mapper")
@EnableScheduling
public class BobPalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BobPalApplication.class, args);
    }

}
