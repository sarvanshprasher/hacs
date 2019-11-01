package hacs;

import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author Sarvansh Prasher
 * @version 2.0
 */

abstract public class Person {

	int type = 0;
	String userName;
	ClassCourseList courseList;
	CourseMenu courseMenu;
	Course currentCourse;
	Assignment currentAssignment;

	public Person() {

		courseList = new ClassCourseList();
		courseList.initializeFromFile("CourseInfo.txt");
	}

	/*
	 * This method is for showing the menu in the course for person.
	 */
	abstract public CourseMenu createCourseMenu(Course theCourse, int theLevel);

	/*
	 * This method is for showing the add buttons in the course.
	 */
	public void showAddButton() {

		courseMenu.showAddButtons();

	}

	/*
	 * This method is for showing the view buttons in the course.
	 */
	public void showViewButtons() {

		courseMenu.showViewButtons();

	}

	/*
	 * This method is for showing the comboxes buttons in the course.
	 */
	public void showComboxes() {

		courseMenu.showComboxes();

	}

	/*
	 * This method is for showing the radio buttons in the course.
	 */
	public void showRadios() {

		courseMenu.showRadios();

	}

	/*
	 * // For person show the course menu and set it to setVisible(true)
	 */
	public void show() {

		// For person show the course menu and set it to setVisible(true)
		courseMenu.setVisible(true);

	}

	/*
	 * For person check if person is logout
	 */
	public boolean ifLogout() {

		return courseMenu.ifLogout();

	}

	/*
	 * show the assignment list
	 */
	public boolean showMenu() {

		// create a iterator for the assignment list
		// Iterator theIter=new ListIterator(CurrentCourse.AssList );
		Iterator<Assignment> theIter = currentCourse.assignmentList.iterator();
		courseMenu.course = currentCourse;
		Assignment theAssignment;
		while (theIter.hasNext()) {
			theAssignment = (Assignment) theIter.next();
			courseMenu.assignmentCombox.addItem(theAssignment);
		}
		return false;

	}

	/*
	 * get the course list
	 */
	public ClassCourseList getCourseList() {

		return courseList;

	}

	/*
	 * add the course to course list
	 */
	public void addCourse(Course theCourse) {

		courseList.add(theCourse);

	}
}