package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sarvansh Prasher
 * @version 2.0
 */

public class Instructor extends Person {

	public Instructor() {
		type = 1;
	}

	/*
	 * This function creates the CourseMenu for Instructor
	 */
	public CourseMenu createCourseMenu(Course course, int level) {
		
		if (level == 0) {
			courseMenu = new HighLevelCourseMenu();
		} else {
			courseMenu = new LowLevelCourseMenu();
		}
		return courseMenu;
		
	}

	/*
	 * This function shows the CourseMenu for Instructor
	 */
	public boolean showMenu() {
		
		super.showMenu();
		showAddButton();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
		
	}
}