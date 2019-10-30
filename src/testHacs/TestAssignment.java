package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import hacs.Assignment;
import hacs.Solution;

class TestAssignment {

	final Assignment assignment = new Assignment();

	/*
	 * 
	 * Testing whether the due date for given assignment is set or not
	 */
	@Test
	void testSetDueDate() {

		Date nowDate = new Date();
		assignment.setDueDate(nowDate);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yy");
		String date = sdf.format(new Date());

		assertEquals(true, assignment.getDueDateString().equals(date));

	}

	
	/*
	 * 
	 * Testing whether the assignment specification is not null
	 */
	@Test
	void testSetAssSpecNotNull() {

		assignment.setAssSpec("Assignment");
		assertNotNull(assignment.getAssSpec());

	}
	
	/*
	 * 
	 * Testing whether the assignment is over due or not 
	 */
	@Test
	void testIsOverDue() {

		boolean isOverDue = assignment.isOverDue();
		assertEquals(true, isOverDue);

	}
	
	/*
	 * 
	 * Testing whether the solution is getting added for the assignment or not
	 */
	@Test
	void testAddSolution() {

		Solution solution = new Solution();
		assertEquals(true, solution instanceof Solution);

	}
	
	/*
	 * 
	 * Testing whether the solution is getting added to the list of solution or not
	 */
	@Test
	void testAddSolutionList() {

		Solution mySolution = new Solution();
		assignment.addSolution(mySolution);
		assertEquals(1,assignment.getSolutionList().size());

	}
	
	/*
	 * 
	 * Testing whether the solution instance is correct return type while getting solution for
	 * any student.
	 */
	@Test
	void testGetSolution() {
		
		
	}
	
	/*
	 * 
	 * Testing the suggested solution
	 */
	@Test
	void testGetSugSolution() {
		
		Solution solution = new Solution();
		assertEquals(true, solution instanceof Solution);
		
	}
	
	/*
	 * 
	 * Testing whether the assignment name is not null.
	 */
	@Test
	void testToString() {

		assignment.setAssSpec("Assignment 1");
		assertNotNull(assignment.getAssSpec());

	}
	

	/*
	 * 
	 * Testing whether the assignment name is not null.
	 */
	@Test
	void testToStringNull() {

		assignment.setAssSpec(null);
		assertNull(assignment.getAssSpec());

	}

}
