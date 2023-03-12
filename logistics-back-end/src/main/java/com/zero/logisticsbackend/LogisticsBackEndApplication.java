package com.zero.logisticsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author ZERO
 */
@SpringBootApplication
@EnableCaching
public class LogisticsBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsBackEndApplication.class, args);
    }

}
