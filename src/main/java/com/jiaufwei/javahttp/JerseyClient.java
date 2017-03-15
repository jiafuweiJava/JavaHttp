package com.jiaufwei.javahttp;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * 使用com.sun.jersey 调用http请求
 * @author jiafuwei
 *
 */
public class JerseyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//post();
		get();
	}

	public static void post(){
		Client cc = Client.create();
		WebResource rr = cc.resource("http://localhost:9090/api/smallball/memberOrderInfo!useMemberAccountPay.do");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("order_id", "12");  
		
		String ret = rr.queryParams(queryParams).post(String.class);
		System.out.println(ret);
	}
	
	public static void get(){
		Client cc = Client.create();
		WebResource rr = cc.resource("http://www.baidu.com");
		ClientResponse response = rr.get(ClientResponse.class);  
		String entity = response.getEntity(String.class); 
		System.out.println(entity);
		
	}
}
