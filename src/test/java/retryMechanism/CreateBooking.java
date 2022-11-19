package retryMechanism;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateBooking {

	public static Response createBooking(String url, String body) {
		int randomNumber=(int)(Math.random()*(50-1)+1);
		
		System.out.println(randomNumber);
		
		if(randomNumber%2 == 0) {
			System.out.println("Booking creating....");
			return RestAssured
					.given()
					.body(body)
					.contentType(ContentType.JSON)
					.post(url);
		}
		else {
			System.out.println("Booking Creating Failed....");
			return null;
		}
	}
}
