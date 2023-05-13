package convertJSONObjectResponseToPOJO;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Video_65_HowToExtractValueFromDynamicJSONResponseUsingPOJOClass_JSONIgnoreProperties {
	
	//Here for skills attribute value we did not create the getter and setter methods in Video_65_Employee
	//So using @JsonIgnoreProperties(ignoreUnknown = true) we will not get any error
	@Test
	public void f1() throws Exception {
		
	String jsonString="{\r\n"
			+ "  \"id\": 1,\r\n"
			+ "  \"first_name\": \"Maryjo\",\r\n"
			+ "  \"last_name\": \"Oxtaby\",\r\n"
			+ "  \"email\": \"moxtaby0@wikia.com\",\r\n"
			+ "  \"gender\": \"Female\",\r\n"
			+ "  \"married\": true,\r\n"
			+ "  \"skills\": \"Java\"\r\n"
			+ "}";
	
		ObjectMapper objectMapper=new ObjectMapper();
		Video_65_Employee empObj=objectMapper.readValue(jsonString, Video_65_Employee.class);
		System.out.println();
		System.out.println(empObj.getFirst_name());
		System.out.println(empObj.getLast_name());
		System.out.println(empObj.getId());
		System.out.println(empObj.getGender());
		System.out.println(empObj.getEmail());
		System.out.println(empObj.isMarried());
		
	}

}
