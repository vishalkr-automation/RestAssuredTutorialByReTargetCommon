package convertJSONObjectResponseToPOJO;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Video_58_ConvertJsonToPOJOClassToHandleDynamicPayloadUsingJackson {
	
	@Test(enabled=false)
	public void f() throws IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		Address address=objectMapper.readValue(new File(System.getProperty("user.dir")+".\\TestData\\address.json"), Address.class);
		
		System.out.println(address.getCity());
		address.setCity("Delhi");
		System.out.println(address.getCity());
		
	}
	
	//Reference of this example we have taken from Video 59 
	@Test(enabled=true)
	public void f1() throws IOException {
		ObjectMapper objectMapper=new ObjectMapper();
		Address address=objectMapper.readValue(new File(System.getProperty("user.dir")+".\\TestData\\address.json"), Address.class);
		
		System.out.println(address.getCity());
		address.setCity("Delhi");
		
		//It will print the changed value in JSON Format
		String updatedJson1=objectMapper.writeValueAsString(address);
		System.out.println(updatedJson1);
		
		//It will print the changed value in JSON preety Format 
		updatedJson1=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
		System.out.println(updatedJson1);
		
	}

}
