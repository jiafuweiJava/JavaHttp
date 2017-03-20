package com.jiaufwei.springaop.test2;

import java.lang.reflect.Method;  

import org.springframework.aop.MethodBeforeAdvice;  
  
public class LogAdvisor implements MethodBeforeAdvice {  
  
    public void before(Method method, Object[] args, Object target) throws Throwable {  
  
        System.out.println("我要打印日志喽！ [log] "+target.getClass().getName()+"."+method.getName()+"( )");  
    }  
  
}
