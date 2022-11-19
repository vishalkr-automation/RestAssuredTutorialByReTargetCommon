package pojoExample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_48_CreateJSONObjectPayload_UsingPOJO {
	
	@Test
	public void f1() {
		Student s1=new Student();
		
		s1.setId(101);
		s1.setFirstName("Amod");
		s1.setLastName("Mahajan");
		s1.setGender("Male");
		s1.setEmail("amod1@gmail.com");
		
		RestAssured
		.given()
		.log()
		.all()
		.body(s1)
		.when()
		.post();
			
	}

}
