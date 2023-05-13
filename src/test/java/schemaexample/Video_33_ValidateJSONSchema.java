package schemaexample;

import java.io.File;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Video_33_ValidateJSONSchema {

	//Verify JSON Schema after response code
	@Test(enabled=false)
	public void f1() {
		
		//Build Request
		                 RestAssured
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
				         .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingResponseSchema.json"));
				           
	}
	
	@Test(enabled=false)
	public void f2() {
		
		//Build Request
		                 RestAssured
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
				         .body(JsonSchemaValidator.matchesJsonSchema(new File(".\\TestData\\CreateBookingResponseSchema.json")));
				           
	}
	
	@Test(enabled=true)
	public void f3() {
		
		//Build Request
		                String json="{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		                
				        MatcherAssert.assertThat(
				        json, JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingResponseSchema2.json"));
				           
	}
}
