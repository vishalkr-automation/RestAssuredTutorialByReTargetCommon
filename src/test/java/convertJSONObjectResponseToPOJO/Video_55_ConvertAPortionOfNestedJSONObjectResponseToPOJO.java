package convertJSONObjectResponseToPOJO;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_55_ConvertAPortionOfNestedJSONObjectResponseToPOJO {

	@Test
	public void f1() {
		Address address=
				RestAssured.get("https://run.mocky.io/v3/3da70133-f232-4ef9-a526-ace420dfb3af")	
				.jsonPath()
				.getObject("address",Address.class);	
		
  //Calling data from address fields
		System.out.println(address.getHouseNo());
	
	}
}
