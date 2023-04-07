package com.starrysky.infocollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InfocollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfocollectionApplication.class, args);
    }

}
