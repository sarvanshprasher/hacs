package hacs;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * 
 * @author Sarvansh Prasher
 * @version 2.0
 */

public class Student extends Person {

	public Student() {
		
		type = 0;
		
	}

	/*
	 *  For showing the course menu for student
	 */
	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {

		if (theLevel == 0) {
			courseMenu = new HighLevelCourseMenu();
		} else {
			courseMenu = new LowLevelCourseMenu();
		}
		return courseMenu;
	}

	/*
	 *  For showing the menu for student
	 */
	@Override
	public boolean showMenu() {
		
		super.showMenu();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
		
	}
}