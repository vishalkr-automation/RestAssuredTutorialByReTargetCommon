package restfulbooker;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Video_19_RequestAndResponse_Specification_Togther {
	
	@Test(description="Method- 1", enabled=false)
	public void postMethod() {
		
		RequestSpecification requestSpecification=RestAssured.given(); 
		requestSpecification
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking")
		.contentType(ContentType.JSON)
		.body("{\r\n" + "    \"firstname\" : \"Jim\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
					  + "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
					  + "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
					  + "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
					  + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
		.contentType(ContentType.JSON);
		
		 ResponseSpecification responseSpecification=RestAssured.expect();
		 responseSpecification.statusCode(200);
		 responseSpecification.contentType(ContentType.JSON);
		 responseSpecification.time(Matchers.lessThan(5000L));	
		 
		  RestAssured
		 .given()
		 .spec(requestSpecification)
		 .post()
		 .then()
		 .log()
		 .all()
		 .spec(responseSpecification);
		
	}
	
	@Test(description="Method- 2", enabled=true)
	public void postMethod2() {
		
		RequestSpecification requestSpecification=RestAssured.given(); 
		requestSpecification
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking")
		.contentType(ContentType.JSON)
		.body("{\r\n" + "    \"firstname\" : \"Jim\",\r\n" + "    \"lastname\" : \"Brown\",\r\n"
					  + "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
					  + "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
					  + "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
					  + "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
		.contentType(ContentType.JSON);
		
		 ResponseSpecification responseSpecification=RestAssured.expect();
		 responseSpecification.statusCode(200);
		 responseSpecification.contentType(ContentType.JSON);
		 responseSpecification.time(Matchers.lessThan(5000L));	
		 
		  RestAssured
		 .given(requestSpecification, responseSpecification)      //We can add request and response specification together
		 .post()
		 .then()
		 .log()
		 .all();
		
	}

}
