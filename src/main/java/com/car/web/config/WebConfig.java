package com.car.web.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = new ObjectMapper();

        //null字段不返回
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // mybatis 使用懒加载后，返回JSON报错
        // 而且这个配置不能放在“null字段不返回”配置前面，否则"null字段不返回"配置会失效
        // @see <a href="https://blog.csdn.net/justinytsoft/article/details/53575236"></a>
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
        converters.add(jackson2HttpMessageConverter);
    }
}
