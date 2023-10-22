package com.bob.bobpal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bob.bobpal.mapper")
public class BobPalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BobPalApplication.class, args);
    }

}
