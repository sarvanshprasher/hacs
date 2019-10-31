package testHacs;

/*
* @author Sarvansh Prasher
* @version 1.0
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.Assignment;
import hacs.Course;

public class TestCourse {
	
	/*
	 * This method is for testing assignment addition
	 */	
	@Test
	void testAddAssignment() {
		
		Course course = new Course("Intro to software engineering" , 0);
		
		Assignment ass = new Assignment();
		
		course.addAssignment(ass);
		
		assertEquals(1,course.getListSize());
	}
	
	/*
	 * This method is for testing Course name toString function
	 */	
	@Test
	void testToString() {
		
		Course course = new Course("Intro to software engineering" , 0);
		
		assertEquals(true,course.toString().contentEquals("Intro to software engineering") );
	}

}
