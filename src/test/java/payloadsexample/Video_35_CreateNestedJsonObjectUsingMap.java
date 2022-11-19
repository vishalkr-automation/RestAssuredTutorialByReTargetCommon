package payloadsexample;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_35_CreateNestedJsonObjectUsingMap {
	
	@Test
	public void f() {
		Map<String, Object> ParentMap=new LinkedHashMap<>();
		
		ParentMap.put("id", 1);
		ParentMap.put("firstName", "Amod");
		ParentMap.put("lastName", "Mahajan");
		ParentMap.put("salary", 10.5);
		ParentMap.put("married", false);
		
		Map<String, Object> AddressMap=new LinkedHashMap<>();
		
		AddressMap.put("no", "#81");
		AddressMap.put("StreetName", "JS Nagar");
		AddressMap.put("City", "BLR");
		AddressMap.put("State", "KA");
		
		ParentMap.put("Address", AddressMap);
		
		RestAssured
		.given()
		.log()
		.all()
		.body(ParentMap)
		.post();
		
	}

}
