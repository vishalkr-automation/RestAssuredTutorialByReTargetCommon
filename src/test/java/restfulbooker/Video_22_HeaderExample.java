package restfulbooker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class Video_22_HeaderExample {
	
	@Test(enabled=false)
	public void f1() {
		RestAssured
		.given()
		.log()
		.all()
		.header("Header1","Value1")
		.header("Header2","Value1","Value2","Value3")
		.when()
		.get();
	}
	
	@Test(enabled=false)
	public void f2() {
		RestAssured
		.given()
		.log()
		.all()
		.header("Header1","Value1")
		.header("Header1","Value1")
		.when()
		.get();
	}
	
	@Test(enabled=false)
	public void f3() {
		Header header=new Header("Header1","Value1");
		RestAssured
		.given()
		.log()
		.all()
		.header(header)
		.when()
		.get();
	}
	
	@Test(enabled=false)
	public void f4() {
		//Header header=new Header("Header1","Value1");
		RestAssured
		.given()
		.log()
		.all()
		.headers("header1","value1","header2","value2","header3","value3","header4","value4")
		.when()
		.get();
	}
	
	@Test(enabled=false)
	public void f5() {
		Map<String, String> map=new HashMap<String, String>();
		map.put("Header1", "Value1");
		map.put("Header2", "Value2");
		map.put("Header3", "Value3");
		map.put("Header4", "Value4");
		
		RestAssured
		.given()
		.log()
		.all()
		.headers(map)
		.when()
		.get();
	}

	@Test(enabled=false)
	public void f6() {
		Header header=new Header("Header1","Value1");
		Headers headers=new Headers(header);
		RestAssured
		.given()
		.log()
		.all()
		.headers(headers)
		.when()
		.get();
	}
	
	@Test(enabled=true)
	public void f7() {
		List<Header> list=new ArrayList<>();
		Header header1=new Header("Header1","Value1");
		Header header2=new Header("Header1","Value1");
		list.add(header1);
		list.add(header2);
		
		Headers headers=new Headers(list);
		
		RestAssured
		.given()
		.log()
		.all()
		.headers(headers)
		.when()
		.get();
	}
}
