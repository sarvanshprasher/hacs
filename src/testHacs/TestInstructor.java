package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.Course;
import hacs.CourseMenu;
import hacs.HighLevelCourseMenu;
import hacs.Instructor;
import hacs.LowLevelCourseMenu;

class TestInstructor {

	/*
	 * Testing high level course menu for instructor while creating menu
	 * 
	 */
	@Test
	void testHighLevelCreateCourseMenu() {

		Instructor instructor = new Instructor();
		Course course = new Course("Intro to software Engineering", 0);
		CourseMenu courseMenu;
		courseMenu = instructor.createCourseMenu(course, 0);
		assertEquals(true, courseMenu instanceof HighLevelCourseMenu);

	}

	/*
	 * Testing low level course menu for instructor while creating menu
	 * 
	 */
	@Test
	void testLowLevelCreateCourseMenu() {

		Instructor instructor = new Instructor();
		Course course = new Course("Foundations of Software Engineering", 1);
		CourseMenu courseMenu;
		courseMenu = instructor.createCourseMenu(course, 1);
		assertEquals(true, courseMenu instanceof LowLevelCourseMenu);

	}

}
