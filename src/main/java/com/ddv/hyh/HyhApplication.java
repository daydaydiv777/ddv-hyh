package com.ddv.hyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ddv.hyh.dao")
public class HyhApplication {
    public static void main(String[] args) {
        SpringApplication.run(HyhApplication.class, args);
    }
}
