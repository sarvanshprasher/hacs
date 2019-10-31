package testHacs;

/*
* @author Sarvansh Prasher
* @version 1.0
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.Facade;
import hacs.Person;
import hacs.UserInfoItem;
import hacs.UserType;

public class TestFacade {

	
    @Test
    void testCreateUser() {
    	
        Facade facade = new Facade();
        UserInfoItem userInfo = new UserInfoItem();
        String userName = "Inst1";
        UserType userType = UserType.Student;
        userInfo.setUsername(userName);
        userInfo.setUserType(userType);
        facade.createUser(userInfo);
        assertEquals(userName, userInfo.getUsername());
        assertEquals(userType, userInfo.getUserType());
        
    }
	

    @Test
    void createCourseListTest() {
    	
        Facade facade = new Facade();
        facade.createCourseList();
        ClassCourseList courses = facade.getCourses();
        String course1 = "CSE870";
        String courseName = courses.findCourseByCourseName(course1).toString();
        assertEquals(course1, courseName);
        
    }
    

    @Test
    void attachCourseToUserTest() {
    	
        Facade facade = new Facade();
        UserInfoItem userInfo = new UserInfoItem();
        String username = "Inst1";
        UserType userType = UserType.Student;
        userInfo.setUsername(username);
        userInfo.setUserType(userType);
        facade.createUser(userInfo);
        facade.createCourseList();
        facade.attachCourseToUser();
        Person person = facade.getPerson();
        String course = "CSE870";
        String courseName = person.getCourseList().findCourseByCourseName(course).toString();
        assertEquals(course, courseName);
        
        
    }
    
    

}
