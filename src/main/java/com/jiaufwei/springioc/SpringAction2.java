package com.jiaufwei.springioc;

/**
 * spring有多种依赖注入的形式，下面仅介绍spring通过xml进行IOC配置的方式：
 * 构造器注入
 * @author jiafuwei
 *
 */
public class SpringAction2 {  
	 //注入对象springDao  
    private SpringDao springDao;  
    private User user;  
      
    public SpringAction2(SpringDao springDao,User user){  
        this.springDao = springDao;  
        this.user = user;  
        System.out.println("构造方法调用springDao和user");  
    }  
          
    public void save(){  
        user.setName("卡卡");  
        springDao.save(user);  
    }  
}  
