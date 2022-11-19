package restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Video_13_ExampleOf_PATCH_Request {

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
				         		+ "    \"firstname\" : \"Merra\",\r\n"
				         		+ "    \"lastname\" : \"Brown\"\r\n"
				         		+ "}")
				         .when()
				         .patch()
				         .then()
				         .log()
				         .all()
				         .assertThat()
				         .statusCode(200);
				         
         
	}
	
}
