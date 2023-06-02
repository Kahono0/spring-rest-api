package com.lab.lab1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "<body style=\"background-color:powderblue;\"><h1>Hello World!</h1></body>";
    }

}