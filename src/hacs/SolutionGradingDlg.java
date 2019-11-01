package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author Sarvansh Prasher
 * @version 2.0
 */

public class SolutionGradingDlg extends JDialog {

	private static final long serialVersionUID = 1L;
	Solution solution;
	JLabel jLabel1 = new JLabel();
	JTextField tfGrad = new JTextField();
	JButton buttonOK = new JButton();
	JLabel labelSolutionFileName = new JLabel();

	public SolutionGradingDlg() {
		
		try {
			jbInit();
			setSize(316, 186);
			setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void jbInit() throws Exception {
		
		jLabel1.setText("Solution File Name");
		jLabel1.setBounds(new Rectangle(23, 30, 121, 18));
		this.getContentPane().setLayout(null);
		tfGrad.setBounds(new Rectangle(25, 66, 100, 22));
		buttonOK.setText("OK");
		buttonOK.setBounds(new Rectangle(217, 67, 79, 29));
		buttonOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOkActionPerformed(e);
			}
		});
		labelSolutionFileName.setBounds(new Rectangle(212, 34, 163, 18));
		this.getContentPane().add(jLabel1, null);
		this.getContentPane().add(tfGrad, null);
		this.getContentPane().add(labelSolutionFileName, null);
		this.getContentPane().add(buttonOK, null);
		
	}
	
	/*
	 * This function shows solution
	 */
	void show(Solution solution) {

		tfGrad.setText("" + solution.getGradeInt());
		labelSolutionFileName.setText(solution.solutionFileName);
		// For showing solution grading and setting it to setVisible(true)
		setVisible(true);
		
	}
	/*
	 * This function checks if the Ok action button has been clicked or not
	 */
	void buttonOkActionPerformed(ActionEvent e) {
		
		solution.grade = Integer.parseInt(tfGrad.getText());
		// For showing solution grading and setting it to setVisible(true)
		setVisible(false);

	}

}