package hacs;

import javax.swing.*;

import hacs.UserInfoItem.USER_TYPE;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

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

public class Login extends JDialog {

	private static final long serialVersionUID = 1L;
	boolean logout = false;
	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JButton loginButton = new JButton();
	JButton buttonExit = new JButton();
	JTextField userName = new JTextField();
	JPasswordField password = new JPasswordField();
	JRadioButton studentRadio = new JRadioButton();
	JRadioButton instructorRadio = new JRadioButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	private String userBox = null;
	private USER_TYPE userType = USER_TYPE.Student;

	public Login() {

		try {
			jbInit();
			setSize(300, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void jbInit() throws Exception {

		this.getContentPane().setLayout(null);
		jLabel1.setText("UserName");
		jLabel1.setBounds(new Rectangle(26, 52, 80, 18));
		jLabel2.setText("Password");
		jLabel2.setBounds(new Rectangle(23, 119, 80, 18));
		loginButton.setText("Login");
		loginButton.setBounds(new Rectangle(31, 212, 85, 28));
		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButtonActionPerformed(e);
			}
		});
		buttonExit.setText("Exit");
		buttonExit.setBounds(new Rectangle(180, 211, 97, 28));
		buttonExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonExitActionPerformed(e);
			}
		});
		userName.setBounds(new Rectangle(119, 52, 144, 22));
		password.setBounds(new Rectangle(118, 119, 147, 22));
		studentRadio.setSelected(true);
		studentRadio.setText("Student");
		studentRadio.setBounds(new Rectangle(37, 164, 103, 26));
		instructorRadio.setText("Instructor");
		instructorRadio.setBounds(new Rectangle(177, 162, 103, 26));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(jLabel2, null);
		this.getContentPane().add(loginButton, null);
		this.getContentPane().add(buttonExit, null);
		this.getContentPane().add(userName, null);
		this.getContentPane().add(password, null);
		this.getContentPane().add(studentRadio, null);
		this.getContentPane().add(instructorRadio, null);
		buttonGroup1.add(studentRadio);
		buttonGroup1.add(instructorRadio);

	}

	/*
	 * 
	 * This function check if login button action is performed or not
	 */
	void loginButtonActionPerformed(ActionEvent e) {

		BufferedReader file;
		logout = false;
		try {
			if (studentRadio.isSelected() == true) {
				userType = USER_TYPE.Student;
				file = new BufferedReader(new FileReader("StuInfo.txt"));
			} else {
				userType = USER_TYPE.Instructor;
				file = new BufferedReader(new FileReader("InsInfor.txt"));
			}
			userBox = userName.getText();
			String passwordBox = new String(password.getPassword());
			String loginName = null;
			String endOfLine = null, userName = null, password = null;
			while ((endOfLine = file.readLine()) != null) {

				userName = getUserName(endOfLine);
				password = getPassword(endOfLine);
				if (userName.compareTo(userBox) == 0 && password.compareTo(passwordBox) == 0)
					loginName = userName;

			}
			if (loginName != null) {

				this.setVisible(false);

			}
		} catch (Exception ee) {
			;
		}

	}

	/*
	 * get the user name from aline UserName:Password
	 */
	private String getUserName(String endOfLine) {

		int seperator = endOfLine.lastIndexOf(':');
		return endOfLine.substring(0, seperator);

	}

	/*
	 * get the password from aline UserName:Password
	 */
	private String getPassword(String endOfLine) {

		int seperator = endOfLine.lastIndexOf(':');
		return endOfLine.substring(seperator + 1, endOfLine.length());

	}

	/*
	 * after login get the UserName of the login interface
	 */
	public String getUserName() {

		return userBox;

	}

	/*
	 * after login get the userType of the login interface
	 */
	public USER_TYPE getUserType() {

		return userType;

	}

	/*
	 * after exit option get the login interface
	 */
	public boolean isExit() {

		return logout;

	}

	/*
	 * after clicking exit button action do logout true and set visibility to false
	 */
	void buttonExitActionPerformed(ActionEvent e) {

		logout = true;
		// If exit button action perfomed then setVisible(false) for exit button
		this.setVisible(false);

	}
}