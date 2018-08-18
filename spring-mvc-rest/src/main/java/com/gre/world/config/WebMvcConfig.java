package com.gre.world.config;

import com.gre.world.http.message.PropertiesPersonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author 风骚的GRE
 * @Descriptions Web MVC 配置
 * @date 2018/8/18.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        //messageConverters.set(0,new MappingJackson2HttpMessageConverter());
        messageConverters.add(new PropertiesPersonHttpMessageConverter());
    }
}
