package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.Course;
import hacs.CourseIterator;

class TestCourseIterator {
	
	ClassCourseList classCourseList;
	
	
	@Test
	void TestHasNext() {
		
		Course course1 = new Course("Intro to software engineering", 0);
		classCourseList.contains(course1);
		CourseIterator courseIterator = new CourseIterator(classCourseList);
		boolean result = courseIterator.hasNext();
		assertEquals(true,result);
		
	}

}
