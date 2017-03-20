package com.hskj.mapper;

import java.util.List;  
import java.util.Map;  
import org.springframework.stereotype.Service;  
import com.hskj.domain.User;  
  
@Service("userMapper")  
public interface UserMapper {  
    public int countAll();  
    public void insertUser(User user);  
    public List<User> getAllUser();  
    public User getById(String id);  
    public void deleteUser(String id);  
    public void updateUser(Map<String,Object> map);  
}  