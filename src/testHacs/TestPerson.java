package testHacs;

/*
* @author Sarvansh Prasher
* @version 1.0
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.Course;
import hacs.Person;
import hacs.Student;

public class TestPerson {

	@Test
    void testGetCourseList() {
		
        Person person = new Student();
        Course course = new Course("Intro to Software Engineering", 0);     
        ClassCourseList courseList = new ClassCourseList();
        courseList.add(course);        
        person.addCourse(course);
        ClassCourseList courseListForPerson =  person.getCourseList();
        assertEquals(courseList, courseListForPerson);
        
    }
	
	@Test
	void testAddCourse() {
		
		 Person person = new Student();
		 Course course = new Course("Intro to Software Engineering", 0);     
		 ClassCourseList courseList = new ClassCourseList();
		 courseList.add(course);        
		 person.addCourse(course);
		 assertEquals(1,courseList.size());
		 	 
	}

}
