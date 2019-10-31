package com.sapa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sapa.dao")
public class SapaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SapaApplication.class, args);
    }

}
