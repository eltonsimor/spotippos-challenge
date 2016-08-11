package br.com.spotippos.challenge.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Elton Moraes
 * @since 04/08/2016.
 */
@SpringBootApplication(scanBasePackages = {
        "br.com.spotippos.challenge.rest",
        "br.com.spotippos.challenge.service",
        "br.com.spotippos.challenge.task"
})
@EnableAutoConfiguration
@Configuration
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
