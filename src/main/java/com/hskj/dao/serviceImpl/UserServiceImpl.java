package com.hskj.dao.serviceImpl;

import java.util.Map;  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
  
import com.hskj.dao.UserDao;  
import com.hskj.domain.User;  
import com.hskj.service.UserService; 

@Service("userService")  
public class UserServiceImpl implements UserService {  
    @Autowired  
    private UserDao userDao;  
    
    public int countAll() {  
        return this.userDao.countAll();  
    }  
  
    public void insertUser(User user) {  
        this.userDao.insertUser(user);  
        throw new RuntimeException("Error");  
    }  
  
  
    public void update_insert(Map map,User user) {  
        this.userDao.updateUser(map);  
        this.userDao.insertUser(user);  
        throw new RuntimeException("Error");  
    }  
      
    public void deleteUser(String id) {  
        this.userDao.deleteUser(id);  
        //throw new RuntimeException("deleteUser Error");
        int a = 1/0;
    } 
} 