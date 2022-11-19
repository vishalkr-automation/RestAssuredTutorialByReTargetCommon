package lombookExample;

import lombok.Builder;
import lombok.Getter;


//This 2 annotation came from concept of lombok - which helps to remove getter and setter which makes code length reduce

@Builder(toBuilder = true)
@Getter
public class Video_70_Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String email;


}
