package convertJSONObjectResponseToPOJO;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Video_59_ConvertJsonObjectToDynamicPayloadWithoutPOJOUsingJackson {
	
	@Test(enabled=true)
	public void f1() throws IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		Map<String, Object> address=objectMapper.readValue(new File(System.getProperty("user.dir")+".\\TestData\\address.json"), 
			new TypeReference<Map<String, Object>>(){});
		
		System.out.println(address.get("city"));
		
		address.put("city", "Delhi");   //It will update the existing value from JSON File at run time
		address.put("pin", 123);        //It will add new data 
		address.remove("houseNo");      //It will remove the data
		
		
		//It will print the changed value in JSON preety Format 
		String updatedJson1=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
		System.out.println(updatedJson1);
		
	}

}
