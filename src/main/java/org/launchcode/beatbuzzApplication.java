package org.launchcode;

import org.launchcode.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class beatbuzzApplication {

    public static void main(String[] args) {
        SpringApplication.run(beatbuzzApplication.class, args);
    }

}
