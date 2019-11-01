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
 * 
 */

public class Solution {

	String author = "";
	String solutionFileName = "";
	Date submittedDate = new Date();
	int grade;
	boolean reported = false;

	public Solution() {
	}

	@Override
	public String toString() {

		String string;
		string = author + "  " + solutionFileName + " Grade=" + getGradeInt() + "  ";
		if (isReported())
			string += "reported";
		else
			string += "not reported";

		return (string);

	}

	/*
	 * This function gets the grade string for solution
	 */
	String getGradeString() {

		if (isReported())
			return "" + grade;
		else
			return "-1";

	}

	/*
	 * This function sets the grade for solution
	 */
	public void setGradeInt(int gradeInt) {

		grade = gradeInt;

	}

	/*
	 * This function gets the grade for solution.
	 */
	public int getGradeInt() {

		return grade;

	}

	/*
	 * This function set the isReported value for a solution.
	 */
	public void setReported(boolean reported) {

		this.reported = reported;

	}

	/*
	 * This function checks if solution is reported or not.
	 */
	public boolean isReported() {

		return reported;

	}

	/*
	 * This function sets the author name.
	 */
	public void setAuthorName(String authorName) {

		author = authorName;

	}

	/*
	 * This function gets the author name.
	 */
	public String getAuthorName() {

		return author;

	}

	/*
	 * This function sets the solution file name.
	 */
	public void setSolutionFileName(String solutionFileName) {

		this.solutionFileName = solutionFileName;

	}

	/*
	 * This function gets the solution file name.
	 */
	public String getSolutionFileName() {

		return this.solutionFileName;

	}
}