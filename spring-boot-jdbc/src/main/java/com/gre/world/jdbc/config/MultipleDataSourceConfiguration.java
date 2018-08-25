package com.gre.world.jdbc.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author 风骚的GRE
 * @Descriptions 多数据源配置
 * @date 2018/8/19.
 */
@Configuration
public class MultipleDataSourceConfiguration {

    @Bean
    @Primary
    public DataSource masterDataSource(){
//        spring.datasource.driverClassName=com.mysql.jdbc.Driver
//        spring.datasource.url=jdbc:mysql://localhost:3306/test
//        spring.datasource.username=root
//        spring.datasource.password=root
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/test")
                .username("root")
                .password("root")
                .build();
        return  dataSource;
    }

    @Bean
    public DataSource slaveDataSource(){
        DataSource dataSource = DataSourceBuilder.create()
                .driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/test")
                .username("root")
                .password("root")
                .build();
        return  dataSource;
    }
}
