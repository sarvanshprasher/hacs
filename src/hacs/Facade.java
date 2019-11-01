package hacs;

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
 * 
 */

public class Facade {

	public int userType;
	private Course selectedCourse = null;
	private int courseLevel = 0;
	ClassCourseList courseList;
	Person person;

	public Facade() {
	}

	/*
	 * This function checks if login was successfull or not
	 */
	static public boolean login(UserInfoItem userinfoItem) {

		Login login = new Login();
		login.setModal(true);
		// set login show to setVisible(true).
		login.setVisible(true);
		userinfoItem.strUserName = login.getUserName();
		userinfoItem.UserType = login.getUserType();
		return login.isExit();

	}

	/////////////////////////
	// functions for CourseMenu
	/*
	 * When click the add button of the CourseMenu , call this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu. the coursemenu need to
	 * refreshed outside the function
	 */
	void addAssignment(Course theCourse) {

		AssignmentMenu theAssignmentMenu;
		if (person.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, person);
		theCourse.addAssignment(theAssignment);

	}

	/*
	 * When click the view button of the CourseMenu , call this function and pass
	 * the pointer of the Assignment and the person pointer to this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user
	 */
	void viewAssignment(Assignment assignment) {

		AssignmentMenu assignmentMenu;
		if (person.type == 0)/// student
		{
			assignmentMenu = new StudentAssignmentMenu();

		} else {

			assignmentMenu = new InstructorAssignmentMenu();
		}

		assignmentMenu.showMenu(assignment, person);

	}

	/*
	 * this function will grade the give Solution: theSolution this function calls
	 */
	void gradeSolution(Solution solution) {

		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.showMenu(solution);

	}

	/*
	 * this function will report the Solutions
	 */
	void reportSolutions(Assignment assignment) {

		Solution solution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = assignment.getSolutionIterator();
		solution = (Solution) theSolutionIterator.next();
		while (solution != null) {
			solution.setReported(true);
			solution = (Solution) theSolutionIterator.next();

		}
	}

	/*
	 * this function will submit the Solutions
	 */
	void submitSolution(Assignment assignment, Solution solution) {

		assignment.addSolution(solution);

	}

	/*
	 * this function will remind the person about courses informaiton such as
	 * assignment reminders
	 */
	public void remind() {

		Reminder reminder = new Reminder();
		reminder.showReminder(person.getCourseList());

	}

	public void createUser(UserInfoItem userinfoitem) {

		if (userinfoitem.getUserType() == UserType.Student) /// student
		{
			person = new Student();

		} else {
			person = new Instructor();
		}

		person.userName = userinfoitem.strUserName;

	}

	/*
	 * create a course list and intitialize it with the file CourseInfo.txt
	 */
	public void createCourseList() {

		courseList = new ClassCourseList();
		courseList.initializeFromFile("CourseInfo.txt");

	}

	/*
	 * call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCouresList attach the
	 * Matched course object to the new create user Facade.thePerson.CourseList
	 */
	public void attachCourseToUser() {

		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("UserCourse.txt"));
			String endOfLine, userName, courseName;
			while ((endOfLine = file.readLine()) != null) {
				userName = getUserName(endOfLine);
				courseName = getCourseName(endOfLine);
				if (userName.compareTo(person.userName) == 0) {
					selectedCourse = findCourseByCourseName(courseName);
					if (selectedCourse != null) {
						person.addCourse(selectedCourse);
					}
				}
			}
			file.close();
		} catch (Exception ee) {
			;
		}

	}

	/*
	 * get the user name from aline UserName:CourseName
	 */
	private String getUserName(String endOfLine) {

		int seperator = endOfLine.lastIndexOf(':');
		return endOfLine.substring(0, seperator);

	}

	/*
	 * get the CourseName from aline UserName:CourseName
	 */
	private String getCourseName(String endOfLine) {

		int seperator = endOfLine.lastIndexOf(':');
		return endOfLine.substring(seperator + 1, endOfLine.length());

	}

	/*
	 * show the course selection dlg, show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelecteCourse, the Course Level to CourseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 */
	public boolean selectCourse() {

		CourseSelectDlg dialog = new CourseSelectDlg();
		selectedCourse = dialog.showDlg(person.courseList);
		person.currentCourse = selectedCourse;
		courseLevel = dialog.nCourseLevel;
		return dialog.isLogout();

	}

	/*
	 * call the thePerson.CreateCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 */
	public boolean courseOperation() {

		person.createCourseMenu(selectedCourse, courseLevel);
		return person.showMenu();

	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	private Course findCourseByCourseName(String strCourseName) {

		CourseIterator Iterator = new CourseIterator(courseList);
		return (Course) Iterator.next(strCourseName);

	}

	public ClassCourseList getCourses() {

		return courseList;

	}

	public Person getPerson() {

		return person;

	}

}