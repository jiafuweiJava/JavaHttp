package com.jiaufwei.springioc;

/**
 * spring有多种依赖注入的形式，下面仅介绍spring通过xml进行IOC配置的方式：
 * Set注入
 * @author jiafuwei
 *
 */
public class SpringAction {  
    //注入对象springDao 
	private SpringDao springDao; 
	
	//一定要写被注入对象的set方法  
	public void setSpringDao(SpringDao springDao) {  
	    this.springDao = springDao;  
	}  

    public void ok(){  
    	springDao.ok();
    }  
}  
