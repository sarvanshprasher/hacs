package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.Solution;
import hacs.SolutionList;

public class TestSolutionList {

	  @Test
	    void testInitializeFromFile() {
	        SolutionList solutionList = new SolutionList();
	        solutionList.initializeFromFile("SolutionInfo.txt");
	        Solution[] solution = {solutionList.get(0),
	        		solutionList.get(1),
	        		solutionList.get(2)};

	        assertEquals("Solution 1", solution[0].toString());
	        assertEquals("Solution 2", solution[1].toString());
	        assertEquals("Solution 3", solution[2].toString());
	    }

}
