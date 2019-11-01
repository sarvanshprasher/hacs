package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sarvansh Prasher
 * @version 2.0
 */

public class InstructorAssignmentMenu extends AssignmentMenu {

	private static final long serialVersionUID = 1L;
	private SolutionList solution;
	private Assignment assignment;
	JComboBox<SolutionList> solutionList = new JComboBox<SolutionList>();

	JTextField assignmentName = new JTextField();
	JTextField dueDate = new JTextField();
	JTextField suggestedSolution = new JTextField();

	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JButton buttonGrade = new JButton();
	JButton buttonReport = new JButton();
	JButton buttonClose = new JButton();

	public InstructorAssignmentMenu() {

		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void jbInit() throws Exception {

		label1.setText("Assignment Name");
		label1.setBounds(new Rectangle(25, 31, 118, 18));
		this.getContentPane().setLayout(null);
		assignmentName.setText("jTextField1");
		assignmentName.setBounds(new Rectangle(192, 31, 341, 22));
		label2.setText("Due Date");
		label2.setBounds(new Rectangle(28, 90, 113, 18));
		dueDate.setText("tbDueDate");
		dueDate.setBounds(new Rectangle(195, 87, 337, 22));
		label3.setText("Suggested Solution");
		label3.setBounds(new Rectangle(28, 151, 118, 18));
		suggestedSolution.setText("jTextField2");
		suggestedSolution.setBounds(new Rectangle(197, 149, 339, 22));
		buttonGrade.setText("Grade");
		buttonGrade.setBounds(new Rectangle(458, 199, 79, 29));
		buttonGrade.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGradeActionPerformed(e);
			}
		});
		buttonReport.setText("Report");
		buttonReport.setBounds(new Rectangle(365, 249, 79, 29));
		buttonReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonReportActionPerformed(e);
			}
		});
		buttonClose.setText("Close");
		buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
		buttonClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonCloseActionPerformed(e);
			}
		});
		solutionList.setBounds(new Rectangle(32, 204, 413, 22));
		this.getContentPane().add(label1, null);
		this.getContentPane().add(assignmentName, null);
		this.getContentPane().add(label2, null);
		this.getContentPane().add(dueDate, null);
		this.getContentPane().add(label3, null);
		this.getContentPane().add(suggestedSolution, null);
		this.getContentPane().add(buttonClose, null);
		this.getContentPane().add(solutionList, null);
		this.getContentPane().add(buttonGrade, null);
		this.getContentPane().add(buttonReport, null);

	}

	/*
	 * 
	 * This function shows the menu to a person for the assignment
	 */
	public void showMenu(Assignment assignment, Person person) {

		assignmentName.setText(assignment.assignmentName);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		dueDate.setText(dateFormat.format(assignment.dueDate));
		suggestedSolution.setText(assignment.suggestSolution.solutionFileName);
		refreshSolutionList();
		// Added setVisible(true) to make showMenu visible.
		setVisible(true);

	}

	/*
	 * 
	 * This function performs the action of closing the assignment after due date is
	 * passed
	 */
	void buttonCloseActionPerformed(ActionEvent e) {

		assignment.assignmentName = assignmentName.getText();
		DateFormat tempDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		try {
			assignment.dueDate = tempDateFormat.parse(dueDate.getText());
		} catch (Exception ee) {
		}
		assignment.suggestSolution.solutionFileName = suggestedSolution.getText();
		// Added setVisible(true) to make showMenu visible.
		setVisible(false);

	}

	/*
	 * 
	 * This function grades the solution
	 */
	void buttonGradeActionPerformed(ActionEvent e) {

		Solution solution = (Solution) solutionList.getSelectedItem();
		if (solution == null)
			return;
		SolutionGradingDlg dialog = new SolutionGradingDlg();
		dialog.show(solution);
		refreshSolutionList();

	}

	/*
	 * 
	 * This function reports the solution involved in any assignment
	 */
	void buttonReportActionPerformed(ActionEvent e) {

		SolutionIterator iter = new SolutionIterator(assignment.solutionList);
		while (iter.hasNext()) {
			Solution asolution = (Solution) iter.next();
			asolution.setReported(true);
		}
		refreshSolutionList();

	}

	/*
	 * 
	 * This function refreshes the solution list
	 */
	private void refreshSolutionList() {

		solutionList.removeAllItems();
		SolutionIterator solutionIterator = new SolutionIterator(assignment.solutionList);
		while (solutionIterator.hasNext()) {
			solution = (SolutionList) solutionIterator.next();
			solutionList.addItem(solution);

		}
	}
}