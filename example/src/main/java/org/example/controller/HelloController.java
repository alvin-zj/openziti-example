package org.example.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/helloZiti")
    public String helloZiti() {
        return "Hello OpenZiti";
    }
}
