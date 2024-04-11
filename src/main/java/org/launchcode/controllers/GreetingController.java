package org.launchcode.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("api/hello")
    public String getHelloMessage() {
        return "AHAHAHHAAHHAHAhA";
    }
}
