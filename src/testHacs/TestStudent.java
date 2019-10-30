package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.Course;
import hacs.CourseMenu;
import hacs.Student;

class TestStudent {

	@Test
	void TestCreateCourseMenu() {
		
		Student student = new Student();
		
		Course course = new Course("Intro to Software Engineering",0);
		
		CourseMenu courseMenu;
		courseMenu = student.CreateCourseMenu(course,0);
		
		assertEquals(true,courseMenu instanceof CourseMenu);
	}
	
	@Test
	void TestShowMenu() {
		
	
	}

}
