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
import javax.swing.JTextArea;

public class CoursePrereqPanel {
	JPanel coursePrereqPanel = new JPanel();
	ArrayList<String> courses = new ArrayList<String>();
	ArrayList<String> coursePrereq = new ArrayList<String>();
	JButton getCoursePrereqBtn = new JButton("Get Pre-reqs");
	JComboBox<String> courseListField = new JComboBox<String>();
	JTextArea coursePrereqField = new JTextArea();
	JLabel coursePrereqLabel = new JLabel("Course Pre-reqs");
	
	public CoursePrereqPanel(){
		setLayout();
		
	}
	public JPanel getPanel(){
		return coursePrereqPanel;
	}
	
	public void setCoursePrereq(ArrayList<String> s){
		coursePrereq = s;
		coursePrereqField.setText("");
		for(int i = 0; i<coursePrereq.size();i++){
			coursePrereqField.append(coursePrereq.get(i)+"  ");
			if(i%4 == 0 && i>3){
				coursePrereqField.append("\n");
			}
		}	
	}
	public String getCourseName(){
		return (String)courseListField.getSelectedItem();
	}
	
	public void setCourses(ArrayList<String> s){
		courses=s;
		for(int i = 0; i<courses.size();i++){
			courseListField.addItem(courses.get(i));
			
		}
	}
	public void addGetCoursePrereqButtonActionListener(ActionListener listener) {
		getCoursePrereqBtn.addActionListener(listener);
	}
	private void setLayout(){
		// coursePrereqPanel layout
		coursePrereqPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		coursePrereqPanel.setPreferredSize(new Dimension(480,60));
		coursePrereqPanel.setMaximumSize(new Dimension(480,60));
		coursePrereqField.setPreferredSize(new Dimension(200,60));
		coursePrereqField.setMaximumSize(new Dimension(200,60));
		courseListField.setPreferredSize(new Dimension(100,60));
		courseListField.setMaximumSize(new Dimension(100,60));
		javax.swing.GroupLayout coursePrereqPanelLayout = new GroupLayout(coursePrereqPanel);
		coursePrereqPanel.setLayout(coursePrereqPanelLayout);
		coursePrereqPanelLayout.setAutoCreateContainerGaps(true);
		coursePrereqPanelLayout.setAutoCreateGaps(true);
		coursePrereqPanelLayout.setHorizontalGroup(coursePrereqPanelLayout
				.createParallelGroup()
				.addComponent(coursePrereqLabel)
				.addGroup(coursePrereqPanelLayout
						.createSequentialGroup()
							.addComponent(coursePrereqField)
							.addComponent(courseListField)
							.addComponent(getCoursePrereqBtn)));
		coursePrereqPanelLayout.setVerticalGroup(coursePrereqPanelLayout
				.createSequentialGroup()
				.addComponent(coursePrereqLabel)
				.addGroup(coursePrereqPanelLayout
						.createParallelGroup()
							.addComponent(coursePrereqField)
							.addComponent(courseListField)
							.addComponent(getCoursePrereqBtn)));
	}

}
