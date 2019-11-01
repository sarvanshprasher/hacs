package hacs;

import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sarvansh Prasher
 * @version 2.0
 */


public class CourseIterator implements Iterator<Object> {

	ClassCourseList courseList;
	int currentCourseNumber = -1;

	public CourseIterator() {
	}

	/*
	 * This function sets the course list into constructor
	 * 
	 * @return Course
	 */
	public CourseIterator(ClassCourseList classCourseList) {

		courseList = classCourseList;

	}

	/*
	 * This function check if the course has next element in course list.
	 * 
	 * @return boolean
	 */
	public boolean hasNext() {

		if (currentCourseNumber >= courseList.size() - 1)
			return false;
		else
			return true;

	}

	/*
	 * This function gets the next object Course.
	 * 
	 * @return Course
	 */
	public Object next() {

		if (hasNext() == true) {
			currentCourseNumber++;
			return courseList.get(currentCourseNumber);
		} else {
			return null;
		}

	}

	/*
	 * This function removes the course which is in position of currentCourseNumber
	 */
	public void remove() {

		courseList.remove(currentCourseNumber);

	}

	/*
	 * This function gets the next object Course that fits the given CourseName
	 * 
	 * @return Course
	 */
	public Object next(String courseName) {

		Course theCourse;
		theCourse = (Course) next();
		while (theCourse != null) {
			if (courseName.compareTo(theCourse.toString()) == 0) {
				return theCourse;
			}
			theCourse = (Course) next();
		}
		return null;

	}

}