package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.Course;
import hacs.CourseMenu;
import hacs.Student;

public class TestStudent {

	@Test
	void TestCreateCourseMenu() {

		Student student = new Student();
		Course course = new Course("Intro to Software Engineering", 0);
		CourseMenu courseMenu;
		courseMenu = student.createCourseMenu(course, 0);
		assertEquals(true, courseMenu instanceof CourseMenu);

	}
	

}
