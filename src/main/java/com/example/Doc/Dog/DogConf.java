package com.example.Doc.Dog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
public class DogConf {

    @Bean
    CommandLineRunner commandLineRunner(DogRepository repository) {
        return args -> {
            DogModel xuca=new DogModel(
                    "Xuca",
                    "Vira Lata",
                    2

            );

            DogModel rex=new DogModel(

                    "Rex",
                    "Vira Lata",
                    2

            );

            repository.saveAll(List.of(xuca,rex));
        };
    }

}
