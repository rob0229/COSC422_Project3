package frontend;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CoursesNeededPanel {
	ArrayList<String> coursesNeeded = new ArrayList<String>();
	JPanel coursesNeededPanel = new JPanel();
	JTextArea coursesNeededField = new JTextArea();
	JLabel coursesNeededLabel = new JLabel("Courses Needed To Graduate");
	
	public CoursesNeededPanel(){
		setLayout();
	}
	public JPanel getPanel(){
		return coursesNeededPanel;
	}
	public void setLayout(){
		// coursesNeededPanel layout
		coursesNeededPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		javax.swing.GroupLayout coursesNeededPanelLayout = new GroupLayout(coursesNeededPanel);
		coursesNeededPanel.setLayout(coursesNeededPanelLayout);
		coursesNeededPanelLayout.setAutoCreateContainerGaps(true);
		coursesNeededPanelLayout.setAutoCreateGaps(true);
		coursesNeededPanelLayout.setHorizontalGroup(coursesNeededPanelLayout
				.createParallelGroup()
				.addComponent(coursesNeededLabel)
				.addComponent(coursesNeededField));
		coursesNeededPanelLayout.setVerticalGroup(coursesNeededPanelLayout
				.createSequentialGroup()
				.addComponent(coursesNeededLabel)
				.addComponent(coursesNeededField));
		
	}
	public void setCoursesNeeded(ArrayList<String> requirements, ArrayList<String> electives, int numneeded, ArrayList<String> researchElectives){
		if (requirements.isEmpty() && numneeded == 0) {
				coursesNeededField.setText("You're done!");
				return;
		}
		
		coursesNeeded = requirements;
		coursesNeededField.setText("Required:\n");
		for(int i = 0; i<coursesNeeded.size();i++){
			coursesNeededField.append(coursesNeeded.get(i)+"  ");
			if(i%4 == 0 && i>3){
				coursesNeededField.append("\n");
			}
		}
		
		if (numneeded == 0) {
			return;
		}

		coursesNeededField.append("\n\n" + numneeded + " courses of:\n");
		coursesNeeded = electives;
		for(int i = 0; i<coursesNeeded.size();i++){
			coursesNeededField.append(coursesNeeded.get(i)+"  ");
			if(i%4 == 0 && i>3){
				coursesNeededField.append("\n");
			}
		}
		
		if (researchElectives != null) {
			coursesNeededField.append("\n[ One of: ");
			coursesNeeded = researchElectives;
			for(int i = 0; i<coursesNeeded.size();i++){
				coursesNeededField.append(coursesNeeded.get(i)+"  ");
				if(i%4 == 0 && i>3){
					coursesNeededField.append("\n");
				}
			}
			coursesNeededField.append("]");
		}
	}

}
