package hacs;

import java.util.ArrayList;
import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * @author Sarvansh Prasher
 * @version 3.0
 */

public class ClassCourseList extends ArrayList<Course> {

	private static final long serialVersionUID = 1L;

	/*
	 * This function works as a constructor.
	 * 
	 */
	public ClassCourseList() {
	}

	/*
	 * This function gets the classes from file.
	 * 
	 */
	public void initializeFromFile(String theFileName) {

		try {
			BufferedReader file;
			String courseName = null;
			file = new BufferedReader(new FileReader("CourseInfo.txt"));
			while ((courseName = file.readLine()) != null) {
				Course course;
				course = new Course(courseName, 0);
				// theCourse.CourseName= strCourseName;
				add(course);
			}
			file.close();

		} catch (Exception ee) {

		}
	}

	/*
	 * This function finds the course by course name
	 * 
	 * @return Course
	 */
	public Course findCourseByCourseName(String CourseName) {

		int courseCount = size();
		Course course = null;
		for (int i = 0; i < courseCount; i++) {
			course = (Course) get(i);
			if (course.courseName.compareTo(CourseName) == 0)
				return course;
		}
		return course;

	}

}