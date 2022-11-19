package restfulbooker;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Video_21_DefaultValues1 {


	@BeforeTest
	public void beforeClass() {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com/";
		RestAssured.basePath="booking";
		System.out.println("In Setup");
		
		//We can add the requestSpecification and responseSpecification without create the object
		RestAssured.requestSpecification=RestAssured.given().log().all();
		RestAssured.responseSpecification=RestAssured.expect().statusCode(200);
	}
	
	@Test(enabled=true,priority=1)
	public void postRequest() {
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body("{\r\n" + "    \"firstname\" : \"Jim\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
					  + "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
					  + "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
					  + "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
					  + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
		.post()
		.then()
		.log()
		.all();

	}
}
