package restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Video_14_ExampleOf_Delete_Request {

	public static void main(String[] args) {
		
		//Build Request
		                 RestAssured
				         .given()
				         .log()
				         .all()
				         .baseUri("https://restful-booker.herokuapp.com/")
				         .basePath("booking/101")
				         .header("Content-Type", "application/json")
				         .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
				         .when()
				         .delete()
				         .then()
				         .log()
				         .all()
				         .statusCode(201);
				         
         
	}
	
}
