package com.hskj.dao;

import java.util.List;  
import java.util.Map;  
  
import com.hskj.domain.User;  
  
public interface UserDao {  
        public int countAll();  
        public void insertUser(User user);  
        public List<User> getAllUser();  
        public User getById(String id);  
        public void deleteUser(String id);  
        public void updateUser(Map<String,Object> map);  
  
} 
