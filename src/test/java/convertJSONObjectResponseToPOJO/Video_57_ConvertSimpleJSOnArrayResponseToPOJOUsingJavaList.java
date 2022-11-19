package convertJSONObjectResponseToPOJO;

import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class Video_57_ConvertSimpleJSOnArrayResponseToPOJOUsingJavaList {
	@Test
	public void f() {
	List<Student> student=RestAssured.get("https://run.mocky.io/v3/d94018cd-c55f-4f61-9ad7-437242b69f2a")
			.as(new TypeRef<List<Student>>() {});
	
	System.out.println(student.size());
	System.out.println(student.get(0).getFirst_name());
	System.out.println(student.get(1).getFirst_name());
	
	}
}
