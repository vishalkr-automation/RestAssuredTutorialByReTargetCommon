package nestedPojoExample;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_51_CreateNestedJSONArrayPayload_UsingPOJO {
	
	@Test
	public void f1() {
		Employee e1=new Employee();
		
		e1.setId(101);
		e1.setFirstName("Amod");
		e1.setLastName("Mahajan");
		e1.setGender("Male");
		e1.setEmail("amod1@gmail.com");
		
		Address a1=new Address();
		a1.setHouseNo("1011");
		a1.setStreet("GB");
		a1.setCity("Chennai");
		a1.setState("TN");
		a1.setCountry("IN");
		
		Address a2=new Address();
		a2.setHouseNo("1021");
		a1.setStreet("RB");
		a2.setCity("Jaipur");
		a2.setState("RJ");
		a2.setCountry("IN");
		
		List<Address> alldress=new ArrayList<>();
		alldress.add(a1);
		alldress.add(a2);
		
		e1.setAddress(alldress);
		
		RestAssured
		.given()
		.log()
		.all()
		.body(e1)
		.when()
		.post();
			
	}

}
