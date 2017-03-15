package com.jiaufwei.javahttp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * java原生发送http POST GET请求 以及流的输出
 * 使用 java.net.HttpURLConnection 发送请求
 * @author jiafuwei
 *
 */
public class HttpURLConnectionTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//get();
		post();
		//outputStream();
	}
	
	/**
	 * GET方式请求
	 * @return
	 */
	public static String get(){
		String validateURL="http://www.163.com";
		HttpURLConnection conn = null;
		try {
			URL url = new URL(validateURL); //创建URL对象
		    //返回一个URLConnection对象，它表示到URL所引用的远程对象的连接
		    conn = (HttpURLConnection) url.openConnection();
		    conn.setConnectTimeout(5000); //设置连接超时为5秒
		    conn.setRequestMethod("GET"); //设定请求方式
		    conn.connect(); //建立到远程对象的实际连接
		    
		    //判断是否正常响应数据 
		    System.out.println(conn.getResponseCode());
		    String result = "";
		    if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
		    	System.out.println("网络错误异常！!!!");
		        return  "";
		    }else{
		    	//返回打开连接读取的输入流
		    	InputStreamReader input = new InputStreamReader(conn.getInputStream(), "gbk");
			    BufferedReader bufReader = new BufferedReader(input);
			    String line = "";
			    StringBuilder contentBuf = new StringBuilder();
			    while ((line = bufReader.readLine()) != null) {
			    	contentBuf.append(line);
			    }
			    result = contentBuf.toString();
			    System.out.println(result);
			    return  result;
		    }
		    	
		} catch (Exception e) {
		   e.printStackTrace();
		   System.out.println("这是异常！");
		} finally {
		    if (conn != null) {
		    	conn.disconnect(); //中断连接
		    }
		}
		return  "";
	}

	/**
	 * 使用POST方式进行传输
	 * @return
	 * @throws Exception
	 */
	public static String post() throws  Exception{
		URL url = null;
        try {
            url = new URL("http://localhost:9090/api/smallball/memberOrderInfo!useMemberAccountPay.do");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");// 提交模式
            httpURLConnection.setConnectTimeout(10000);//连接超时 单位毫秒
            httpURLConnection.setReadTimeout(2000);//读取超时 单位毫秒
            // 发送POST请求必须设置如下两行
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            // 发送请求参数
            printWriter.write("order_id=1");//post的参数 xx=xx&yy=yy
            // flush输出流的缓冲
            printWriter.flush();
            //开始获取数据
            BufferedInputStream bis = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] arr = new byte[1024];
            while((len=bis.read(arr))!= -1){
                bos.write(arr,0,len);
                bos.flush();
            }
            bos.close();
            String result = bos.toString("utf-8");
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
			
		return "";
	}
	/**
	 * 使用输出流的方式进行请求
	 * <br>服务器接收方式：
	 * <br>使用 HttpServletRequest request = 获取 request
	 * <br>ServletInputStream servletInputStream = request.getInputStream();
	 * <br>InputStreamReader input = new InputStreamReader(servletInputStream, "utf-8");
	 * <br>即可接收到传输的xml信息
	 * @return
	 * @throws IOException
	 */
	public static String outputStream() throws  IOException{
		String xml="order_id=1";
		String encoding="UTF-8";
		byte[] data = xml.getBytes(encoding); //转换内容的编码格式   
		System.out.println(data.length);
		URL url = new URL("http://localhost:9090/api/smallball/memberOrderInfo!useMemberAccountPay.do");//请求的API地址
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setRequestProperty("Content-Type", "application/xml;charset="+encoding);
		httpConn.setRequestProperty("Content-Length", String.valueOf(data.length));
		httpConn.setConnectTimeout(10*1000);
		OutputStream outStream = httpConn.getOutputStream();
		outStream.write(data);//输出文件内容
		outStream.flush();
		outStream.close();
		String result = "";
		if(httpConn.getResponseCode()==200){//响应成功返回
			InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
		    BufferedReader bufReader = new BufferedReader(input);
		    String line = "";
		    StringBuilder contentBuf = new StringBuilder();
		    while ((line = bufReader.readLine()) != null) {
		    	contentBuf.append(line);
		    }
		    result = contentBuf.toString();
		    System.out.println(result);//输出返回的结果
		}else{
			System.out.println("连接出错，状态码："+httpConn.getResponseCode());//输出返回的结果
		}
			
		return result;
	}
	
	
}
