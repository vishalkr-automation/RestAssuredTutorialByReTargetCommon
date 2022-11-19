package payloadsexample;

import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Video_41_HandlingDynamicJSONResponse {
	
	@Test(enabled=false)
	public void f() {
		 //We have called ArrayObject Type of API Request
		Response response=RestAssured.get("https://run.mocky.io/v3/d94018cd-c55f-4f61-9ad7-437242b69f2a");   
		Map responseMap=response.as(Map.class);
		System.out.println(responseMap);
		
		//Note - It will throw error if we directly call the ArrayObject value 
		//Cannot deserialize instance of `java.util.LinkedHashMap<java.lang.Object,java.lang.Object>` out of START_ARRAY token
	}
	
	@Test(enabled=false)
	public void f1() {
		Response response=RestAssured.get("https://run.mocky.io/v3/f0d92ffd-75ad-4379-a3cb-6171bbb5bd57");
		List responseList=response.as(List.class);
		System.err.println(responseList);
		
		//Note - It will throw error if we directly call the ArrayObject value 
		//Cannot deserialize instance of `java.util.ArrayList<java.lang.Object>` out of START_OBJECT token
	}
	
	//Solution of above issue
	
	@Test
	public void f2() {
		//Response response=RestAssured.get("https://run.mocky.io/v3/d94018cd-c55f-4f61-9ad7-437242b69f2a");
		Response response=RestAssured.get("https://run.mocky.io/v3/f0d92ffd-75ad-4379-a3cb-6171bbb5bd57");
		Object responseObject=response.as(Object.class);
		
		if(responseObject instanceof List) {
			List responseAsList =(List)responseObject;
			System.out.println(responseAsList.size());
		}
		else if(responseObject instanceof Map) {
			Map responseAsMap=(Map)responseObject;
			System.out.println(((Map)responseAsMap).keySet());
		}
	}

}
