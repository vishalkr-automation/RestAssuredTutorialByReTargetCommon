package convertJSONObjectResponseToPOJO;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_54_NestedJSONObjectResponseToPOJO {

	@Test
	public void f1() {
		EmployeeWithAddress employee=
				RestAssured.get("https://run.mocky.io/v3/3da70133-f232-4ef9-a526-ace420dfb3af")	
				.as(EmployeeWithAddress.class);	
		
		int id=employee.getId();
		System.out.println(id);
		
		String empFirstName=employee.getFirstName();
		System.out.println(empFirstName);
		
		Address address=employee.getAddress();   //Calling data from address fields
		System.out.println(address.getHouseNo());
		
		System.out.println(employee.getAddress().getCity()); //Calling data from address fields
	}
}
