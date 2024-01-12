package com.groupeisi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.groupeisi.mapping")
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
}