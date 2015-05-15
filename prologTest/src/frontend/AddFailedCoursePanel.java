package frontend;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AddFailedCoursePanel {
	JPanel addFailedCoursePanel = new JPanel();
	JButton addFailedCourseBtn = new JButton("Add Failed Course");
	JTextArea addFailedCourseField = new JTextArea();
	JLabel addFailedCourseLabel = new JLabel("Add a Failed Course. (ex cosc450)");
	
	public AddFailedCoursePanel(){
		setLayout();
	}
	private void setLayout(){
		//addFailedCourse panel Layout
		addFailedCoursePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		javax.swing.GroupLayout addFailedCoursePanelLayout = new GroupLayout(addFailedCoursePanel);
		addFailedCoursePanel.setLayout(addFailedCoursePanelLayout);
		addFailedCoursePanelLayout.setAutoCreateGaps(true);
		addFailedCoursePanelLayout.setAutoCreateContainerGaps(true);
		addFailedCoursePanelLayout.setHorizontalGroup(addFailedCoursePanelLayout
				.createParallelGroup()
				.addComponent(addFailedCourseLabel)
				.addGroup(addFailedCoursePanelLayout
						.createSequentialGroup()
						.addComponent(addFailedCourseField)
						.addComponent(addFailedCourseBtn)));
		addFailedCoursePanelLayout.setVerticalGroup(addFailedCoursePanelLayout
				.createSequentialGroup()
				.addComponent(addFailedCourseLabel)
				.addGroup(addFailedCoursePanelLayout
						.createParallelGroup()
						.addComponent(addFailedCourseField)
						.addComponent(addFailedCourseBtn)));
	}
	public JPanel getPanel(){
		return addFailedCoursePanel;
	}

}
