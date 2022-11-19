package datashare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Video_43_ParallelTestNgRun_UsingMap2 {
	
	@Test
	public void f1() {
		
		int id=  RestAssured
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
	         .post()
	         .then()
	         .log()
	         .all()
	         .statusCode(200)
	         .extract()
	         .jsonPath()
	         .getInt("bookingid");
		ThreadLocalDataStoreAsMap.setValue(Constants.BOOKING_ID, id);

	}
	
	@Test
	public static void getRequestInOneLine() {
		int bookingId=(Integer) ThreadLocalDataStoreAsMap.getValue(Constants.BOOKING_ID);
				Response response = 
						RestAssured.given()
                           .log()
                           .all()
                           .get("https://restful-booker.herokuapp.com/booking/"+bookingId)
                           .then()
                           .log()
                           .all()
                           .extract()
                           .response();
	}

}
