# JavaHttp
java实现http请求的各种方式
-------------------
在这个java项目中，主要使用了四种方式，实现HTTP的GEP和POST请求，以及文件（图片）传输、输出流：
* 1、使用org.apache.http中的HttpClient发送HTTP请求
* 2、使用org.apache.commons.httpclient包中的HTTP客户端发送HTTP请求
* 3、使用java原生提供的java.net.HttpURLConnection 发送HTTP POST GET请求 以及流的输出 
* 4、使用使用com.sun.jersey 的客户端调用HTTP请求
-------------------
### 另外包中的HttpConnectionUtil工具类，提供了java原生的HTTP POST请求提交form表单参数以及文件file
  
-------------------
新增以下内容的学习
* 1、使用注解的方式配置 Spring AOP 测试类App.java
* 2、利用Spring AOP的组件,完成动态代理,测试类AppTest02.java
* 3、使用Spring IOC控制反转 利用set和构造器注入bean,测试类 AppTestIOC.java
* 4、Spring整合Mybatis配置声明式事物管理，测试类UserServiceTest.java 当项目抛出异常时,自动回滚事物
-------------------