package com.exercise.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class ClassMethodCount {

    private static Map<String, Integer> countClassMethod = new HashMap<>();

    @Pointcut("execution(* com.exercise.*.*.*.*(..))")
    public void pointcutClassCount() {
    }

    @Around("pointcutClassCount()")
    public Object aroundClassCount(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getDeclaringType().getSimpleName() + "." + signature.getName();
        if (countClassMethod.containsKey(name)) {
            countClassMethod.put(name, countClassMethod.get(name) + 1);
        } else {
            countClassMethod.put(name, 1);
        }
        try {
            return joinPoint.proceed();
        } finally {
            for (String st : countClassMethod.keySet()) {
                System.out.println(st + " = " + countClassMethod.get(st));
            }
        }
    }
}
