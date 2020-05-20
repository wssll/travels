package com.tv.travels;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.tv.travels.dao")
public class TravelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelsApplication.class, args);
    }

}
