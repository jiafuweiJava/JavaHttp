package com.jiaufwei.javahttp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * org.apache.commons.httpclient包中的http客户端 POST请求
 * 
 * @author jiafuwei
 *
 */
public class CommonsHttpClient {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//post();
		get();
	}
	
	/**
	 * post请求
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static String post() throws HttpException, IOException{
		HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://localhost:9090/api/smallball/memberOrderInfo!useMemberAccountPay.do");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=GBK");
        NameValuePair[] data = { new NameValuePair("order_id", "1") };
		post.setRequestBody(data);
		client.executeMethod(post);//执行http post请求
		Header[] headers = post.getResponseHeaders();//相应头里面的信息
		int statusCode = post.getStatusCode();//得到返回的状态码
		//得到返回的信息
		InputStreamReader input = new InputStreamReader(post.getResponseBodyAsStream(), "utf-8");
        BufferedReader bufReader = new BufferedReader(input);
        String result = "";
        String line = "";
        StringBuilder contentBuf = new StringBuilder();
        while ((line = bufReader.readLine()) != null) {
            contentBuf.append(line);
        }
        result = contentBuf.toString();
		//String result = new String(post.getResponseBodyAsString().getBytes("UTF-8"));
		System.out.println(result);
		return result;
	}
	/**
	 * GET请求
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static String get() throws HttpException, IOException{
		HttpClient client = new HttpClient();
        String url = "http://apis.baidu.com/datatiny/cardinfo/cardinfo?cardnum=123";
        GetMethod getMethod = new GetMethod(url);
        getMethod.addRequestHeader("apikey","73a0f06127384e84240a2921b3b780a4");
        client.executeMethod(getMethod);
        //得到返回的信息
        InputStreamReader input = new InputStreamReader(getMethod.getResponseBodyAsStream(), "utf-8");
        BufferedReader bufReader = new BufferedReader(input);
        String result = "";
        String line = "";
        StringBuilder contentBuf = new StringBuilder();
        while ((line = bufReader.readLine()) != null) {
            contentBuf.append(line);
        }
        //String result  = new String(getMethod.getResponseBodyAsString().getBytes("UTF-8"));
        result = contentBuf.toString();
        System.out.println(result);
		return result;
	}
}
