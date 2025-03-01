package com.example.demo.controllers;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
class MyAspect {
    @Before("execution(* com.example.demo.controllers..*(..))")
    public void BeforeAllControllers() {
        System.out.println("Before All Controllers");
    }
}
