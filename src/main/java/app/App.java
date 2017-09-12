package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"controllers", "entities", "services"})
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {
            SpringApplication.run(App.class,args);
    }
}
