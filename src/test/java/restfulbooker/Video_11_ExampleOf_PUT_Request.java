package restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Video_11_ExampleOf_PUT_Request {

	public static void main(String[] args) {
		
		//Build Request
		                 RestAssured
				         .given()
				         .log()
				         .all()
				         .baseUri("https://restful-booker.herokuapp.com/")
				         .basePath("booking/11")
				         .header("Content-Type", "application/json")
				         .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
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
				         .put()
				         .then()
				         .log()
				         .all().statusCode(200);
				         
         
	}
	
}
