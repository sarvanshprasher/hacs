package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.Course;
import hacs.CourseIterator;

class TestCourseIterator {

	ClassCourseList courses = new ClassCourseList();

	@BeforeEach
	void testGetCourses() {
		courses.initializeFromFile("CourseInfo.txt");
		
		System.out.println(courses);
	}

	@AfterEach
	void testGetCoursesList() {
		courses = new ClassCourseList();
	}

	@Test
	void testHasNext() {

		CourseIterator courseIterator = new CourseIterator(courses);
		assertTrue(courseIterator.hasNext());
		courseIterator.next();
		assertTrue(courseIterator.hasNext());
		courseIterator.next();
		assertTrue(courseIterator.hasNext());
		courseIterator.next();
		assertFalse(courseIterator.hasNext());

	}

	@Test
	void testNext() {

		CourseIterator courseIterator = new CourseIterator(courses);
		Course firstCourse = courses.get(0);
		Course secondCourse = (Course) courseIterator.next();
		assertEquals(firstCourse, secondCourse);
		firstCourse = courses.get(1);
		secondCourse = (Course) courseIterator.next();
		assertEquals(firstCourse, secondCourse);

	}

	@Test
	void testRemove() {

		CourseIterator courseIterator = new CourseIterator(courses);
		int size = courses.size() - 1;
		courseIterator.next();
		courseIterator.remove();
		int afterSize = courses.size();
		assertEquals(size, afterSize);

	}

	@Test
	void testObjectNext() {

		CourseIterator courseIterator = new CourseIterator(courses);
		Course firstCourse = courses.get(2);
		Course nextCourse = (Course) courseIterator.next("CSE890");
		assertEquals(firstCourse, nextCourse);

	}

}
