package com.car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 微信公众号主类
 * @author zengzhaohu
 *
 */
@EnableScheduling
@SpringBootApplication
@MapperScan(basePackages = "com.car.web.mapper")
public class ChecheApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(ChecheApplication.class, args);
	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(ChecheApplication.class);
    }
}
