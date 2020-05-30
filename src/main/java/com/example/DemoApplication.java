package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.controller","com.example.service"})
/*
该注解默认会扫描该类所在的包下所有的配置类，相当于之前的 <context:component-scan>。
 */
@MapperScan(basePackages = {"com.example.dao"})
/*
指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
 */
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
