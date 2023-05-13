package jsonpathexample;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Video_28_ReadJsonPath_Tricky_JSONArray_And_NestedJSONArray {
	
	@Test(enabled=true)
	public void f() {
		String jsonArr="[\r\n"
				+ "  {\r\n"
				+ "  \"firstname\": \"Amod\",\r\n"
				+ "  \"lastname\": \"Mahajn\",\r\n"
				+ "  \"age\": 28,\r\n"
				+ "  \"address\":[\r\n"
				+ "    {\r\n"
				+ "      \"City\":\"Delhi\",\r\n"
				+ "      \"Country\":\"India\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "       \"City\":\"Jaipur\",\r\n"
				+ "      \"Country\":\"India\"\r\n"
				+ "    }\r\n"
				+ "  ] \r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "  \"firstname\": \"Amod\",\r\n"
				+ "  \"lastname\": \"Mahajn\",\r\n"
				+ "  \"age\": 28,\r\n"
				+ "  \"address\":[\r\n"
				+ "    {\r\n"
				+ "      \"City\":\"Mumbai\",\r\n"
				+ "      \"Country\":\"India\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "       \"City\":\"Chennai\",\r\n"
				+ "      \"Country\":\"India\"\r\n"
				+ "    }\r\n"
				+ "  ] \r\n"
				+ "}\r\n"
				+ "]";
		
		JsonPath jsonPath=new JsonPath(jsonArr);
		System.out.println(jsonArr);
		
		String city1=jsonPath.get("[0].address[0].City");
		System.out.println(city1);
		
		String city2=jsonPath.get("[1].address[1].City");
		System.out.println(city2);
	
		//Will print the all city name from 0th element from the JSON Array
	    System.out.println(jsonPath.getList("[0].address.City"));
	   
	    //Will print all the city name from address
	    System.out.println(jsonPath.getList("address.City"));
	
		
	}
	
	
}
