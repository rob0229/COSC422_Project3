package frontend;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NextSemesterPanel {
	JPanel nextSemesterPanel = new JPanel();
	ArrayList<String> nextSemesterCourses = new ArrayList<String>();
	JTextArea nextSemesterField = new JTextArea();
	JLabel nextSemesterLabel = new JLabel("Courses You Can Take Next Semester");
	
	public NextSemesterPanel(){
		setLayout();
	}
	public JPanel getPanel(){
		return nextSemesterPanel;
	}
	private void setLayout(){
		// nextSemesterPanel layout
				nextSemesterPanel.setBorder(BorderFactory.createLineBorder(Color.black));
				javax.swing.GroupLayout nextSemesterPanelLayout = new GroupLayout(nextSemesterPanel);
				nextSemesterPanel.setLayout(nextSemesterPanelLayout);
				nextSemesterPanelLayout.setAutoCreateContainerGaps(true);
				nextSemesterPanelLayout.setAutoCreateGaps(true);
				nextSemesterPanelLayout.setHorizontalGroup(nextSemesterPanelLayout
						.createParallelGroup()
						.addComponent(nextSemesterLabel)
						.addComponent(nextSemesterField));
				nextSemesterPanelLayout.setVerticalGroup(nextSemesterPanelLayout
						.createSequentialGroup()
						.addComponent(nextSemesterLabel)
						.addComponent(nextSemesterField));
	}
	public void setNextSemesterCourses(ArrayList<String> s){
		nextSemesterCourses=s;
		nextSemesterField.setText("");
		for(int i = 0; i<nextSemesterCourses.size();i++){
			nextSemesterField.append(nextSemesterCourses.get(i)+"  ");
			if(i%4 == 0 && i>3){
				nextSemesterField.append("\n");
			}
		}
	}

}
