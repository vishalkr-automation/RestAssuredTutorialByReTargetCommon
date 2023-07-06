package parseJsonData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import io.restassured.path.json.JsonPath;

public class TestClass2{
	
	
	@Test(enabled=false)
	public void f1() throws Exception, IOException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        JsonNode jsonNode = objectMapper.readValue(new File(System.getProperty("user.dir")+".\\TestData2\\TestData1.json"), JsonNode.class);
        String prettyJson = objectMapper.writeValueAsString(jsonNode);
        System.out.println(prettyJson);
		
	}
	
	@Test(enabled=true)
	public void f() throws Exception, IOException, IOException {
		
		String filePath=System.getProperty("user.dir")+".\\TestData2\\TestData1.json";
		File file=new File(filePath);
		
		JsonPath jsonPath=new JsonPath(file);
		String data=jsonPath.getString("results");   //it will print the all the data from Json file
		System.out.println(data);
		
		String address_components=jsonPath.getString("results.address_components.long_name");
		System.out.println(address_components);
		
		String address_componentsFirstCity=jsonPath.getString("results.address_components.long_name[0][0]");
		System.out.println(address_componentsFirstCity);
		
		String address_componentsTypes=jsonPath.getString("results.address_components.types[0][0]");
		System.out.println(address_componentsTypes);
		
		String address_componentsTypesValue1=jsonPath.getString("results.address_components.types[0][0][0]");
		System.out.println(address_componentsTypesValue1);
		
		String address_componentsTypesValue2=jsonPath.getString("results.address_components.types[0][0][1]");
		System.out.println(address_componentsTypesValue2);
		
	}
	
	@Test(enabled=false)
	public void f3() throws Exception, IOException, IOException {
		
		//Reference of this example - https://www.youtube.com/watch?v=h5VLKYOQOjM
		//https://jsoneditoronline.org/classic/index.html#left=local.hoqudi&right=local.pixequ
		
		String filePath=System.getProperty("user.dir")+".\\TestData2\\TestData1.json";
		File file=new File(filePath);
		
		ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        JsonNode jsonNode = objectMapper.readValue(file, JsonNode.class);
        String prettyJson = objectMapper.writeValueAsString(jsonNode);
        System.out.println(prettyJson);
		
	    JSONObject jsonobject1=new JSONObject(prettyJson);
        System.out.println(jsonobject1);
        
        JSONArray jsonArray1=jsonobject1.getJSONArray("results");
        System.out.println(jsonArray1);
        
        JSONObject js1=jsonArray1.getJSONObject(0);
        System.out.println(js1);
       
        //Address Components
        JSONArray jsonArray2=js1.getJSONArray("address_components");
        System.out.println(jsonArray2);
        
        JSONObject jsonObj2=jsonArray2.getJSONObject(0);
        System.out.println(jsonObj2);
        
        JSONArray jsonArray3=jsonObj2.getJSONArray("types");
        System.out.println(jsonArray3);
        
        System.out.println(jsonArray3.get(0));  //it will print first array value in types array
        
        String str=jsonObj2.getString("short_name");
        System.out.println(str);
        
        //Formatted Address
        String str2=js1.getString("formatted_address");
        System.out.println(str2);
        
      //Formatted Address
        String str3=js1.getString("place_id");
        System.out.println(str3);
        
	}

}
