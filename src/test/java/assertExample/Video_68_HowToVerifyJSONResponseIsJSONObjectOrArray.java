package assertExample;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class Video_68_HowToVerifyJSONResponseIsJSONObjectOrArray {
	
	public static void main(String[] args) {
		//To verify response is JSON Object i.e Map
		RestAssured.get("https://run.mocky.io/v3/f0d92ffd-75ad-4379-a3cb-6171bbb5bd57")
		.then()
		.body("", Matchers.instanceOf(Map.class));
		
		//To verify response is JSON Array i.e List
				RestAssured.get("https://run.mocky.io/v3/d94018cd-c55f-4f61-9ad7-437242b69f2a")
				.then()
				.body("", Matchers.instanceOf(List.class));
				
				//To verify response is JSON Array i.e List
				RestAssured.get("https://run.mocky.io/v3/2b93de7a-e667-4eed-9ec4-31078fa7a6cd")
				.then()
				.body("mob", Matchers.instanceOf(List.class));
		
		
	}

}
