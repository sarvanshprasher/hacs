package testHacs;

/*
 * @author Sarvansh Prasher
 * @version 1.0
 * Script .
 *
 * This class is test class and tests the whole application:
 * 1. Login as Instructor 'Inst1'.
 * 2. Choose CSE 870 and low level and add a assignment with a future due date.
 * 3. Login again as Instructor 'Inst1'.
 * 4. Choose CSE880 and high level and add a assignment with a past due date.
 * 5. Login as Student 'pepe'.
 * 6. Choose CSE 870 and low level and submit any solution to the assignment.
 * 7. Login again as Student 'pepe'.
 * 8. Choose CSE 880 and high level and submit any solution to the assignment.
 * 9. Login as Instructor 'Inst1'.
 * 10. Choose CSE 870 and low level and view the assignment.
 * 11. Select pepe's submission and select grade.
 * 12. Enter a string into the grade box and click ok.
 * 13. Change the grade to an integer and click ok.
 * 14. Login again as Instructor 'Inst1'.
 * 15. Choose CSE 880 and high level and view the assignment.
 * 16. Select pepe's submission and select grade.
 * 12. Enter an integer into the grade box and click ok.
 * 13. You may now exit the application.
 *
 * This should result in roughly 82% method coverage and 84% line coverage
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

