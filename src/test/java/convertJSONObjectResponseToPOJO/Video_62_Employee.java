package convertJSONObjectResponseToPOJO;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)    //Using this concept we will remove the Empty value which values data not provided at run time0
public class Video_62_Employee {
	
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private boolean married; 
	private List<String> skillSet;
	private Map<String, Object> familyMembers;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public List<String> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(List<String> skillSet) {
		this.skillSet = skillSet;
	}
	public Map<String, Object> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Map<String, Object> familyMembers) {
		this.familyMembers = familyMembers;
	}
	
}