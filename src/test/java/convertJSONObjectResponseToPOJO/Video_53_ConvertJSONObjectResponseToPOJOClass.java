package convertJSONObjectResponseToPOJO;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_53_ConvertJSONObjectResponseToPOJOClass {

	@Test
	public void f1() {
		Employee employee=
				RestAssured.get("https://run.mocky.io/v3/f0d92ffd-75ad-4379-a3cb-6171bbb5bd57")	
				.as(Employee.class);	
		
		int id=employee.getId();
		System.out.println(id);
	}
}
