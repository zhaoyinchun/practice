package com.example.demo0825;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@ComponentScan("com.example.demo0825.controller")
@MapperScan(value = {"com.example.demo0825.mapper"})
public class Demo0825Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo0825Application.class, args);
        System.out.println("Hey!");
    }
}
