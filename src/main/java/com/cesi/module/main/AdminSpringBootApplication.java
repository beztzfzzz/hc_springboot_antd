package com.cesi.module.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan
@MapperScan(basePackages = "com.cesi.module.main.*.dao")//mapper接口的路径
public class AdminSpringBootApplication
{
	public static void main(String[] args) {  
        SpringApplication.run(AdminSpringBootApplication.class, args);
    }  
}
