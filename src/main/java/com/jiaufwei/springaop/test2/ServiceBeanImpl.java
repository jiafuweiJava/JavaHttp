package com.jiaufwei.springaop.test2;

import java.util.HashMap;  
import java.util.Map;  
  
public class ServiceBeanImpl implements ServiceBean {  
      
    private String dir;  
    private Map map=new HashMap();  
      
    public void addUser(String userName,String password){  
        if(!map.containsValue(userName))  
            map.put(userName, password);  
        else  
            throw new RuntimeException("user has already exited!");  
          
    }  
      
    public void  deleteUser(String userName){  
        if(!map.containsKey(userName))  
            throw new RuntimeException("user isn't exited");  
        map.remove(userName);  
    } 
    
    public boolean findUser(String userName){  
          
        return map.containsKey(userName);  
    }  
      
    public String getPassword(String userName){  
        return(String) map.get(userName);  
    }  
    
    public void setDir(String dir){  
          
        this.dir=dir;  
        System.out.println("set user to:"+dir);  
    }  
}  
