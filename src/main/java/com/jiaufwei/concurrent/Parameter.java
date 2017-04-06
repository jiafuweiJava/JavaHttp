package com.jiaufwei.concurrent;

public class Parameter {
	  private static ThreadLocal<Parameter> _parameter= new ThreadLocal<>();
	  
	  public static void init() {
	      _parameter.set(new Parameter());
	  }
	  public static Parameter get() {
	    return _parameter.get();
	  }
	  
}