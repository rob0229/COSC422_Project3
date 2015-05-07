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

@SuppressWarnings("serial")
public class DisplayWindow extends JFrame {
	//Data Variables
	ArrayList<String> courses = new ArrayList<String>();
	ArrayList<String> coursesTaken = new ArrayList<String>();
	ArrayList<String> coursesNeeded = new ArrayList<String>();
	ArrayList<String> studentNames = new ArrayList<String>();
	ArrayList<String> nextSemesterCourses = new ArrayList<String>();
	ArrayList<String> coursePrereq = new ArrayList<String>();
	//frame
	JFrame frame = new JFrame("Math & Computer Science Degree Course Monitor");
	//panels
	JPanel containerPanel = new JPanel();
	JPanel studentNamePanel = new JPanel();
	JPanel coursesTakenPanel = new JPanel();
	JPanel coursesNeededPanel = new JPanel();
	JPanel nextSemesterPanel = new JPanel();
	JPanel coursePrereqPanel = new JPanel();
	JPanel semesterPanel = new JPanel();
	//buttons
	JButton getScheduleOptions = new JButton("Show Schedule Options");
	JButton getStudentBtn = new JButton("Get Student");
	JButton getCoursePrereqBtn = new JButton("Get Pre-reqs");
	//text fields
	JComboBox<String> studentNameField = new JComboBox<String>();
	JComboBox<String> courseListField = new JComboBox<String>();
	JComboBox<String> semesterField = new JComboBox<String>();
	JTextArea coursesTakenField = new JTextArea();
	JTextArea coursesNeededField = new JTextArea();
	JTextArea nextSemesterField = new JTextArea();
	JTextArea coursePrereqField = new JTextArea();
	//labels
	JLabel coursesTakenLabel = new JLabel("Courses Taken");
	JLabel coursesNeededLabel = new JLabel("Courses Needed To Graduate");
	JLabel nextSemesterLabel = new JLabel("Courses You Can Take Next Semester");
	JLabel coursePrereqLabel = new JLabel("Course Pre-reqs");
	JLabel semesterLabel = new JLabel("Current Semester");

	// constructor
	public DisplayWindow() {
		createGroupLayout();
		semesterField.addItem("Spring Even");
		semesterField.addItem("Fall Even");
		semesterField.addItem("Spring Odd");
		semesterField.addItem("Fall Odd");

		containerPanel.setPreferredSize(new Dimension(400, 600));
		//frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	//setter and getters
	public String getCurrentSemester() {
		return (String)semesterField.getSelectedItem();
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
	public void addStudentNames(String s){
		studentNameField.addItem(s);
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
	public String getStudentName(){
		return (String) studentNameField.getSelectedItem();
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
	// Button Listeners
	public void addSubmitButtonActionListener(ActionListener listener) {
		getStudentBtn.addActionListener(listener);
	}
	// getCoursePrereqBtn Button Listener
	public void addGetCoursePrereqButtonActionListener(ActionListener listener) {
		getCoursePrereqBtn.addActionListener(listener);
	}
	//Layout function	
	private void createGroupLayout() {
		
		// set border layouts
		semesterPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		containerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		studentNamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		coursesTakenPanel
				.setBorder(BorderFactory.createLineBorder(Color.black));
		coursesNeededPanel.setBorder(BorderFactory
				.createLineBorder(Color.black));
		nextSemesterPanel
				.setBorder(BorderFactory.createLineBorder(Color.black));

		// set background colors
		semesterPanel.setBackground(Color.blue);
		studentNamePanel.setBackground(Color.CYAN);
		coursesTakenPanel.setBackground(Color.magenta);
		containerPanel.setBackground(Color.green);

		//semester panel layout
		javax.swing.GroupLayout semesterPanelLayout = new GroupLayout(semesterPanel);
		semesterPanel.setLayout(semesterPanelLayout);
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
		
		
		// Student Name Panel Layout
		javax.swing.GroupLayout studentNamePanelLayout = new GroupLayout(
				studentNamePanel);
		
		studentNamePanel.setLayout(studentNamePanelLayout);
		studentNamePanelLayout.setAutoCreateGaps(true);
		studentNamePanelLayout.setAutoCreateContainerGaps(true);

		studentNamePanelLayout.setHorizontalGroup(studentNamePanelLayout
				.createSequentialGroup()
				.addComponent(studentNameField)
				.addComponent(getStudentBtn));

		studentNamePanelLayout.setVerticalGroup(studentNamePanelLayout
				.createParallelGroup()
				.addComponent(studentNameField)
				.addComponent(getStudentBtn));

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
		nextSemesterPanel.setLayout(nextSemesterPanelLayout);

		nextSemesterPanelLayout.setAutoCreateContainerGaps(true);
		nextSemesterPanelLayout.setAutoCreateGaps(true);
		nextSemesterPanelLayout.setHorizontalGroup(nextSemesterPanelLayout
				.createParallelGroup().addComponent(nextSemesterLabel)
				.addComponent(nextSemesterField));
		nextSemesterPanelLayout.setVerticalGroup(nextSemesterPanelLayout
				.createSequentialGroup().addComponent(nextSemesterLabel)
				.addComponent(nextSemesterField));

		// coursePrereqPanel layout
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
		
		// containerPanel layout
		javax.swing.GroupLayout containerPanelLayout = new GroupLayout(
				containerPanel);
		containerPanel.setLayout(containerPanelLayout);
		containerPanelLayout.setAutoCreateContainerGaps(true);
		containerPanelLayout.setAutoCreateGaps(true);
		containerPanelLayout.setHorizontalGroup(containerPanelLayout
				.createParallelGroup()
				.addComponent(semesterPanel)
				.addComponent(studentNamePanel)
				.addComponent(coursesTakenPanel)
				.addComponent(coursesNeededPanel)
				.addComponent(nextSemesterPanel)
				.addComponent(coursePrereqPanel));
		containerPanelLayout.setVerticalGroup(containerPanelLayout
				.createSequentialGroup()
				.addComponent(semesterPanel)
				.addComponent(studentNamePanel)
				.addComponent(coursesTakenPanel)
				.addComponent(coursesNeededPanel)
				.addComponent(nextSemesterPanel)
				.addComponent(coursePrereqPanel));
		// set panel sizes
		
		frame.add(containerPanel);
	}
}
