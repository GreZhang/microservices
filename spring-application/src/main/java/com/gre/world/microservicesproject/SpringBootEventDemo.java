package com.gre.world.microservicesproject;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author 风骚的GRE
 * @Descriptions TODO
 * @date 2018/8/8.
 */
@EnableAutoConfiguration
public class SpringBootEventDemo {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootEventDemo.class)
                .listeners(event -> {// 增加监听器
                    System.out.println("监听到事件:"+event.getClass().getSimpleName());
                })
                .run(args) // 运行
                .close(); // 关闭
    }
}
