package datashare;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Video_46_SharingData_Using_TestNgITextContext_GetBokingID {
	
	@Test
	public static void getRequestInOneLine(ITestContext context) {
		
						RestAssured.given()
                           .log()
                           .all()
                           .get("https://restful-booker.herokuapp.com/booking/"+context.getSuite().getAttribute("bookingId"))
                           .then()
                           .log()
                           .all()
                           .extract()
                           .response();
	}

}
