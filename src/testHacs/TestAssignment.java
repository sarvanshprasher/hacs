package testHacs;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import hacs.Assignment;
import hacs.Solution;


class TestAssignment {
	
	final Assignment assignment = new Assignment();
	
	final Solution solution = new Solution();
	
	final List<Solution> solutionList = new ArrayList<Solution>();
	
	@Test
	void TestSetDueDate(){ 
		
		Date nowDate = new Date();
		assignment.SetDueDate(nowDate);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yy");
		String date = sdf.format(new Date()); 
		
        assertEquals(true,assignment.getDueDateString().equals(date));
		
	}
	
	@Test
	void TestSetAssSpec(){ 
		
	}
	
	
	@Test
	void TestIsOverDue(){ 
		
		boolean isOverDue = assignment.IsOverDue();		

		assertEquals(true,isOverDue);
		
	}
	
	
	
}


