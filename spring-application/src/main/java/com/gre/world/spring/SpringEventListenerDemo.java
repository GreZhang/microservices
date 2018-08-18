package com.gre.world.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author 风骚的GRE
 * @Descriptions Spring事件
 * @date 2018/8/8.
 */
public class SpringEventListenerDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        /*context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.err.println("监听:"+event);
            }
        });*/
        // 添加自定义监听器
        context.addApplicationListener(new ClosedListener());
        context.addApplicationListener(new RefreshedListener());
        // 启动Spring上下文
        context.refresh();
        // 一个ContextRefreshedEvent
        // 一个PayloadApplicationEvent
        // Spring 应用上下文发布事件
        context.publishEvent("Hello,World!");
        // 发布自定义事件
        context.publishEvent(new MyEvent("HelloWorld2018"));
        // 关闭应用上下文
        context.close();
    }

    private static class RefreshedListener implements ApplicationListener<ContextRefreshedEvent> {
        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.println("上下文启动：" + event);
        }
    }

    private static class ClosedListener implements ApplicationListener<ContextClosedEvent> {
        @Override
        public void onApplicationEvent(ContextClosedEvent event) {
            System.out.println("关闭上下文：" + event);
        }
    }

    /**
     * 自定义事件类
     */
    private static class MyEvent extends ApplicationEvent{
        public MyEvent(Object source) {
            super(source);
        }
    }
}
