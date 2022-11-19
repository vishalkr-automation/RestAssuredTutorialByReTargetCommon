package lombookExample;

import lombok.Getter;
import lombok.Setter;

//This 2 annotation came from concept of lombok - which helps to remove getter and setter which makes code length reduce
@Getter
@Setter
public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String email;


}
