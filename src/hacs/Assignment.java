package hacs;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;

public class Assignment {

	protected String AssName;
	protected String strAssignmentFilename;
	protected Date DueDate = new Date();
	protected String AssSpec;
	protected SolutionList theSolutionList = new SolutionList();
	protected Solution SuggestSolution = new Solution();

	public Assignment() {
	}

	public void setDueDate(Date theDueDate) {
		
		this.DueDate = theDueDate;
	
	}

	public void setAssSpec(String theSpec) {
		
		this.AssSpec = theSpec;
		
	}

	public boolean isOverDue() {
		
		Date today;
		today = new Date();
		if (today.after(this.DueDate)) {
			return true;
		} else {
			return false;
		}
		
	}

	public Solution addSolution() {
		
		Solution mySolution = new Solution();
		return mySolution;
	
	}

	//// add the theSolution to the Solutionlist
	public void addSolution(Solution theSolution) {
		
		theSolutionList.add(theSolution);
	
	}

	public void submitSolution() throws IOException {
		
		String fileContent = "Solution 1: Problem 1 solution";
		BufferedWriter writer = new BufferedWriter(new FileWriter("c:/temp/solution.txt"));
		writer.write(fileContent);
		writer.close();

	}

	public SolutionList getSolutionList() {
		
		return this.theSolutionList;
	
	}

	/*
	 * return the solution of the give name
	 */
	public Solution getSolution(String studentname) {
		
		Iterator<Solution> Iterator = theSolutionList.iterator();
		return (Solution) Iterator.next();
		
	}

	public Solution getSugSolution() {
		
		return SuggestSolution;
		
	}

	public SolutionIterator getSolutionIterator() {
		
		SolutionIterator theSolutionIterator = new SolutionIterator(theSolutionList);
		return theSolutionIterator;
		
	}

	public String toString() {
		
		return AssName;
		
	}

	public String getDueDateString() {
		
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		return dateFormat.format(DueDate);
		
	}

	public String getAssSpec() {
		
		return AssSpec;

	}

	public void accept(NodeVisitor visitor) {
		
		visitor.visitAssignment(this);
	
	}
}