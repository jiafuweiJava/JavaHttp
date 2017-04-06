package com.jiaufwei.springaop.test;

import java.util.HashMap;  
import java.util.Map;  
  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
  
import com.hskj.domain.User;  
import com.hskj.service.UserService;  

/**
 * 参考地址http://blog.csdn.net/bao19901210/article/details/41724355
 * @author jiafuwei
 *
 */
public class UserServiceTest {  
	
	 public static void main( String[] args )  {  
		  //使用xml的方式配置的事物
		  ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext-t.xml");  
		  UserService userService1 = (UserService) context1.getBean("userService");
	      
		  /*
		   * 基于注解的声明式事务管理配置@Transactional
		   * @Transactional 可以作用于接口、接口方法、类以及类方法上。当作用于类上时，该类的所有 public 方法将都具有该类型的事务属性
		   */
		  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-t2.xml");  
		  UserService userService = (UserService)context.getBean("userServiceT2");  
	        User user =new User();  
	        user.setId("006");  
	        user.setName("6hao");  
	          
	        Map map=new HashMap();  
	        map.put("id", "001");  
	        map.put("name", "fangzhouzi2");  
	        try {  
	              System.out.println(userService.countAll());  
	              //userService.deleteUser("1");
	              userService.update_insert(map, user);  
	              //userService.insertUser(user);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } 
	        
	          
	    } 
      
   
} 
