 package parseJsonData;

import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class TestClass3 {
	
	@Test(enabled=true)
	public void f1() {
		Map jsonResponseAsMap=RestAssured
		.get("https://run.mocky.io/v3/f0d92ffd-75ad-4379-a3cb-6171bbb5bd57")
		.as(Map.class);
		
		//fetch the parent value
		String firstName=(String) jsonResponseAsMap.get("first_name");
		System.out.println(firstName);
		
	}
	
	@Test(enabled=false)
	public void f2() {
		Map jsonResponseAsMap=RestAssured
		.get("https://run.mocky.io/v3/8afd9d41-9338-4c93-ac62-4d35e75c5eba")
		.as(Map.class);
		
		//fetch the parent value
		String firstName=(String) jsonResponseAsMap.get("firstName");
		System.out.println(firstName);
		
		//Read the value of child node
		Map<String, String> skillsMap=(Map<String, String>)jsonResponseAsMap.get("skills");
		System.out.println(skillsMap.get("name"));
		System.out.println(skillsMap.get("proficency"));
		
	}
	
	@Test(enabled=false)
	public void f3() {
		//Make generic type of Map Object
		Map<String, Object> jsonResponseAsMap=RestAssured
		.get("https://run.mocky.io/v3/df5fd4b7-d124-454b-840f-578bc9da1789")
		.as(new TypeRef<Map<String, Object>>(){});
		
		//fetch the parent value
		String firstName=(String) jsonResponseAsMap.get("firstName");
		System.out.println(firstName);
		
		//Read the value of child node
		Map<String, String> skillsMap=(Map<String, String>)jsonResponseAsMap.get("skills");
		System.out.println(skillsMap.get("name"));
		System.out.println(skillsMap.get("proficency"));
		
	}

}
