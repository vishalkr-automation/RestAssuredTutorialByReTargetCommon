package restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Video_05_ExampleOf_POST_Request {

	public static void main(String[] args) {
		
		//Build Request
		RequestSpecification requestSpecification=RestAssured.given();
		
		//It will print the log of request details 
		requestSpecification=requestSpecification.log().all();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking");
		
		//under the body we just use the simple JSON Data here we can use this data in JSON file because it's accept the string data
		requestSpecification.body("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}");
		
         requestSpecification.contentType(ContentType.JSON);
         
         //Hit Request and Get Response
         Response response=requestSpecification.post();
         
         //Validate Response
        // ValidatableResponse validatableResponse=response.then().log().all();    //It will print the log details of request and response 
         ValidatableResponse validatableResponse=response.then();
         validatableResponse.statusCode(200);
         
	}
	
}
