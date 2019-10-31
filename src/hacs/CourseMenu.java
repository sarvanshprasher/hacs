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
 */

abstract public class CourseMenu extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Course theCourse;
	boolean bLogout = true;

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

	public CourseMenu() {

		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setModal(true);
		setSize(503, 294);
	}

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

	void assignmentAddButtonActionPerformed(ActionEvent e) {
		Hacs.theFacade.addAssignment(theCourse);
		refresh();
	}

	void assignmentViewButtonActionPerformed(ActionEvent e) {
		Assignment theAss = (Assignment) assignmentCombox.getSelectedItem();
		Hacs.theFacade.viewAssignment(theAss);
	}

	void refresh() {
		assignmentCombox.removeAllItems();
		Iterator<Assignment> Iter = theCourse.assignmentList.iterator();
		while (Iter.hasNext()) {
			assignmentCombox.addItem(Iter.next());
		}
	}

	
	// Changed the hide function to setVisible(false) when change course action is performed.
	void buttonChangeCourseActionPerformed(ActionEvent e) {
		bLogout = false;
		setVisible(false);
	}

	// Changed the hide function to setVisible(false) when logout action is performed
	void buttonLogoutActionPerformed(ActionEvent e) {
		bLogout = true;
		setVisible(false);
	}

	boolean ifLogout() {
		return bLogout;
	}
}