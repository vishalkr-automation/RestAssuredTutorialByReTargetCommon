package jsonpathexample;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Video_26_ReadSimpleAndNested_JSONPath {
	
	@Test(enabled=false)
	public void f() {
		String json="{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		JsonPath jsonPath=new JsonPath(json);
		
		String userName=jsonPath.getString("username");
		System.out.println(userName);
		
		//We can return any object value
		Object password=jsonPath.getString("username");
		System.out.println(password);
		
	}
	
	@Test
	public void f1() {
		String json="{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		
		JsonPath jsonPath=new JsonPath(json);
		
	    System.out.println(jsonPath.getString("$"));
	    //System.out.println(jsonPath.get("$"));
	    //System.out.println(jsonPath.get());
	    System.out.println(jsonPath.getString(""));
		
	}

}
