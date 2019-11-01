package testHacs;

/*
 * @author Sarvansh Prasher
 * @version 1.0
 * 
 * This is the script and we will go through this one by one.
 * 
 * (a). Login as Instructor 'inst1'.
 * (b). Choose CSE 890 and add a assignment with a due date.
 * (c). Login as Student 'stud1'.
 * (d). Choose CSE 890 and submit any solution to the assignment.
 * (e). Login as Instructor 'inst1'.
 * (f). Choose CSE 890 and view the assignment.
 * (g). Select stud1's submission and select grade.
 * (h). Enter a value into the grade box.
 * (i). Login again as Instructor 'inst1'.
 * (j). Choose CSE 880 add a assignment with a future due date.
 * (k). Login as Student 'stud2'.
 * (l). Choose CSE 880 and submit any solution to the assignment.
 * (m). You may now exit the application.
 *
 * This is how the working of application will happen.
*/

import hacs.Facade;
import hacs.Hacs;
import hacs.UserInfoItem;

public class Test {

public static void main(String[] args) {

        UserInfoItem userInfo = new UserInfoItem();
        Facade facade = new Facade();
        Hacs.facade = facade;
        facade.createCourseList();
        System.out.println("Creating course list is done");
        boolean userValid = false;
        while (!userValid) {
        	userValid = Facade.login(userInfo);
            if (!userValid) {
                facade.createUser(userInfo);
                facade.attachCourseToUser();
                facade.remind();
                facade.selectCourse();
                facade.courseOperation();
            }
        }
    }
}

