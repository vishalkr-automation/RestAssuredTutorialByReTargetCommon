package jsonpathexample;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Video_31_InLineAssertionUsingJSONPath {
	
	@Test(enabled=false)
	public void f1() {
		String jsonResponse="";
		jsonResponse=RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/auth")
		.body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}")
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.log()
		.all()
		.extract()
		.asString();
		
		JsonPath jsopnPath=new JsonPath(jsonResponse);
		System.out.println(jsopnPath.getBoolean("token"));
		Assert.assertNotNull(jsopnPath.get("token"));
		
	}
	
	@Test(enabled=true)
	public void f2() {
		RestAssured
		.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/auth")
		.body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}")
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then()
		.log()
		.all()
		.body("token", Matchers.notNullValue())
		.body("token.length()", Matchers.is(15));
		
	
		
	}

}
