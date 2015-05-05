package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class DisplayWindow extends JFrame {
	//Data Variables
	ArrayList<String> coursesTaken = new ArrayList<String>();
	ArrayList<String> coursesNeeded = new ArrayList<String>();
	ArrayList<String> studentNames = new ArrayList<String>();
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
	//text fields
	JComboBox<String> studentNameField = new JComboBox<String>();
	JTextArea coursesTakenField = new JTextArea();
	JTextArea coursesNeededField = new JTextArea();
	//labels
	JLabel coursesTakenLabel = new JLabel("Courses Taken");
	JLabel coursesNeededLabel = new JLabel("Courses Needed To Graduate");
	JLabel nextSemesterLabel = new JLabel("Classes You Can Take Next Semester");
	

	// constructor
	public DisplayWindow() {
		createGroupLayout();
		studentNameField.setPreferredSize(new Dimension(50, 30));
		containerPanel.setPreferredSize(new Dimension(400, 600));
		setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void addStudentNames(String s){
		studentNameField.addItem(s);
	}

	public void setCoursesTaken(ArrayList<String> s) {
		coursesTaken = s;
		addCoursesTakenToPanel();
	}
	
	public void setCoursesNeeded(ArrayList<String> s){
		coursesNeeded=s;
		addCoursesNeededToPanel();
	}
	
	public String getStudentName(){
		return (String) studentNameField.getSelectedItem();
	}
	
	
	private void addCoursesNeededToPanel() {
		coursesNeededField.setText("");
		for(int i = 0; i<coursesNeeded.size();i++){
			coursesNeededField.append(coursesNeeded.get(i)+"  ");
			if(i%4 == 0 && i>3){
				coursesNeededField.append("\n");
			}
		}
	}

	//appends the coursesTakenField with all the items in the coursesTaken Array
	public void addCoursesTakenToPanel(){
		coursesTakenField.setText("");
		for(int i = 0; i<coursesTaken.size();i++){
			coursesTakenField.append(coursesTaken.get(i)+"  ");
			if(i%4 == 0 && i>3){
				coursesTakenField.append("\n");
			}
		}
	}

	// Submit Button Listener
	public void addSubmitButtonActionListener(ActionListener listener) {
		submit.addActionListener(listener);
	}

	private void createGroupLayout() {
		
		// set border layouts
		containerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		studentNamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		coursesTakenPanel
				.setBorder(BorderFactory.createLineBorder(Color.black));
		coursesNeededPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));
		nextSemesterPanel
				.setBorder(BorderFactory.createLineBorder(Color.black));

		// set background colors
		studentNamePanel.setBackground(Color.CYAN);
		coursesTakenPanel.setBackground(Color.magenta);
		containerPanel.setBackground(Color.green);

		// Student Name Panel Layout
		javax.swing.GroupLayout studentNamePanelLayout = new GroupLayout(
				studentNamePanel);
		
		studentNamePanel.setLayout(studentNamePanelLayout);
		studentNamePanelLayout.setAutoCreateGaps(true);
		studentNamePanelLayout.setAutoCreateContainerGaps(true);

		studentNamePanelLayout.setHorizontalGroup(studentNamePanelLayout
				.createSequentialGroup()
				.addComponent(studentNameField)
				.addComponent(submit));

		studentNamePanelLayout.setVerticalGroup(studentNamePanelLayout
				.createParallelGroup()
				.addComponent(studentNameField)
				.addComponent(submit));

		// coursesTakenPanel layout
		javax.swing.GroupLayout coursesTakenpanelLayout = new GroupLayout(
				coursesTakenPanel);
		//coursesTakenPanel.setPreferredSize(new Dimension(500, 200));
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

		// coursesNeededPanel layout
		javax.swing.GroupLayout coursesNeededPanelLayout = new GroupLayout(
				coursesNeededPanel);
		//coursesNeededPanel.setPreferredSize(new Dimension(200, 400));
		coursesNeededPanel.setLayout(coursesNeededPanelLayout);

		coursesNeededPanelLayout.setAutoCreateContainerGaps(true);
		coursesNeededPanelLayout.setAutoCreateGaps(true);
		coursesNeededPanelLayout.setHorizontalGroup(coursesNeededPanelLayout
				.createParallelGroup().addComponent(coursesNeededLabel)
				.addComponent(coursesNeededField));
		coursesNeededPanelLayout.setVerticalGroup(coursesNeededPanelLayout
				.createSequentialGroup().addComponent(coursesNeededLabel)
				.addComponent(coursesNeededField));

		// nextSemesterPanel layout
		javax.swing.GroupLayout nextSemesterPanelLayout = new GroupLayout(
				nextSemesterPanel);
		//nextSemesterPanel.setPreferredSize(new Dimension(200, 400));
		nextSemesterPanel.setLayout(nextSemesterPanelLayout);

		nextSemesterPanelLayout.setAutoCreateContainerGaps(true);
		nextSemesterPanelLayout.setAutoCreateGaps(true);
		nextSemesterPanelLayout.setHorizontalGroup(nextSemesterPanelLayout
				.createSequentialGroup().addComponent(nextSemesterLabel));
		nextSemesterPanelLayout.setVerticalGroup(nextSemesterPanelLayout
				.createSequentialGroup().addComponent(nextSemesterLabel));

		// containerPanel layout
		javax.swing.GroupLayout containerPanelLayout = new GroupLayout(
				containerPanel);
		containerPanel.setLayout(containerPanelLayout);
		containerPanelLayout.setAutoCreateContainerGaps(true);
		containerPanelLayout.setAutoCreateGaps(true);
		containerPanelLayout.setHorizontalGroup(containerPanelLayout
				.createParallelGroup().addComponent(studentNamePanel)
				.addComponent(coursesTakenPanel)
				.addComponent(coursesNeededPanel)
				.addComponent(nextSemesterPanel));
		containerPanelLayout.setVerticalGroup(containerPanelLayout
				.createSequentialGroup().addComponent(studentNamePanel)
				.addComponent(coursesTakenPanel)
				.addComponent(coursesNeededPanel)
				.addComponent(nextSemesterPanel));
		// set panel sizes
		
		
		frame.add(containerPanel);
	}
}
