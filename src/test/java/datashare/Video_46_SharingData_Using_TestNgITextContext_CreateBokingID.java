package datashare;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Video_46_SharingData_Using_TestNgITextContext_CreateBokingID {
	
	@Test
	public void f1(ITestContext context) {
		
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
		context.getSuite().setAttribute("bookingId", id);

	}

}
