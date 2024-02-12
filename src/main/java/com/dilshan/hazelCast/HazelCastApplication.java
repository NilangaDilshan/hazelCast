package com.dilshan.hazelCast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HazelCastApplication {

    public static void main(String[] args) {
        SpringApplication.run(HazelCastApplication.class, args);
    }

}
