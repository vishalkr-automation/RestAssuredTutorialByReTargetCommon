package payloadsexample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_38_Designer_Mockey_IO_Example {
	
	@Test
	public void f1() {
		RestAssured
		.given()
		.log()
		.all()
		.get("https://run.mocky.io/v3/f0d92ffd-75ad-4379-a3cb-6171bbb5bd57")
		.then()
		.log()
		.all();
		
	}

}
