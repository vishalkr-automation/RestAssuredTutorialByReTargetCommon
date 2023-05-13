package jsonpathexample;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Video_29_ReadJsonPath_FromSimpleAndNestedJSONArray {
	
	@Test(enabled=false)
	public void f() {
		String jsonArr="[\r\n"
				+ "  \"10\",\r\n"
				+ "  \"20\",\r\n"
				+ "  \"30\",\r\n"
				+ "  \"40\"\r\n"
				+ "]";
		System.out.println(jsonArr);
		JsonPath jsonPath=new JsonPath(jsonArr);
		//System.out.println(jsonPath.get("[0]"));
		System.out.println(jsonPath.getList("$").size());
	
		
	}
	
	@Test(enabled=true)
	public void f1() {
		String jsonArr="[\r\n"
				+ "  [\r\n"
				+ "  \"10\",\r\n"
				+ "  \"20\",\r\n"
				+ "  \"30\",\r\n"
				+ "  \"40\"\r\n"
				+ "  ],\r\n"
				+ "  [\r\n"
				+ "  \"100\",\r\n"
				+ "  \"200\",\r\n"
				+ "  \"300\",\r\n"
				+ "  \"400\"\r\n"
				+ "  ]\r\n"
				+ "  \r\n"
				+ "]";
		
		System.out.println(jsonArr);
		
		JsonPath jsonPath=new JsonPath(jsonArr);
		//System.out.println(jsonPath.get("[1][2]"));
		
		//Class to use convert String data to JSON Array
		JSONArray jsonArray =new JSONArray(jsonArr);
		System.out.println(jsonArray);             
		
		//Class to use convert String data to JSON Object
		//JSONObject jsonObject=jsonArray.getJSONObject(0);
		//System.out.println(jsonObject.toString());
		
		//This method we can reterive the size of internal array
		List<Object> list=((List<Object>) jsonPath.getList("$").get(0));
		System.out.println(list.size());
		
		List<Object> list2=((List<Object>) jsonPath.getList("$").get(1));
		System.out.println(list2.size());
		
	}
	
	
}
