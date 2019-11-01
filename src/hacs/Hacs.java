package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0
 * @author Sarvansh Prasher
 * @version 3.0
 */

public class Hacs {

	static Facade Facade = new Facade();
	public static Facade facade;

	public Hacs() {
	}

	/*
	 * Main method for checking if user is able to login and perform the tasks
	 * related to a particular course.
	 */
	public static void main(String[] args) {

		UserInfoItem userinfoitem = new UserInfoItem();
		Facade.createCourseList();
		while (true) {
			boolean logout = false;
			logout = hacs.Facade.login(userinfoitem);
			if (logout)
				break;
			Facade.createUser(userinfoitem);
			Facade.attachCourseToUser();
			if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Student)
				Facade.remind();
			boolean bLogout = false;
			while (!bLogout) {
				bLogout = Facade.selectCourse();
				if (bLogout)
					break;
				bLogout = Facade.courseOperation();
			}
		}

	}
}