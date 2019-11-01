package hacs;

import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * @author Sarvansh Prasher
 * @version 3.0
 */

public class Course {

	String courseName;
	public ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
	int numOfAssignment;
	int courseLevel;

	/*
	 * This function will be a constructor
	 * 
	 */
	public Course(String course, int courseLevel) {

		this.courseName = course;
		this.courseLevel = courseLevel;
		this.numOfAssignment = 0;

	}

	/*
	 * This function adds the assignment
	 * 
	 */
	public void addAssignment(Assignment newAssigment) {

		assignmentList.add(newAssigment);

	}

	/*
	 * This function gets the course name to string
	 * 
	 * @return courseName
	 */
	public String toString() {

		return courseName;

	}

	/*
	 * This function accepts the node visitor and redirects it to course visitor.
	 * 
	 */
	void accept(NodeVisitor visitor) {

		visitor.visitCourse(this);

	}

	/*
	 * This function gets the assignment list and returns the list size.
	 * 
	 * @return assignment list size
	 */
	public int getListSize() {

		return assignmentList.size();

	}

}