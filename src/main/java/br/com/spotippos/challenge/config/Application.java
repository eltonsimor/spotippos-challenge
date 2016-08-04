package br.com.spotippos.challenge.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mtzcpd663 on 04/08/2016.
 */
@SpringBootApplication(scanBasePackages = {"br.com.spotippos.challenge.rest"})
@EnableAutoConfiguration
@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
