package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CurrentSemesterPanel {
	JPanel currentSemesterPanel = new JPanel();
	JComboBox<String> semesterField = new JComboBox<String>();
	JLabel semesterLabel = new JLabel("Current Semester");
	
	public CurrentSemesterPanel() {
		semesterField.addItem("Spring Even");
		semesterField.addItem("Fall Even");
		semesterField.addItem("Spring Odd");
		semesterField.addItem("Fall Odd");
		setLayout();
		
	}

	public JPanel getPanel(){
		return currentSemesterPanel;
	}
	public String getCurrentSemester() {
		return (String)semesterField.getSelectedItem();
	}
	
	private void setLayout(){
		//semester panel layout
		currentSemesterPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		currentSemesterPanel.setMaximumSize(new Dimension(400, 60));
		currentSemesterPanel.setPreferredSize(new Dimension(350, 60));
		javax.swing.GroupLayout semesterPanelLayout = new GroupLayout(currentSemesterPanel);
		currentSemesterPanel.setLayout(semesterPanelLayout);
		semesterPanelLayout.setAutoCreateGaps(true);
		semesterPanelLayout.setAutoCreateContainerGaps(true);
		
		semesterPanelLayout.setHorizontalGroup(semesterPanelLayout
				.createParallelGroup()
				.addComponent(semesterLabel)
				.addComponent(semesterField));
		
		semesterPanelLayout.setVerticalGroup(semesterPanelLayout
				.createSequentialGroup()
				.addComponent(semesterLabel)
				.addComponent(semesterField));
	}
	
	
}
