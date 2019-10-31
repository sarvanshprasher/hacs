package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.Course;

class TestClassCourseList {

	  @Test
	    void testInitializeFromFile() {
	        ClassCourseList courseList = new ClassCourseList();
	        courseList.initializeFromFile("CourseInfo.txt");
	        Course[] actual = {courseList.get(0),
	                courseList.get(1),
	                courseList.get(2)};

	        assertEquals("CSE870", actual[0].toString());
	        assertEquals("CSE880", actual[1].toString());
	        assertEquals("CSE890", actual[2].toString());
	    }
	
	  
	  @Test
	    void findCourseByCourseNameTest() {
		  ClassCourseList courseList = new ClassCourseList();
	        courseList.initializeFromFile("CourseInfo.txt");
	        String expected = "CSE880";
	        String actual = courseList.findCourseByCourseName("CSE880").toString();

	        assertEquals(expected, actual);
	    }
	  

}
