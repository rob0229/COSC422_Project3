package frontend;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AddTakenCoursePanel {
	JPanel addTakenCoursePanel = new JPanel();
	JButton addTakenCourseBtn = new JButton("Add Course");
	JTextArea addTakenCourseField = new JTextArea();
	JLabel addTakenCourseLabel = new JLabel("Add a Completed Course. (ex cosc422)");
	
	
	public AddTakenCoursePanel(){
		setLayout();
	}
	private void setLayout(){
		//addTakenCourse panel Layout
		addTakenCoursePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		javax.swing.GroupLayout addTakenCoursePanelLayout = new GroupLayout(addTakenCoursePanel);
		addTakenCoursePanel.setLayout(addTakenCoursePanelLayout);
		addTakenCoursePanelLayout.setAutoCreateGaps(true);
		addTakenCoursePanelLayout.setAutoCreateContainerGaps(true);
		addTakenCoursePanelLayout.setHorizontalGroup(addTakenCoursePanelLayout
				.createParallelGroup()
				.addComponent(addTakenCourseLabel)
				.addGroup(addTakenCoursePanelLayout
						.createSequentialGroup()
						.addComponent(addTakenCourseField)
						.addComponent(addTakenCourseBtn)));
		addTakenCoursePanelLayout.setVerticalGroup(addTakenCoursePanelLayout
				.createSequentialGroup()
				.addComponent(addTakenCourseLabel)
				.addGroup(addTakenCoursePanelLayout
						.createParallelGroup()
						.addComponent(addTakenCourseField)
						.addComponent(addTakenCourseBtn)));
		
	}
	public JPanel getPanel(){
		return addTakenCoursePanel;
	}
}
