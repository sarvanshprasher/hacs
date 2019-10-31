package testHacs;

/*
* @author Sarvansh Prasher
* @version 1.0
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hacs.Solution;
import hacs.SolutionIterator;
import hacs.SolutionList;

public class TestSolutionIterator {

	SolutionList solution = new SolutionList();
	
	@BeforeEach
	void testGetSolutions() {
		
		solution.initializeFromFile("SolutionInfo.txt");
		
	}

	@AfterEach
	void testGetSolutionList() {
		
		solution = new SolutionList();
		
	}
	
	@Test
	void testHasNext() {

		SolutionIterator solutionIterator = new SolutionIterator(solution);
		assertTrue(solutionIterator.hasNext());
		solutionIterator.next();
		assertTrue(solutionIterator.hasNext());
		solutionIterator.next();
		assertTrue(solutionIterator.hasNext());
		solutionIterator.next();
		assertFalse(solutionIterator.hasNext());

	}
	
	@Test
	void testNext() {

		SolutionIterator solutionIterator = new SolutionIterator(solution);
		Solution firstSolution = solution.get(0);
		Solution secondSolution = (Solution) solutionIterator.next();
		assertEquals(firstSolution, secondSolution);
		firstSolution = solution.get(1);
		secondSolution = (Solution) solutionIterator.next();
		assertEquals(firstSolution, secondSolution);

	}
	
	@Test
	void testRemove() {

		SolutionIterator solutionIterator = new SolutionIterator(solution);
		int size = solution.size() - 1;
		solutionIterator.next();
		solutionIterator.remove();
		int afterSize = solution.size();
		assertEquals(size, afterSize);

	}
	

	

}
