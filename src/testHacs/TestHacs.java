package testHacs;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import testHacs.TestAssignment;
import testHacs.TestClassCourseList;
import testHacs.TestCourse;
import testHacs.TestFacade;
import testHacs.TestPerson;
import testHacs.TestReminderVisitor;
import testHacs.TestStudent;
import testHacs.TestSolutionIterator;
import testHacs.TestInstructor;
import testHacs.TestCourseIterator;
import testHacs.TestSolution;
import testHacs.TestListIterator;
import testHacs.TestSolutionList;

@RunWith(JUnitPlatform.class)
@SelectClasses( { TestAssignment.class, 
	TestClassCourseList.class, 
	TestCourse.class, 
	TestFacade.class,
	TestPerson.class, 
	TestReminderVisitor.class,
	TestStudent.class, 
	TestSolutionIterator.class,
	TestInstructor.class,
	TestCourseIterator.class, 
	TestSolution.class,
	TestListIterator.class,
	TestSolutionList.class,
	TestSolutionList.class} )

public class TestHacs {


}
