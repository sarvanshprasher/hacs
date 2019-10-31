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
 * 
 *    
 */

public class UserInfoItem {

	public enum USER_TYPE {
		Student, Instructor
	}

	String strUserName;
	private UserType userType;
	USER_TYPE UserType; // 0 : Student, 1: Instructor

	public String getUsername() {

		return strUserName;

	}

	public void setUsername(String username) {

		this.strUserName = username;

	}

	public UserType getUserType() {
		
		return userType;
		
	}

	public void setUserType(UserType userType) {
		
		this.userType = userType;
		
	}
}