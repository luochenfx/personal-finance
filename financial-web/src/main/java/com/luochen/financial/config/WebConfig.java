package com.luochen.financial.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luochen.financial.config.jackson.JacksonBeanSerializerModifier;
import com.luochen.financial.interceptor.ResponseResultInterceptor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author luochenfx
 */
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final ResponseResultInterceptor responseResultInterceptor;

    @Override
    public void extendMessageConverters(@NotNull List<HttpMessageConverter<?>> converters) {
        System.out.println("WebConfig.extendMessageConverters");
        System.out.println(converters);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseResultInterceptor);
    }


    /**
     * jackson 序列化器
     * @param builder jackson builder
     * @return jackson
     */
    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializerFactory(objectMapper.getSerializerFactory().withSerializerModifier(new JacksonBeanSerializerModifier()));
        return objectMapper;
    }

    /**
     * 跨域配置
     * @param registry 跨域资源共享登记
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")
                //是否发送Cookie
                .allowCredentials(true)
                //放行哪些原始域
                .allowedOriginPatterns("*")
                //放行哪些请求方式
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                //.allowedMethods("*") //或者放行全部
                //放行哪些原始请求头部信息
                .allowedHeaders("*")
                //暴露哪些原始请求头部信息
                .exposedHeaders("*");
    }


}
