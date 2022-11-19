package restfulbooker;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class Video_18_ResponseSpecification {
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void beforeClass() {
		 responseSpecification=RestAssured.expect();
		 responseSpecification.statusCode(200);
		 responseSpecification.contentType(ContentType.JSON);
		 responseSpecification.time(Matchers.lessThan(5000L));	

	}
	
	@Test
	public void postMethod1() {
		
		  RestAssured
	         .given()
	         .log()
	         .all()
	         .baseUri("https://restful-booker.herokuapp.com/")
	         .basePath("booking")
	         .body("{\r\n"
	+ "    \"firstname\" : \"Raju\",\r\n"
	+ "    \"lastname\" : \"Kumar\",\r\n"
	+ "    \"totalprice\" : 111,\r\n"
	+ "    \"depositpaid\" : true,\r\n"
	+ "    \"bookingdates\" : {\r\n"
	+ "        \"checkin\" : \"2018-01-01\",\r\n"
	+ "        \"checkout\" : \"2019-01-01\"\r\n"
	+ "    },\r\n"
	+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
	+ "}")
	         .contentType(ContentType.JSON)     //Will send the JSON Content Type
	         .post()
	         .then()
	         .log()
	         .all()
	         .spec(responseSpecification)
	         .contentType(ContentType.JSON);   //Will Validate JSON Content Type
	}
	
	@Test
	public void postMethod2() {
		  RestAssured
	         .given()
	         .log()
	         .all()
	         .baseUri("https://restful-booker.herokuapp.com/")
	         .basePath("booking")
	         .body("{\r\n"
	+ "    \"firstname\" : \"Radha\",\r\n"
	+ "    \"lastname\" : \"kumari\",\r\n"
	+ "    \"totalprice\" : 111,\r\n"
	+ "    \"depositpaid\" : true,\r\n"
	+ "    \"bookingdates\" : {\r\n"
	+ "        \"checkin\" : \"2018-01-01\",\r\n"
	+ "        \"checkout\" : \"2019-01-01\"\r\n"
	+ "    },\r\n"
	+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
	+ "}")
	         .contentType(ContentType.JSON)     //Will send the JSON Content Type
	         .post()
	         .then()
	         .log()
	         .all()
	         .spec(responseSpecification)
	         .contentType(ContentType.JSON);   //Will Validate JSON Content Type
		
		
	}

}
