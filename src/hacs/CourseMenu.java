package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sarvansh Prasher
 * @version 2.0
 */

abstract public class CourseMenu extends JDialog {

	private static final long serialVersionUID = 1L;
	Course course;
	boolean logout = true;

	JRadioButton assignmentRadiao = new JRadioButton();
	JComboBox<Assignment> assignmentCombox = new JComboBox<Assignment>();
	JButton assignmentViewButton = new JButton();
	JButton assignmentAddButton = new JButton();
	JRadioButton optionRadio = new JRadioButton();
	JLabel assignmentContentLable = new JLabel();
	@SuppressWarnings("rawtypes")
	JComboBox optionCombo = new JComboBox();
	JButton optionViewButton = new JButton();
	JButton optionAddButton = new JButton();
	JButton buttonChangeCourse = new JButton();
	JButton buttonLogout = new JButton();

	/*
	 * This function constructs the course menu object
	 */
	public CourseMenu() {

		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setModal(true);
		setSize(503, 294);

	}

	/*
	 * This function calls the jbInit swing menu object
	 */
	private void jbInit() throws Exception {

		buttonChangeCourse.setText("ChangeCourse");
		buttonChangeCourse.setBounds(new Rectangle(101, 211, 73, 37));
		buttonChangeCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChangeCourseActionPerformed(e);
			}
		});
		this.getContentPane().setLayout(null);
		this.setTitle("");
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogoutActionPerformed(e);
			}
		});
		this.getContentPane().add(buttonChangeCourse, null);
		this.getContentPane().add(buttonLogout, null);

	}

	/*
	 * when the add button is pressed, call add assignment function of facade, after
	 * that refresh window
	 */

	/*
	 * when the add button is pressed, call ViewAssignment function of facade, after
	 * that refresh window
	 */

	abstract void showMenu(Course theCourse);

	abstract void showAddButtons();

	abstract void showViewButtons();

	abstract void showRadios();

	abstract void showComboxes();

	abstract void showLabel();

	/*
	 * When assignment add action button is cliced, we pass ActionEvent to perform
	 * action
	 */
	void assignmentAddButtonActionPerformed(ActionEvent e) {

		Hacs.Facade.addAssignment(course);
		refresh();

	}

	/*
	 * When assignment view action button is cliced, we pass ActionEvent to perform
	 * action
	 */
	void assignmentViewButtonActionPerformed(ActionEvent e) {

		Assignment theAss = (Assignment) assignmentCombox.getSelectedItem();
		Hacs.Facade.viewAssignment(theAss);

	}

	/*
	 * Refresh method while generating course menu
	 */
	void refresh() {

		assignmentCombox.removeAllItems();
		Iterator<Assignment> Iter = course.assignmentList.iterator();
		while (Iter.hasNext()) {

			assignmentCombox.addItem(Iter.next());

		}

	}

	/*
	 * Changed the hide function to setVisible(false) when change course action is
	 * performed
	 */
	void buttonChangeCourseActionPerformed(ActionEvent e) {

		logout = false;
		setVisible(false);

	}

	/*
	 * Changed the hide function to setVisible(false) when logout action is
	 * performed
	 */
	void buttonLogoutActionPerformed(ActionEvent e) {

		logout = true;
		setVisible(false);

	}

	boolean ifLogout() {

		return logout;

	}
}