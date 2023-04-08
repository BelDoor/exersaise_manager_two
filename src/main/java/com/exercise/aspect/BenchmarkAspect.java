package com.exercise.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class BenchmarkAspect {

    @Pointcut("execution(* com.exercise.repository.*.*.*(..))")
    public void repositoryPointcut() {
    }

    @Around("repositoryPointcut()")
    public Object endBenchmark(ProceedingJoinPoint jp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch benchmark = new StopWatch();
        benchmark.start();

        try {
            return jp.proceed();
        } finally {
            benchmark.stop();
            System.err.println(className + "." + methodName + "() " + benchmark.getTotalTimeMillis() + "ms");
        }
    }
}
