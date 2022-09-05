package com.nikolaikozlovskii.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {
    @Around("execution(* com.nikolaikozlovskii.spring.mvc_hibernate_aop.*.*(..))")
    public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
       String metodName = methodSignature.getName();

        System.out.println("Begin of " + metodName);

       Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("End of " + metodName);

       return targetMethodResult;
    }
}
