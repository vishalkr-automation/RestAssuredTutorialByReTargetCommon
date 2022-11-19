package payloadsexample;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_36_CreateSimpleJSON_Array {
	
	@Test(enabled=false)
	public void f() {
		Map<String, Object> ParentMap=new LinkedHashMap<>();
		
		ParentMap.put("id", 1);
		ParentMap.put("firstName", "Gray");
		ParentMap.put("lastName", "Ceyssen");
		ParentMap.put("email", "gceyssen0@pbs.org");
		ParentMap.put("gender", "Male");
		
		List<Map<String, Object>> allEmp=new ArrayList<>();
		allEmp.add(ParentMap);
		
		RestAssured
		.given()
		.log()
		.all()
		.body(allEmp)       //Here we have to call List instance
		.post();
		
	}
	
	@Test(enabled=true)
	public void f2() {
		Map<String, Object> ParentMap=new LinkedHashMap<>();
		
		ParentMap.put("id", 1);
		ParentMap.put("firstName", "Gray");
		ParentMap.put("lastName", "Ceyssen");
		ParentMap.put("email", "gceyssen0@pbs.org");
		ParentMap.put("gender", "Male");
		
       Map<String, Object> Map2=new LinkedHashMap<>();
		
       Map2.put("id", 2);
       Map2.put("firstName", "Maryjo");
       Map2.put("lastName", "Ceyssen");
       Map2.put("email", "moxtaby0@wikia.com");
       Map2.put("gender", "Female");
		
		List<Map<String, Object>> allEmp=new ArrayList<>();
		allEmp.add(ParentMap);
		allEmp.add(Map2);
		
		RestAssured
		.given()
		.log()
		.all()
		.body(allEmp)       //Here we have to call List instance
		.post();
		
	}

}
