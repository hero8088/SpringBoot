package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.example")
@SpringBootApplication
public class MyTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(MyTest2Application.class, args);
	}

}
