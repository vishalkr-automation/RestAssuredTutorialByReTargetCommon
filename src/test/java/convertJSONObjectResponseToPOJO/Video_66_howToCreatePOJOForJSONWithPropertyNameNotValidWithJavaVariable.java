package convertJSONObjectResponseToPOJO;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Video_66_howToCreatePOJOForJSONWithPropertyNameNotValidWithJavaVariable {
	
	@Test
	public void f() throws JsonProcessingException {
	
		Video_66_Book book=new Video_66_Book();
		
		book.setBookName("Data Structure");
		book.setAuthorName("Mark Henery");
		
		ObjectMapper objectMapper=new ObjectMapper();
		String bookJsonObject=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(book);
		System.out.println(bookJsonObject);
		
		Video_66_Book b1=objectMapper.readValue(bookJsonObject, Video_66_Book.class);
		System.out.println(b1.getBookName());
		System.out.println(b1.getAuthorName());
	    
	}
}
