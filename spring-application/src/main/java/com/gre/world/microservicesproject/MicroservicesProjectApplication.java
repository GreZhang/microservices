package com.gre.world.microservicesproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 风骚的GRE
 * @Descriptions Spring boot 启动
 * @date 2018/8/6.
 */
@SpringBootApplication
public class MicroservicesProjectApplication {
    public static void main(String[] args) {
        // 启动Spring boot方式一
        //SpringApplication.run(MicroservicesProjectApplication.class,args);
        SpringApplication springApplication = new SpringApplication(MicroservicesProjectApplication.class);
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("server.port",0);
        springApplication.setDefaultProperties(properties);
        // 设置为非web应用
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println(context.getBean(MicroservicesProjectApplication.class));
        // 输出当前spring boot 应用的ApplicationContext的类名
        System.err.println("当前Spring应用上下文:"+context.getClass().getName());

        // 等价方式
        /*new SpringApplicationBuilder(MicroservicesProjectApplication.class)// fluent API
                .properties("server.port=0")//随机端口,随机向操作系统OS要一个可以用的端口,这个在单元测试时非常有用
                .run(args);*/
    }
}
