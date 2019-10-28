package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.Assignment;
import hacs.Course;

class TestCourse {
	
	/*
	 * This method is for testing assignment addition
	 */	
	@Test
	void TestAddAssignment() {
		
		Course course = new Course("Intro to software engineering" , 0);
		
		Assignment ass = new Assignment();
		
		course.AddAssignment(ass);
		
		assertEquals(1,course.getListSize());
	}
	
	/*
	 * This method is for testing Course name toString function
	 */	
	@Test
	void TestToString() {
		
		Course course = new Course("Intro to software engineering" , 0);
		
		assertEquals(true,course.toString().contentEquals("Intro to software engineering") );
	}

}
