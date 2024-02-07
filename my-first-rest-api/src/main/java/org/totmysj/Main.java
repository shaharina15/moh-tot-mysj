package org.totmysj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableCaching

public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);

        //run command mvn spring-boot:run
        //System.out.println("Hello world!");
    }
}