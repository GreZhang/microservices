package com.gre.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableWebMvc
public class SpringBootRestApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootRestApplication.class,args);
    }
}
