package restfulbooker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Video_21_DefaultValues2 {
	
	//Here we have not passed the baseURI, we have passed the baseURI in Video_21_DefaultValues1 class and called both the class in testng.xml file
	//Once we will call one class from once class baseURI reference will point to another class because baseURI is static import by default. 
	
	@Test(enabled=true,priority=1)
	public void postRequest() {
		RestAssured
		.given()
		.log()
		.all()
		.basePath("auth")
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}}")
		.post()
		.then()
		.log()
		.all()
		.statusCode(200);
	}

}
