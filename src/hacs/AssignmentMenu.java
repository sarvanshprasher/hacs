package hacs;

import javax.swing.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sarvansh Prasher
 * @version 2.0
 */

abstract public class AssignmentMenu extends JDialog {

	private static final long serialVersionUID = 1L;

	abstract void showMenu(Assignment assignment, Person person);

	/*
	 * This function gets the assignment menu and sets the modal and size.
	 */
	public AssignmentMenu() {
		
		setModal(true);
		setSize(575, 330);
		
	}
}