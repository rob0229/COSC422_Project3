package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ModifyRequiredCoursePanel {
	JPanel modifyRequiredCoursePanel = new JPanel();
	JButton addRequiredCourseBtn = new JButton("Add Course");
	JButton removeRequiredCourseBtn = new JButton("Remove Course");
	JTextArea modifyRequiredCourseField = new JTextArea();
	JLabel modifyRequiredCoursesLabel = new JLabel("Add/Remove Required Courses");
	
	public ModifyRequiredCoursePanel(){
		setLayout();
		
	}
	public void addRequiredCourseButtonActionListener(ActionListener listener) {
		addRequiredCourseBtn.addActionListener(listener);
	}
	public void removeRequiredCourseButtonActionListener(ActionListener listener) {
		removeRequiredCourseBtn.addActionListener(listener);
	}
	private void setLayout(){
		//modifyRequiredPanel layout
				modifyRequiredCoursePanel.setBorder(BorderFactory.createLineBorder(Color.black));
				modifyRequiredCourseField.setPreferredSize(new Dimension(480, 120));
				modifyRequiredCourseField.setMaximumSize(new Dimension(480, 120));
				javax.swing.GroupLayout modifyRequiredPanelLayout = new GroupLayout(modifyRequiredCoursePanel);
				modifyRequiredCoursePanel.setLayout(modifyRequiredPanelLayout);
				modifyRequiredPanelLayout.setAutoCreateContainerGaps(true);
				modifyRequiredPanelLayout.setAutoCreateGaps(true);
				modifyRequiredPanelLayout.setHorizontalGroup(modifyRequiredPanelLayout
						.createParallelGroup()
						.addComponent(modifyRequiredCoursesLabel)
						.addGroup(modifyRequiredPanelLayout
								.createSequentialGroup()
								.addComponent(modifyRequiredCourseField)
								.addComponent(addRequiredCourseBtn)
								.addComponent(removeRequiredCourseBtn)));
				modifyRequiredPanelLayout.setVerticalGroup(modifyRequiredPanelLayout
						.createSequentialGroup()
						.addComponent(modifyRequiredCoursesLabel)
						.addGroup(modifyRequiredPanelLayout
								.createParallelGroup()
								.addComponent(modifyRequiredCourseField)
								.addComponent(addRequiredCourseBtn)
								.addComponent(removeRequiredCourseBtn)));
	}
	public JPanel getPanel(){
		return modifyRequiredCoursePanel;
	}

}
