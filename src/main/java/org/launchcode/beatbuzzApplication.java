package org.launchcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan("org.launchcode.config.JacksonConfig")
public class beatbuzzApplication {

    public static void main(String[] args) {
        SpringApplication.run(beatbuzzApplication.class, args);
    }

}
