package com.gre.world;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.gre.world.jpa")
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringBootJpaApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootJpaApplication.class,args);
    }
}
