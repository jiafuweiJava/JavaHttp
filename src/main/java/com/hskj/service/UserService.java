package com.hskj.service;

import java.util.Map;  

import com.hskj.domain.User;  
  
public interface UserService {  
    public int countAll(); 
    
    public void insertUser(User user);
    
    public void update_insert(Map map,User user); 
    
    public void deleteUser(String id); 
} 
