package nestedPojoExample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_50_CreateNestedJSONObjectPayload_UsingPOJO {
	
	@Test
	public void f1() {
		Student s1=new Student();
		
		s1.setId(101);
		s1.setFirstName("Amod");
		s1.setLastName("Mahajan");
		s1.setGender("Male");
		s1.setEmail("amod1@gmail.com");
		
		Address a1=new Address();
		a1.setHouseNo("1011");
		a1.setCity("Chennai");
		a1.setState("TN");
		a1.setCountry("IN");
		
		s1.setAddress(a1);
		
		RestAssured
		.given()
		.log()
		.all()
		.body(s1)
		.when()
		.post();
			
	}

}
