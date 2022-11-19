package lombookExample;

import org.testng.annotations.Test;

//For use of lombok concept we have to add the lombok in maven dependency and Eclipse editor
//Here in this concept we do not have to use as getter and setter method

public class Video_69_UsageOfEmployee {

	@Test
	public void f() {
		Employee employee=new Employee();
		employee.setId(1);
		employee.setFirstName("Amod");
		employee.setLastName("Mahajan");
		employee.setEmail("lombookexapmle.com");
}
}