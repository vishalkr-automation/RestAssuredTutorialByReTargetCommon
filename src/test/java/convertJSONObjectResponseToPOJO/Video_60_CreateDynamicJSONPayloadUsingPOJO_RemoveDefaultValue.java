package convertJSONObjectResponseToPOJO;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Video_60_CreateDynamicJSONPayloadUsingPOJO_RemoveDefaultValue {
	
	@Test
	public void f1() throws Exception {
		
		Video_61_Employee employee=new Video_61_Employee();
		
		employee.setId(0);               //will remove because it is default value
		employee.setFirst_name("Amod");
		employee.setLast_name("mahajn");
		employee.setEmail("abc@mail.com");
		employee.setGender("Male");
		employee.setMarried(false);      //will remove because it is default value
		
		ObjectMapper ojectMapper=new ObjectMapper();
		String empJsonFormat= ojectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		System.out.println(empJsonFormat);
		
		
	}

}

