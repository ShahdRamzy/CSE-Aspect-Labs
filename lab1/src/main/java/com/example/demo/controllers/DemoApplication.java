package com.example.demo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		//SpringApplication.run(DemoApplication.class, args);
		GetController Gcont = context.getBean(GetController.class);
		DeleteController Dcont = context.getBean(DeleteController.class);
		PostController Pocont = context.getBean(PostController.class);
		PutController Pucont = context.getBean(PutController.class);

		//cont.handleRequest();


	}
}

