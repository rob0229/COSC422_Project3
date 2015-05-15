package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudentNamePanel {
	JPanel studentNamePanel = new JPanel();
	JLabel currentStudentLabel = new JLabel("Current Student");
	JButton getStudentBtn = new JButton("Get Student");
	JComboBox<String> studentNameField = new JComboBox<String>();

	public StudentNamePanel(){
		setLayout();
	}
	public void addStudentNames(String s){
		studentNameField.addItem(s);
	}
	public String getStudentName(){
		return (String) studentNameField.getSelectedItem();
	}
	public void addStudentButtonActionListener(ActionListener listener) {
		getStudentBtn.addActionListener(listener);
	}
	
	public JPanel getPanel(){
		return studentNamePanel;
	}
	public void setAllCoursesText(ArrayList<String> s){
		
	}

	private void setLayout(){
	// Student Name Panel Layout
	studentNamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
	studentNamePanel.setMaximumSize(new Dimension(400,60));
	studentNamePanel.setPreferredSize(new Dimension(350, 60));
	javax.swing.GroupLayout studentNamePanelLayout = new GroupLayout(studentNamePanel);
	
	studentNamePanel.setLayout(studentNamePanelLayout);
	studentNamePanelLayout.setAutoCreateGaps(true);
	studentNamePanelLayout.setAutoCreateContainerGaps(true);

	studentNamePanelLayout.setHorizontalGroup(studentNamePanelLayout
			.createParallelGroup()
			.addComponent(currentStudentLabel)
			.addGroup(studentNamePanelLayout
					.createSequentialGroup()
					.addComponent(studentNameField)
					.addComponent(getStudentBtn)));

	studentNamePanelLayout.setVerticalGroup(studentNamePanelLayout
			.createSequentialGroup()
				.addGroup(studentNamePanelLayout.createSequentialGroup()
					.addComponent(currentStudentLabel))
					.addGroup(studentNamePanelLayout
							.createParallelGroup()
							.addComponent(studentNameField)
							.addComponent(getStudentBtn)));
		}
	
}
