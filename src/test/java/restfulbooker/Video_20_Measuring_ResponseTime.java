package restfulbooker;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Video_20_Measuring_ResponseTime {
	
	@Test
	public void postMethod() {
		Response response=  RestAssured
	         .given()
	         .log()
	         .all()
	         .baseUri("https://restful-booker.herokuapp.com/")
	         .basePath("booking")
	         .body("{\r\n"
	+ "    \"firstname\" : \"Jim\",\r\n"
	+ "    \"lastname\" : \"Brown\",\r\n"
	+ "    \"totalprice\" : 111,\r\n"
	+ "    \"depositpaid\" : true,\r\n"
	+ "    \"bookingdates\" : {\r\n"
	+ "        \"checkin\" : \"2018-01-01\",\r\n"
	+ "        \"checkout\" : \"2019-01-01\"\r\n"
	+ "    },\r\n"
	+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
	+ "}")
	         .contentType(ContentType.JSON)
	         .post();

		// Method 1
		long responseTimeInMS = response.time();
		System.out.println("Response Time in miliSeconds: " + responseTimeInMS);

		// Method 2
		long responseTimeInSec = response.timeIn(TimeUnit.SECONDS);
		System.out.println("Response Time in seconds: " + responseTimeInSec);

		// Method 3
		long responseTimeInMS1 = response.getTime();
		System.out.println("Response Time in miliSeconds: " + responseTimeInMS1);

		// Method 4
		long responseTimeInSec1 = response.getTimeIn(TimeUnit.SECONDS);
		System.out.println("Response Time in seconds: " + responseTimeInSec1);
		
		//Assertions of Time method
		
		response.then().time(Matchers.lessThan(5000L));
		
		response.then().time(Matchers.greaterThan(2000L));
		
		response.then().time(Matchers.both(Matchers.greaterThan(2000L)).and(Matchers.lessThan(5000L)));	
		
		response.then().time(Matchers.lessThan(5l), TimeUnit.SECONDS);
					
	}

}
