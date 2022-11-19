package convertJSONObjectResponseToPOJO;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Video_63_HowToUseJSONIncludeAtPropertyLevelToCreateDynamicPayload {
	
	@Test
	public void f1() throws Exception {
		
		Video_63_Employee employee=new Video_63_Employee();
		
		employee.setId(0);
		employee.setFirst_name("Amod");
		employee.setLast_name("mahajn");
		employee.setEmail("abc@mail.com");
		employee.setGender("Male");
		employee.setMarried(false);
		employee.setSkillSet(new ArrayList<>());             //Empty - So it will remove the value
		employee.setFamilyMembers(new HashMap<String, Object>());  //Empty - So it will remove the value
		
		ObjectMapper ojectMapper=new ObjectMapper();
		String empJsonFormat= ojectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		System.out.println(empJsonFormat);
		
		
	}

}
