package payloadsexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Video_37_CreateComplexJSON_Payload {
	
	@Test(enabled=true)
	public void f2() {
		
		List<Map<String, Object>> finalPayload=new ArrayList<>();
		
		//First Object
		Map<String, Object> firstJsonObjext=new LinkedHashMap<>();
		firstJsonObjext.put("id", 1);
		firstJsonObjext.put("firstName", "Gray");
		firstJsonObjext.put("lastName", "Ceyssen");
		firstJsonObjext.put("email", "gceyssen0@pbs.org");
		firstJsonObjext.put("gender", "Male");
		
		List<String> mobileNo=Arrays.asList("9999999999","8888888888");
		
		firstJsonObjext.put("mobile", mobileNo);
		
       Map<String, Object> skillSet1=new LinkedHashMap<>();
       skillSet1.put("name", "Testing");
       skillSet1.put("proficency", "Meduim");
       
       firstJsonObjext.put("skills", skillSet1);
       
       finalPayload.add(firstJsonObjext);
		
       //2nd OBject
       Map<String, Object> secondJsonObjext=new LinkedHashMap<>();
       secondJsonObjext.put("id", 2);
       secondJsonObjext.put("firstName", "Maryjo");
       secondJsonObjext.put("lastName", "Ceyssen");
       secondJsonObjext.put("email", "moxtaby0@wikia.com");
       secondJsonObjext.put("gender", "Female");
		
		List<Map<String, Object>> skilsSet2=new ArrayList<>();
		skilsSet2.add(skillSet1);

		Map<String, Object> javaSkill=new LinkedHashMap<>();
		javaSkill.put("name", "Java");
		javaSkill.put("proficiency", "Medium");
		
		List<String> allCert=Arrays.asList("OCJP 11","OCJP 12");
		javaSkill.put("certification", allCert);
		
		skilsSet2.add(javaSkill);
		
		secondJsonObjext.put("skills", skilsSet2);
		
		//Add second object in final payload
		finalPayload.add(secondJsonObjext);
		
		RestAssured
		.given()
		.log()
		.all()
		.body(finalPayload)       //Here we have to call List instance
		.post();
		
	}

}
