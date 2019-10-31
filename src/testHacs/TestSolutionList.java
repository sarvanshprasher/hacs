package testHacs;

/*
* @author Sarvansh Prasher
* @version 1.0
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.SolutionIterator;
import hacs.SolutionList;

public class TestSolutionList {

	@Test
	void iteratorTest() {

		SolutionList solutions = new SolutionList();
		assertTrue(solutions.iterator() instanceof SolutionIterator);

	}

}
