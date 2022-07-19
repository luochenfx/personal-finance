package com.luochen.financial.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luochen.financial.config.jackson.JacksonBeanSerializerModifier;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author luochenfx
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void extendMessageConverters(@NotNull List<HttpMessageConverter<?>> converters) {
		System.out.println("WebConfig.extendMessageConverters");
		System.out.println(converters);
	}

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



}
