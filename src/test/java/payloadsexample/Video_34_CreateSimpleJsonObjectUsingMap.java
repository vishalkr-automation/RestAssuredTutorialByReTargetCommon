package payloadsexample;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_34_CreateSimpleJsonObjectUsingMap {
	
	@Test
	public void f() {
		Map<String, Object> map=new LinkedHashMap<>();
		
		map.put("id", 1);
		map.put("firstName", "Amod");
		map.put("lastName", "Mahajan");
		map.put("salary", 10.5);
		map.put("married", false);
		
		RestAssured
		.given()
		.log()
		.all()
		.body(map)
		.post();
		
	}

}
