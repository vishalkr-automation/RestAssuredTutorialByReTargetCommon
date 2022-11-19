package pojoExample;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_49_CreateJSONArrayPayload_UsingPOJO {
	
	@Test
	public void f1() {
		Student s1=new Student();
		
		s1.setId(101);
		s1.setFirstName("Amod");
		s1.setLastName("Mahajan");
		s1.setGender("Male");
		s1.setEmail("amod1@gmail.com");
		
        Student s2=new Student();
		
        s2.setId(101);
        s2.setFirstName("Kamla");
        s2.setLastName("Mahajan");
        s2.setGender("Female");
        s2.setEmail("kamla@gmail.com");
		
		ArrayList<Student> jsonArrayStudent=new ArrayList<>();
		jsonArrayStudent.add(s1);
		jsonArrayStudent.add(s2);
		
		RestAssured
		.given()
		.log()
		.all()
		.body(jsonArrayStudent)      //pass the jsonArray
		.when()
		.post();
			
	}

}
