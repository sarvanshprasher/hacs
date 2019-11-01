package hacs;

/*
 * @author Sarvansh Prasher
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;

public class HighLevelCourseMenu extends CourseMenu {

	/*
	 * JButton AssignmentAddButton = new JButton(); JRadioButton OptionRadio = new
	 * JRadioButton(); JComboBox OptionCombo = new JComboBox(); JButton
	 * OptionViewButton = new JButton(); JButton OptionAddButton = new JButton();
	 */
	private static final long serialVersionUID = 1L;

	public HighLevelCourseMenu() {
	}

	/*
	 * This method is for showing the menu in the course.
	 */
	void showMenu(Course course) {

		showViewButtons();
		showRadios();
		showComboxes();
		// Made show() option to setVisible(true) when show menu is clicked for courses.
		setVisible(true);

	}

	/*
	 * This method is for showing the add buttons in the course.
	 */
	void showAddButtons() {

		assignmentAddButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignmentAddButtonActionPerformed(e);
			}
		});
		assignmentAddButton.setText("Add");
		assignmentAddButton.setBounds(new Rectangle(389, 54, 79, 29));
		optionAddButton.setText("Add");
		optionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
		this.getContentPane().add(assignmentAddButton, null);
		this.getContentPane().add(optionAddButton, null);

	}

	/*
	 * This method is for showing the radio buttons in the course.
	 */
	void showRadios() {

		assignmentRadiao.setText("Assignment");
		assignmentRadiao.setBounds(new Rectangle(21, 55, 103, 26));
		this.getContentPane().add(assignmentRadiao, null);
		optionRadio.setText("HighLevel Presentation");
		optionRadio.setBounds(new Rectangle(21, 128, 103, 26));
		this.getContentPane().add(optionRadio, null);

	}

	/*
	 * This method is for showing the comboxes buttons in the course.
	 */
	void showComboxes() {

		assignmentCombox.setBounds(new Rectangle(140, 57, 126, 22));
		optionCombo.setBounds(new Rectangle(137, 127, 126, 22));
		this.getContentPane().add(assignmentCombox, null);
		this.getContentPane().add(optionCombo, null);
		refresh();

	}

	/*
	 * This method is for showing the view buttons in the course.
	 */
	void showViewButtons() {

		assignmentViewButton.setText("View");
		assignmentViewButton.setBounds(new Rectangle(290, 54, 79, 29));
		assignmentViewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assignmentViewButtonActionPerformed(e);
			}
		});
		optionViewButton.setText("View");
		optionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
		this.getContentPane().add(assignmentViewButton, null);
		this.getContentPane().add(optionViewButton, null);

	}

	/*
	 * This method is for showing the view labels in the course.
	 */
	void showLabel() {

		assignmentContentLable.setText("AssigmentContent");
		assignmentContentLable.setBounds(new Rectangle(23, 186, 432, 99));
		this.getContentPane().add(assignmentContentLable, null);

	}
}