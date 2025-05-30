package org.example;

import org.example.controller.HelloController;
import org.openziti.springboot.ZitiTomcatCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication (
        scanBasePackageClasses = {ZitiTomcatCustomizer.class, HelloController.class}
)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}