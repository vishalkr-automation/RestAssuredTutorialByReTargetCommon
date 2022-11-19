package jsonpathexample;

import java.io.File;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Video_30_ReadJSON_PathUsingFilters {
	
	@Test(enabled=false)
	public void f1() {
		String filePath=System.getProperty("user.dir")+".\\TestData\\People.json";
		File file=new File(filePath);
		
		JsonPath jsonPath=new JsonPath(file);
		
		//Print a specific Name 
		String firstName=jsonPath.getString("[0].firstName");
		System.out.println(firstName);
		
		//Print all FirstName
		List<String> allFirstName=jsonPath.getList("firstName");
		System.out.println("First Name: "+ allFirstName);
		
		//Print first name of all the female
		List<String> allFeamleFirstName=jsonPath.getList("findAll{it.gender=='female'}.firstName");
		System.out.println("First Name of all the female: "+ allFeamleFirstName);
		
		//Get email of a specific person
		String email=jsonPath.get("find{it.firstName=='Kavita' & it.LastName=='Singh'}.email");
		System.out.println(email);
		
		//Get email of a specific person
		List<String> email1 = jsonPath.getList("findAll{it.firstName=='Kavita' | it.LastName=='Singh'}.email");
		System.out.println(email1);
		
		//Print first Name whose id is greater than 2
		List<String> names = jsonPath.getList("findAll{it.id >= 2}.firstName");
		System.out.println(names);
		
		//Will print the total Integer data types are available in the JSON file
		System.out.println(jsonPath.getInt("size()"));

	}
	
	//Here in this example we are using data as array variable in JSON File
	@Test(enabled=true)
	public void f2() {
		String filePath=System.getProperty("user.dir")+".\\TestData\\People2.json";
		File file=new File(filePath);
		
		JsonPath jsonPath=new JsonPath(file);
		
		//Print a specific Name 
		String firstName=jsonPath.getString("data[0].firstName");
		System.out.println(firstName);
		
		//Print all FirstName
		List<String> allFirstName=jsonPath.getList("data.firstName");
		System.out.println("First Name: "+ allFirstName);
		
		//Print first name of all the female
		List<String> allFeamleFirstName=jsonPath.getList("data.findAll{it.gender=='female'}.firstName");
		System.out.println("First Name of all the female: "+ allFeamleFirstName);
		
		//Get email of a specific person
		String email=jsonPath.get("data.find{it.firstName=='Kavita' & it.LastName=='Singh'}.email");
		System.out.println(email);
//		
//		//Get email of a specific person
//		List<String> email1 = jsonPath.getList("findAll{it.firstName=='Kavita' | it.LastName=='Singh'}.email");
//		System.out.println(email1);
//		
//		//Print first Name whose id is greater than 2
//		List<String> names = jsonPath.getList("findAll{it.id >= 2}.firstName");
//		System.out.println(names);
//		
		//Will print the total Integer data types are available in the JSON file
		System.out.println(jsonPath.getInt("data.size()"));

	}

}
