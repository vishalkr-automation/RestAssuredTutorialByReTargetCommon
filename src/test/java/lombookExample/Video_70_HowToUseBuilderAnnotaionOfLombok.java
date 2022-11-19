package lombookExample;

import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//For use of lombok concept we have to add the lombok in maven dependency and Eclipse editor
//Here in this concept we do not have to use as getter and setter method

public class Video_70_HowToUseBuilderAnnotaionOfLombok {

	@Test
	public void f() throws JsonProcessingException {
		Video_70_Employee employee=Video_70_Employee.builder()
		          .id(1)
		         .firstName("Amod")
		         .lastName("Mahajan")
		         .email("builderEaxmple@gmail.com")
		         .build();
		
		ObjectMapper objectMapper=new ObjectMapper();
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee));
		
		//We can change the value of JSON Object
		
		Video_70_Employee employee1=
		Video_70_Employee
		.builder()
		.firstName("Kamlesh")
        .lastName("Sinha")
        .id(1)
        .email("builderEaxmple@gmail.com")
        .build();
		
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee1));
}
}