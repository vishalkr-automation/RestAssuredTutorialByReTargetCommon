package convertJSONObjectResponseToPOJO;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@JsonIncludeProperties(value= {"first_name","skills"})   //It will fetch only these 2 data values
public class Video_64_EmployeeSkills extends Video_64_Employee {
	
	private String skills;

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

}