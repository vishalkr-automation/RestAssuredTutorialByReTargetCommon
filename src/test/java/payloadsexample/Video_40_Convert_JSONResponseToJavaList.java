package payloadsexample;

import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class Video_40_Convert_JSONResponseToJavaList {
	
	@Test(enabled=false)
	public void f1() {
		List allEmp=RestAssured
		.get("https://run.mocky.io/v3/d94018cd-c55f-4f61-9ad7-437242b69f2a")
		.as(List.class);
		
		System.out.println(allEmp.size());
		
		//fetch the parent value
		@SuppressWarnings("unchecked")
		Map<String, Object> emp1=(Map<String, Object>) allEmp.get(0);
		System.out.println(emp1.get("first_name"));
		
	}
	
	@Test(enabled=false)
	public void f2() {
		List<Map<String, Object>> jsonResponseAsMap=RestAssured
				.get("https://run.mocky.io/v3/d94018cd-c55f-4f61-9ad7-437242b69f2a")
				.as(new TypeRef<List<Map<String, Object>>>(){});
				
				//fetch the parent value
				Map<String, Object> emp1=(Map<String, Object>) jsonResponseAsMap.get(0);
				System.out.println(emp1.get("first_name"));
		
	}
	
	@Test(enabled=true)
	public void f3() {
		//Make generic type of List Object
		List<Map<String, Object>> jsonResponseAsMap=RestAssured
		.get("https://run.mocky.io/v3/0e5e0f68-622c-4ba0-9c49-1c3f1c4b1d51")    //2 Nested object data URL
		//.get("https://run.mocky.io/v3/111d80fd-882c-4355-bcf3-bfb148a452f2")   - Single Object nested data URL 
		.as(new TypeRef<List<Map<String, Object>>>(){});
		
		//fetch the parent value
		Map<String, Object> emp1=(Map<String, Object>) jsonResponseAsMap.get(1);
		System.out.println(emp1);
		
		//Read the value of child node
		//System.out.println(emp1.get("skills"));
		
		@SuppressWarnings("unchecked")
		Map<Object, Object> map2=(Map<Object, Object>)emp1.get("skills");
		System.out.println(map2.get("name"));
		
		
	}

}
