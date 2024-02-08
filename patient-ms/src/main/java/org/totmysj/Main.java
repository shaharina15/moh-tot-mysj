package org.totmysj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
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