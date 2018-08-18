package com.gre.world.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author 风骚的GRE
 * @Descriptions TODO
 * @date 2018/8/8.
 */
@Configuration
public class SpringAnnotationDemo {
    public static void main(String[] args) {
        //   XML 配置文件驱动       ClassPathXmlApplicationContext
        // Annotation 驱动
        // 找 BeanDefinition
        // @Bean @Configuration
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册一个 @configuration class = SpringAnnotationDemo
        context.register(SpringAnnotationDemo.class);
        // 上下文启动
        context.refresh();
        System.out.println(context.getBean(SpringAnnotationDemo.class));
    }
}
