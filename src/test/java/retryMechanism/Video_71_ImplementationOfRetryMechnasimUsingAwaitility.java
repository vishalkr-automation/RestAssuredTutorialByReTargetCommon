package retryMechanism;

import java.time.Duration;

import org.awaitility.Awaitility;

import io.restassured.response.Response;

public abstract class Video_71_ImplementationOfRetryMechnasimUsingAwaitility {
	public static Response response;
	
	public static void main(String[] args) {
		String url="https://restful-booker.herokuapp.com/booking";
		String body="{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
		Awaitility
		.await()
		.atMost(Duration.ofSeconds(30))
		.pollInterval(Duration.ofSeconds(2))
		.until(() -> {
			response=CreateBooking.createBooking(url, body);
			if(response !=null)
				return true;
			else
				return false;
		});
		System.out.println(response.asString());
	}

}
