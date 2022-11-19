package jsonpathexample;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Video_24_JSONPath_Example {
	
	//Simple JSON Path
	@Test(enabled=false)
	public void f() {
		String json="{\r\n"
				+ "  \"firstname\" : \"Amod\",\r\n"
				+ "  \"lastname\" : \"Mahajn\",\r\n"
				+ "  \"age\": 28,\r\n"
				+ "  \"address\":\"Bengalure\",\r\n"
				+ "  \"salary\":\"10.5\",\r\n"
				+ "  \"married\":false \r\n"
				+ "}";
		
		JsonPath jsonPath=new JsonPath(json);
		
		String firstName=jsonPath.getString("firstname");
		System.out.println(firstName);
		
		//We can return any object value
		Object lastname=jsonPath.getString("lastname");
		System.out.println(lastname);
		
		int age=jsonPath.getInt("age");
		System.out.println(age);
		
		float salary=jsonPath.getFloat("salary");
		System.out.println(salary);
		
		double salary1=jsonPath.getDouble("salary");
		System.out.println(salary1);
		
		boolean married=jsonPath.getBoolean("married");
		System.out.println(married);	
	}
	
	//Nested JSON Path
		@Test(enabled=false)
		public void f2() {
			String json="{\r\n"
					+ "  \"firstname\" : \"Amod\",\r\n"
					+ "  \"lastname\" : \"Mahajn\",\r\n"
					+ "  \"age\": 28,\r\n"
					+ "  \"address\":{\r\n"
					+ "    \"flatNo\":404,\r\n"
					+ "    \"buildingName\":\"ABC\",\r\n"
					+ "    \"StreetName\":\"XYZ\",\r\n"
					+ "    \"Pin\":456\r\n"
					+ "  },\r\n"
					+ "  \"salary\":\"10.5\",\r\n"
					+ "  \"married\":false \r\n"
					+ "}";
			
			JsonPath jsonPath=new JsonPath(json);
			
			String firstName=jsonPath.getString("firstname");
			System.out.println(firstName);
			
			Object flatnumber=jsonPath.getString("address.flatNo");
			System.out.println(flatnumber);
			
		}
		
		//Nested JSON Path
				@Test(enabled=true)
				public void f3() {
					String json="{\r\n"
							+ "  \"firstname\": \"Amod\",\r\n"
							+ "  \"lastname\": \"Mahajn\",\r\n"
							+ "  \"age\": 28,\r\n"
							+ "  \"address\": {\r\n"
							+ "    \"flatNo\": 404,\r\n"
							+ "    \"buildingName\": \"ABC\",\r\n"
							+ "    \"StreetName\": {\r\n"
							+ "      \"Street1\": \"XYZ\",\r\n"
							+ "      \"Street2\": \"123XYZ\"\r\n"
							+ "    },\r\n"
							+ "    \"Pin\": 456\r\n"
							+ "  },\r\n"
							+ "  \"salary\": \"10.5\",\r\n"
							+ "  \"married\": false\r\n"
							+ "}";
					
					JsonPath jsonPath=new JsonPath(json);
					
					String firstName=jsonPath.getString("firstname");
					System.out.println(firstName);
					
					Object street1=jsonPath.getString("address.StreetName.Street1");
					System.out.println("Value of Street 1: " + street1);
					
					//Will read all the address value
					Object address=jsonPath.get("address");
					System.out.println(address);
					
				}
		

}
