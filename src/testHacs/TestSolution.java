package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.Solution;

public class TestSolution {

	@Test
	void testAuthorName() {
		
		Solution solution = new Solution();		
		solution.setAuthorName("John Coronite");
		assertEquals(true,solution.getAuthorName().contentEquals("John Coronite"));
		
	}
	
	@Test
	void testAuthorNameFalse() {
		
		Solution solution = new Solution();		
		solution.setAuthorName("John Adam");
		assertEquals(false,solution.getAuthorName().contentEquals("John Coronite"));
		
	}
	
	@Test
	void testSolutionFileName() {
		
		Solution solution = new Solution();		
		solution.setSolutionFileName("Assignment reverse engineering");
		assertEquals(true,solution.getSolutionFileName().contentEquals("Assignment reverse engineering"));
		
	}
	
	@Test
	void testSolutionFalseFileName() {
		
		Solution solution = new Solution();		
		solution.setSolutionFileName("Assignment reverse engineering conceptual edition");
		assertEquals(false,solution.getSolutionFileName().contentEquals("Assignment reverse engineering"));
		
	}
	
	@Test
	void testSetGradeInt() {
		
		Solution solution = new Solution();		
		solution.setGradeInt(1);
		assertEquals(true,solution.getGradeInt() == 1);
		
	}
	
	@Test
	void testSetGradeIntFalseValue() {
		
		Solution solution = new Solution();		
		solution.setGradeInt(1);
		assertEquals(false,solution.getGradeInt() == 0);
		
	}
	
	
	@Test
	void testIsGradeReported() {
		
		Solution solution = new Solution();		
		solution.setReported(true);
		assertEquals(true,solution.isReported());
		
	}
	
	@Test
	void testToString() {
		
		Solution solution = new Solution();		
		solution.setAuthorName("John Coronite");
		solution.setSolutionFileName("Assignment reverse engineering");
		solution.setGradeInt(1);
		solution.setReported(true);
		String result = solution.toString();
		assertEquals(true,result.contentEquals("John Coronite  Assignment reverse engineering Grade=1  reported"));
		
	}
	
	@Test
	void testToStringFalse() {
		
		Solution solution = new Solution();		
		solution.setAuthorName("John Adam");
		solution.setSolutionFileName("Assignment reverse engineering");
		solution.setGradeInt(1);
		solution.setReported(true);
		String result = solution.toString();
		assertEquals(false,result.contentEquals("John Coronite  Assignment reverse engineering Grade=1  reported"));
		
	}

}
