package testHacs;

/*
* @author Sarvansh Prasher
* @version 1.0
*/
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

import hacs.Assignment;
import hacs.Solution;
import hacs.SolutionList;

public class TestAssignment {

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
	 * Testing whether the assignment specification is correct or not
	 */
	@Test
	 void testSetAssSpec() {

		Assignment assignment = new Assignment();
		String name = "Assignment";
		assignment.setAssSpec(name);
		assertEquals(true, assignment.getAssSpec().equals(name));

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
	 void testIsOverDue() throws InterruptedException {

		Date now = new Date();
		Assignment assignment = new Assignment();
		TimeUnit.SECONDS.sleep(1);
		assignment.setDueDate(now);
		final boolean overDue = assignment.isOverDue();
		assertTrue(overDue);

	}

	/*
	 * 
	 * Testing whether the solution is getting added for the assignment or not
	 */
	@Test
	 void testAddSolution() {

		Solution solution = new Solution();
		solution = assignment.addSolution();
		assertEquals(true, solution instanceof Solution);

	}

	/*
	 * 
	 * Testing whether the solution is getting added to the list of solution or not
	 */
	@Test
	 void testAddSolutionList() {

		Assignment assignment = new Assignment();
		Solution solution = new Solution();
		assignment.addSolution(solution);
		SolutionList solutions = assignment.getSolutionList();
		assertEquals(solution, solutions.get(0));

	}

	/*
	 * 
	 * Testing whether the solution instance is correct return type while getting
	 * solution for any student.
	 */
	@Test
	 void testGetSolution() {

		Solution solution = new Solution();
		Assignment assignment = new Assignment();
		assignment.addSolution(solution);
		assertEquals(solution, assignment.getSolution(""));

	}

	/*
	 * 
	 * Testing the suggested solution
	 */
	@Test
	 void testGetSugSolution() {

		Solution solution = new Solution();
		solution = assignment.getSugSolution();
		assertEquals(true, solution instanceof Solution);

	}

	/*
	 * 
	 * Testing whether the assignment name is not null.
	 */
	@Test
	 void testToString() {

		Assignment assignment = new Assignment();
		String name = null;
		String assignmentName = assignment.toString();
		assertEquals(name, assignmentName);

	}

}
