package convertJSONObjectResponseToPOJO;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Video_60_CreateDynamicJSONPayloadUsingPOJO_RemoveNonDefaultValue {
	
	@Test
	public void f1() throws Exception {
		
		Video_60_Employee employee=new Video_60_Employee();
		
		employee.setId(1);
		employee.setFirst_name("Amod");
		employee.setLast_name("mahajn");
		//employee.setEmail("abc@mail.com");
		//employee.setGender("Male");
		
		ObjectMapper ojectMapper=new ObjectMapper();
		String empJsonFormat= ojectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		System.out.println(empJsonFormat);
		
		
	}

}

