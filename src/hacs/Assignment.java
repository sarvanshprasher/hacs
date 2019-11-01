package hacs;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author Sarvansh Prasher
 * @version 2.0
 */

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;

public class Assignment {

	protected String assignmentName;
	protected String assignmentFilename;
	protected Date dueDate = new Date();
	protected String assSpecification;
	protected SolutionList solutionList = new SolutionList();
	protected Solution suggestSolution = new Solution();

	/*
	 * This function is constructor.
	 * 
	 */
	public Assignment() {
	}

	/*
	 * This function sets the due date for assignment.
	 * 
	 */
	public void setDueDate(Date theDueDate) {

		this.dueDate = theDueDate;

	}

	/*
	 * This function sets the specification for assignment.
	 * 
	 */
	public void setAssSpec(String theSpec) {

		this.assSpecification = theSpec;

	}

	/*
	 * This function check the overDue for assignment.
	 * 
	 * @return boolean isOverDue
	 */
	public boolean isOverDue() {

		Date today;
		today = new Date();
		if (today.after(this.dueDate)) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * This function checks the addition of solution.
	 * 
	 * @return Solution
	 */
	public Solution addSolution() {

		Solution mySolution = new Solution();
		return mySolution;

	}

	/*
	 * This function checks the addition of solution in list.
	 * 
	 */
	public void addSolution(Solution theSolution) {

		solutionList.add(theSolution);

	}

	/*
	 * This function does the submission of solution.
	 * 
	 */
	public void submitSolution() throws IOException {

		String fileContent = "Solution 1: Problem 1 solution";
		BufferedWriter writer = new BufferedWriter(new FileWriter("c:/temp/solution.txt"));
		writer.write(fileContent);
		writer.close();

	}

	/*
	 * This function gets solution list.
	 * 
	 * @return SolutionList
	 */
	public SolutionList getSolutionList() {

		return this.solutionList;

	}

	/*
	 * This function checks the getting of solution.
	 * 
	 * @return Solution
	 */
	public Solution getSolution(String studentname) {

		Iterator<Solution> Iterator = solutionList.iterator();
		return (Solution) Iterator.next();

	}

	/*
	 * This function does the getting of suggested solution.
	 * 
	 * @return Solution
	 */
	public Solution getSugSolution() {

		return suggestSolution;

	}

	/*
	 * This function does the getting of solution iterator.
	 * 
	 * @return SolutionIterator
	 */
	public SolutionIterator getSolutionIterator() {

		SolutionIterator theSolutionIterator = new SolutionIterator(solutionList);
		return theSolutionIterator;

	}

	/*
	 * This function converts the assignment name to string.
	 * 
	 * @return String
	 */
	public String toString() {

		return assignmentName;

	}

	/*
	 * This function gets the assignment due date to string.
	 * 
	 * @return String
	 */
	public String getDueDateString() {

		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		return dateFormat.format(dueDate);

	}

	/*
	 * This function gets the assignment specification.
	 * 
	 * @return String
	 */
	public String getAssSpec() {

		return assSpecification;

	}

	/*
	 * This function accepts the node visitor and redirects it to visit assignment.
	 * 
	 */
	public void accept(NodeVisitor visitor) {

		visitor.visitAssignment(this);

	}
}