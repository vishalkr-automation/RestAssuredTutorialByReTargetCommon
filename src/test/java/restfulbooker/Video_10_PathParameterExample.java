package restfulbooker;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_10_PathParameterExample {


	@Test(enabled=false)
	public void getRequestInOneLine() {
		//Build Request
				RestAssured.given()
                           .log()
                           .all()
                           .baseUri("https://restful-booker.herokuapp.com/")
                           .basePath("{basePath}/{bookingId}")
                           .pathParam("basePath","booking")
                           .pathParam("bookingId",10)
                           .get()
                           .then()
                           .log()
                           .all()
                           .statusCode(200);		         
	}
	
	@Test(enabled=false)
	public void getRequestInLine() {
		//Build Request
				RestAssured.given()
                           .log()
                           .all()
                           .get("https://restful-booker.herokuapp.com/booking/10")
                           .then()
                           .log()
                           .all()
                           .statusCode(200);		         
	}
	
	@Test(enabled=true)
	public void getRequestUsingMap() {
		Map<String, Object> map=new HashMap<>();
		map.put("basePath", "booking");
		map.put("bookingId", 10);
		
		//Build Request
				RestAssured.given()
                           .log()
                           .all()
                           .baseUri("https://restful-booker.herokuapp.com/")
                           .basePath("{basePath}/{bookingId}")
                           //.pathParam("basePath","booking")
                           //.pathParam("bookingId",10)
                           .pathParams(map)
                           .get()
                           .then()
                           .log()
                           .all()
                           .statusCode(200);		         
	}
	
}
