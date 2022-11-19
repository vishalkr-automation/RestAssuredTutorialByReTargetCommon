package restfulbooker;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Video_17_RequestSpecificationInRestAssured {
	RequestSpecification requestSpecification;

	@BeforeClass
	public void beforeClass() {
		
		 requestSpecification=RestAssured.given();
		
		//It will print the log of request details 
		requestSpecification=requestSpecification.log().all();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		
	}
	
	@Test(enabled=true,priority=1)
	public void postRequest() {
		RestAssured
		.given()
		.spec(requestSpecification)
		.basePath("booking")
		.contentType(ContentType.JSON)
		.body("{\r\n" + "    \"firstname\" : \"Jim\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
					  + "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
					  + "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
					  + "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
					  + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
		.post()
		.then()
		.log()
		.all()
		.statusCode(200);

	}
	
	@Test(enabled=true,priority=2)
	public void postRequest2() {
		  RestAssured
             .given()
             .spec(requestSpecification)
	         .basePath("booking")
	         .header("Content-Type", "application/json")
	         .body("{\r\n"
	+ "    \"firstname\" : \"Suresh\",\r\n"
	+ "    \"lastname\" : \"Reddy\",\r\n"
	+ "    \"totalprice\" : 111,\r\n"
	+ "    \"depositpaid\" : true,\r\n"
	+ "    \"bookingdates\" : {\r\n"
	+ "        \"checkin\" : \"2018-01-01\",\r\n"
	+ "        \"checkout\" : \"2019-01-01\"\r\n"
	+ "    },\r\n"
	+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
	+ "}")
	         .when()
	         .post()
	         .then()
	         .log()
	         .all().statusCode(200);
		
	}
}
