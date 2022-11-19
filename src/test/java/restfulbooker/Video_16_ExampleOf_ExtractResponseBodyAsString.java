package restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Video_16_ExampleOf_ExtractResponseBodyAsString {

	public static void main(String[] args) {
		//getRequestUsingGenericMethod();
		getRequestInOneLine();
         
	}
	
	public static void getRequestUsingGenericMethod() {
		//Build Request
				RequestSpecification requestSpecification=RestAssured.given();
				
				//It will print the log of request details 
				requestSpecification=requestSpecification.log().all();
				requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
				requestSpecification.basePath("booking/{id}");
				requestSpecification.pathParam("id",10);
		         
		         //Hit Request and Get Response
		         Response response=requestSpecification.get();
		         
		         //Validate Response
		         ValidatableResponse validatableResponse=response.then().log().all();    //It will print the log details of request and response 
		         //ValidatableResponse validatableResponse=response.then();
		         validatableResponse.statusCode(200);
	}
	
	public static void getRequestInOneLine() {
		//Build Request
				String responseBody=RestAssured.given()
                           .baseUri("https://restful-booker.herokuapp.com/")
                           .basePath("booking/{id}")
                           .pathParam("id",10)
                           .get()                 //HTTP Request Method
                           .then()
                           .extract()
                          // .body()             //By default body can print as response
                           //.asString();       //Method 1
                           .asPrettyString();   //Method 2 (Proper Format)
				System.out.println(responseBody);
                           		         
	}
	
}
