package frontend;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MultiSemesterPanel {
	ArrayList<String> multiSemesterCourses = new ArrayList<String>();
	JPanel multiSemesterPanel = new JPanel();
	JTextArea multiSemesterField = new JTextArea();
	JLabel multiSemesterLabel = new JLabel("Multi-Semester Plan");
	JButton exportMultiPlanBtn = new JButton("Export Degree Plan");
	
	public MultiSemesterPanel(){
		setLayout();
		
	}
	public JPanel getPanel(){
		return multiSemesterPanel;
	}
	public void setLayout(){
		//Multi semester Panel Layout
		multiSemesterPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		javax.swing.GroupLayout multiSemesterPanelLayout = new GroupLayout(multiSemesterPanel);
		multiSemesterPanel.setLayout(multiSemesterPanelLayout);
		multiSemesterPanelLayout.setAutoCreateContainerGaps(true);
		multiSemesterPanelLayout.setAutoCreateGaps(true);
		multiSemesterPanelLayout.setHorizontalGroup(multiSemesterPanelLayout
				.createParallelGroup()
				.addComponent(multiSemesterLabel)
				.addGroup(multiSemesterPanelLayout.createSequentialGroup()
				.addComponent(multiSemesterField)
				.addComponent(exportMultiPlanBtn)));
		multiSemesterPanelLayout.setVerticalGroup(multiSemesterPanelLayout
				.createSequentialGroup()
				.addComponent(multiSemesterLabel).addGroup(multiSemesterPanelLayout
						.createParallelGroup()
				.addComponent(multiSemesterField)
				.addComponent(exportMultiPlanBtn)));	
	}
	
	public void setMultiSemesterCourses(ArrayList<String> s){
		multiSemesterCourses = s;
		multiSemesterField.setText("Next semester: ");
		for(int i = 0; i<multiSemesterCourses.size();i++){
			multiSemesterField.append(multiSemesterCourses.get(i)+"  ");
			if((i+1)%3 == 0 && i>=2 && i != s.size() - 1){
				multiSemesterField.append("\nNext semester: ");
			}
		}
	}
}
