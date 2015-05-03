package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayWindow extends JFrame {
	//frame
	JFrame frame = new JFrame("Math & Computer Science Degree Course Monitor");
	//panels
	JPanel containerPanel = new JPanel();
	JPanel studentNamePanel = new JPanel();
	JPanel coursesTakenPanel = new JPanel();
	JPanel coursesNeededPanel = new JPanel();
	JPanel nextSemesterPanel = new JPanel();
	//buttons
	JButton getScheduleOptions = new JButton("Show Schedule Options");
	JButton submit = new JButton("Get Student");
	//labels
	JLabel label = new JLabel("A Label");
	JLabel coursesTakenLabel = new JLabel("Courses Taken");
	JLabel coursesNeededLabel = new JLabel("Courses Needed To Graduate");
	JLabel nextSemesterLabel = new JLabel("Classes You Can Take Next Semester");
	//constructor
	public DisplayWindow(){
		
		createGroupLayout();
		frame.pack();
		frame.setVisible(true);
	}
	
	//test function for MVP framework setup
	public void setText(String s){
		label.setText(s);
	}
	
	//Submit Button Listener
	public void addSubmitButtonActionListener(ActionListener listener){
		submit.addActionListener(listener);
	}
	
	
	private void createGroupLayout() {
		
		//set border layouts 
		containerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		studentNamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		coursesTakenPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		coursesNeededPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		nextSemesterPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//set background colors
		studentNamePanel.setBackground(Color.CYAN);
		coursesTakenPanel.setBackground(Color.magenta);
		containerPanel.setBackground(Color.green);

		//Student Name Panel Layout
		javax.swing.GroupLayout studentNamePanelLayout = new GroupLayout(studentNamePanel);
		studentNamePanel.setLayout(studentNamePanelLayout);
		studentNamePanelLayout.setAutoCreateGaps(true);
		studentNamePanelLayout.setAutoCreateContainerGaps(true);
		
		studentNamePanelLayout.setHorizontalGroup(studentNamePanelLayout
				.createSequentialGroup()
					.addComponent(label)
					.addComponent(submit));
		
		studentNamePanelLayout.setVerticalGroup(studentNamePanelLayout
				.createSequentialGroup()
					.addComponent(label)
					.addComponent(submit));
		
		//coursesTakenPanel layout
		javax.swing.GroupLayout coursesTakenpanelLayout = new GroupLayout(coursesTakenPanel);
		coursesTakenPanel.setPreferredSize(new Dimension(200, 400));
		coursesTakenPanel.setLayout(coursesTakenpanelLayout);
		
		coursesTakenpanelLayout.setAutoCreateContainerGaps(true);
		coursesTakenpanelLayout.setAutoCreateGaps(true);
		coursesTakenpanelLayout.setHorizontalGroup(coursesTakenpanelLayout
				.createSequentialGroup()
					.addComponent(coursesTakenLabel));
		coursesTakenpanelLayout.setVerticalGroup(coursesTakenpanelLayout
				.createSequentialGroup()
					.addComponent(coursesTakenLabel));
		
		//coursesNeededPanel layout
		javax.swing.GroupLayout coursesNeededPanelLayout = new GroupLayout(coursesNeededPanel);
		coursesNeededPanel.setPreferredSize(new Dimension(200, 400));
		coursesNeededPanel.setLayout(coursesNeededPanelLayout);
		
		coursesNeededPanelLayout.setAutoCreateContainerGaps(true);
		coursesNeededPanelLayout.setAutoCreateGaps(true);
		coursesNeededPanelLayout.setHorizontalGroup(coursesNeededPanelLayout
				.createSequentialGroup()
					.addComponent(coursesNeededLabel));
		coursesNeededPanelLayout.setVerticalGroup(coursesNeededPanelLayout
				.createSequentialGroup()
					.addComponent(coursesNeededLabel));
		
		//nextSemesterPanel layout
		javax.swing.GroupLayout nextSemesterPanelLayout = new GroupLayout(nextSemesterPanel);
		nextSemesterPanel.setPreferredSize(new Dimension(200, 400));
		nextSemesterPanel.setLayout(nextSemesterPanelLayout);
		
		nextSemesterPanelLayout.setAutoCreateContainerGaps(true);
		nextSemesterPanelLayout.setAutoCreateGaps(true);
		nextSemesterPanelLayout.setHorizontalGroup(nextSemesterPanelLayout
				.createSequentialGroup()
					.addComponent(nextSemesterLabel));
		nextSemesterPanelLayout.setVerticalGroup(nextSemesterPanelLayout
				.createSequentialGroup()
					.addComponent(nextSemesterLabel));

		//containerPanel layout
		javax.swing.GroupLayout containerPanelLayout = new GroupLayout(containerPanel);
		containerPanel.setLayout(containerPanelLayout);
		containerPanelLayout.setAutoCreateContainerGaps(true);
		containerPanelLayout.setAutoCreateGaps(true);
		containerPanelLayout.setHorizontalGroup(containerPanelLayout
				.createParallelGroup()
					.addComponent(studentNamePanel)
					.addComponent(coursesTakenPanel)
					.addComponent(coursesNeededPanel)
					.addComponent(nextSemesterPanel));
		containerPanelLayout.setVerticalGroup(containerPanelLayout
				.createSequentialGroup()
					.addComponent(studentNamePanel)
					.addComponent(coursesTakenPanel)
					.addComponent(coursesNeededPanel)
					.addComponent(nextSemesterPanel));
		//set panel sizes
		studentNamePanel.setPreferredSize(new Dimension(100, 400));
		
		containerPanel.setPreferredSize(new Dimension(400,600));	
		frame.add(containerPanel);
	}
}
