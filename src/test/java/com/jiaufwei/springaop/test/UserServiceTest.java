package com.jiaufwei.springaop.test;

import java.util.HashMap;  
import java.util.Map;  
  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
  
import com.hskj.domain.User;  
import com.hskj.service.UserService;  

public class UserServiceTest {  
	
	 public static void main( String[] args )  {  
	        
		  ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-t.xml");  
	        UserService userService = (UserService)context.getBean("userService");  
	        User user =new User();  
	        user.setId("006");  
	        user.setName("6hao");  
	          
	        Map map=new HashMap();  
	        map.put("id", "001");  
	        map.put("name", "fangzhouzi1");  
	        try {  
	              System.out.println(userService.countAll());  
	              userService.deleteUser("1");
	              //userService.update_insert(map, user);  
	              //userService.insertUser(user);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } 
	        
	          
	    } 
      
   
} 
