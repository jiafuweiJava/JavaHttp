package com.jiaufwei.springaop.test;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.BeanFactory;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  

import com.jiaufwei.springaop.CustomerManager;
  
  
/** 
 * Hello world! 
 * 
 */  
public class App   {  
    public static void main( String[] args )   {  
    	
        System.out.println( "Hello Spring AOP!" );  
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");  
        CustomerManager customerManager=(CustomerManager) factory.getBean("customerManager");  
        
        /*
         * 执行顺序
         * 执行 @Around ProceedingJoinPoint.proceed();之前的代码
         * 执行 @Before
         * 执行 @Around ProceedingJoinPoint.proceed();之后的代码
         * 执行 @After
         * 最后执行执行 @AfterReturning
         */
        customerManager.getCustomerById(2015);  
          
    }  
} 
