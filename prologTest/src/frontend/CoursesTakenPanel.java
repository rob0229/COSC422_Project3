package frontend;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CoursesTakenPanel {
	ArrayList<String> coursesTaken = new ArrayList<String>();
	JPanel coursesTakenPanel = new JPanel();
	JTextArea coursesTakenField = new JTextArea();
	JLabel coursesTakenLabel = new JLabel("Courses Taken");
	
	public CoursesTakenPanel(){
		setLayout();
	}
	public JPanel getPanel(){
		return coursesTakenPanel;
	}
	public void setCoursesTaken(ArrayList<String> s) {
		coursesTaken = s;
		coursesTakenField.setText("");
		for(int i = 0; i<coursesTaken.size();i++){
			coursesTakenField.append(coursesTaken.get(i)+"  ");
			if(i%4 == 0 && i>3){
				coursesTakenField.append("\n");
			}
		}
	}
	
	private void setLayout(){
		// coursesTakenPanel layout
		coursesTakenPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		javax.swing.GroupLayout coursesTakenpanelLayout = new GroupLayout(coursesTakenPanel);
		coursesTakenPanel.setLayout(coursesTakenpanelLayout);
		coursesTakenpanelLayout.setAutoCreateContainerGaps(true);
		coursesTakenpanelLayout.setAutoCreateGaps(true);
		coursesTakenpanelLayout.setHorizontalGroup(coursesTakenpanelLayout
				.createParallelGroup()
				.addComponent(coursesTakenLabel)
				.addComponent(coursesTakenField));
		coursesTakenpanelLayout.setVerticalGroup(coursesTakenpanelLayout
				.createSequentialGroup()
				.addComponent(coursesTakenLabel)
				.addComponent(coursesTakenField));
		
	}

}
