package convertJSONObjectResponseToPOJO;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Video_64_HowToUseJSONIncludeAtPropertyLevelToCreateDynamicPayload2 {
	
	@Test
	public void f1() throws Exception {
		
		Video_64_EmployeeSkills employee=new Video_64_EmployeeSkills();
		
		employee.setId(0);
		employee.setFirst_name("Amod");
		employee.setLast_name("mahajn");
		employee.setEmail("abc@mail.com");
		employee.setGender("Male");
		employee.setMarried(false);
		employee.setSkillSet(new ArrayList<>());             //Empty - So it will remove the value
		employee.setFamilyMembers(new HashMap<String, Object>());  //Empty - So it will remove the value
		employee.setSkills("Java");
			
		ObjectMapper ojectMapper=new ObjectMapper();
		String empJsonFormat= ojectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		System.out.println(empJsonFormat);
		
		
	}

}
