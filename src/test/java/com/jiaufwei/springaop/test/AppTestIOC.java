package com.jiaufwei.springaop.test;

 
  
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jiaufwei.springioc.SpringAction;
import com.jiaufwei.springioc.SpringAction2;
  
/** 
 * 利用Spring ioc 注入
 * 
 */  
public class AppTestIOC   {  
    public static void main( String[] args )  {  
        
        BeanFactory factory = new ClassPathXmlApplicationContext("iocbeans.xml");  
        SpringAction springAction = (SpringAction)factory.getBean("springAction"); 
        SpringAction2 springAction2 = (SpringAction2)factory.getBean("springAction2"); 
        
        springAction.ok();
        springAction2.save();
        
          
    }  
} 
