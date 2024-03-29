package com.example.third_lesson.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class LoggingAspect {

    @Before("execution(public void addOrderForUser(..))")
    public void beforeAddOrderForUser(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        log.info("Выполнение метода {} c аргументами {}", methodSignature, args);

    }

    @Before("execution(public * saveOrder(*))")
    public void beforeSaveOrder(){
        log.info("Попытка сохранить заказ");
    }
    @After("execution(public * saveOrder(*))")
    public void afterSaveOrder(){
        log.info("Заказ сохранен");
    }

    @Before("execution(public * getById(*))")
    public void beforeGetOrderById(JoinPoint joinPoint){
        log.info("Попытка получить заказ по айди {}", joinPoint.getArgs());
    }
    @AfterThrowing(pointcut = "execution(public * getById(*))", throwing = "exception")
    public void beforeGetOrderById(RuntimeException exception){
        log.info("Выброшено исключение {} при попытке получить заказ", exception.getMessage());
    }

    @After("execution(public * getById(*))")
    public void afterGetOrderById(){
        log.info("Заказ успешно получен");
    }

    @Before("execution(public void deleteOrder(*))")
    public void beforeDeleteOrder(JoinPoint joinPoint){
        log.info("Попытка удалить заказ {}", joinPoint.getArgs());

    }

    @After("execution(public void deleteOrder(*))")
    public void afterDeleteOrder(){
        log.info("Заказ удален");
    }




}
