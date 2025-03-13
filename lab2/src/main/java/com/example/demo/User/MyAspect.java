package com.example.demo.User;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
class MyAspect {
    @Before("execution(* com.example.demo.User.*(..))")
    public void logBeforeControllerMethods(JoinPoint joinPoint) {
        System.out.println("[BEFORE] Method called: " + joinPoint.getSignature().getName());


        Object[] args = joinPoint.getArgs();
        for (Object arg : args)  {
            if (arg != null) {
                System.out.println("[DATA]: " + arg.toString());
            }
        }
    }
}
