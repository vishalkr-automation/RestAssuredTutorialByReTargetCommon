package convertJSONObjectResponseToPOJO;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_56_ConvertSimpleJSOnArrayResponseToPOJO {
	@Test
	public void f() {
	Student[] student=RestAssured.get("https://run.mocky.io/v3/d94018cd-c55f-4f61-9ad7-437242b69f2a")
			.as(Student[].class);
	
	System.out.println(student.length);
	System.out.println(student[0].getFirst_name());
	System.out.println(student[1].getFirst_name());
	
	}
}
