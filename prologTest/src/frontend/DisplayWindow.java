package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	ArrayList<String> multiSemesterCourses = new ArrayList<String>();
	ArrayList<String> coursePrereq = new ArrayList<String>();
	//frame
	JFrame frame = new JFrame("Math & Computer Science Degree Course Monitor");
	//Panels
	JPanel containerPanel = new JPanel();
		//Course info panels
		JPanel courseInfoContainerPanel = new JPanel();
		JPanel coursePrereqPanel = new JPanel();
		JPanel modifyElectivePanel = new JPanel();
		JPanel modifyRequiredCoursePanel = new JPanel();
		
		//Student Info Panels
		JPanel studentInfoContainerPanel = new JPanel();
		JPanel studentNamePanel = new JPanel();
		JPanel coursesTakenPanel = new JPanel();
		JPanel coursesNeededPanel = new JPanel();
		JPanel nextSemesterPanel = new JPanel();
		JPanel currentSemesterPanel = new JPanel();
		JPanel multiSemesterPanel = new JPanel();
		JPanel addTakenCoursePanel = new JPanel();
		JPanel addFailedCoursePanel = new JPanel();
	
	//buttons
		//Course Info Btns
		JButton getCoursePrereqBtn = new JButton("Get Pre-reqs");
		JButton addElectiveBtn = new JButton("Add Elective");
		JButton removeElectiveBtn = new JButton("Remove Elective");
		JButton addRequiredCourseBtn = new JButton("Add Course");
		JButton removeRequiredCourseBtn = new JButton("Remove Course");
	
		//Student Info Btns
		JButton getMultiSemesterPlan = new JButton("Show Multi Semester Plan");
		JButton getStudentBtn = new JButton("Get Student");
		JButton exportMultiPlanBtn = new JButton("Export Degree Plan");
		JButton addTakenCourseBtn = new JButton("Add Course");
		JButton addFailedCourseBtn = new JButton("Add Failed Course");
	
	//text fields
		//Course Info Fields
		JComboBox<String> courseListField = new JComboBox<String>();
		JTextArea coursePrereqField = new JTextArea();
		JTextArea modifyElectiveField = new JTextArea();
		JTextArea modifyRequiredCourseField = new JTextArea();
		
		//Student Info Fields
		JComboBox<String> semesterField = new JComboBox<String>();
		JComboBox<String> studentNameField = new JComboBox<String>();
		JTextArea coursesTakenField = new JTextArea();
		JTextArea coursesNeededField = new JTextArea();
		JTextArea nextSemesterField = new JTextArea();
		JTextArea multiSemesterField = new JTextArea();
		JTextArea addTakenCourseField = new JTextArea();
		JTextArea addFailedCourseField = new JTextArea();
		
	//labels
		//Course Info Labels
		JLabel courseInfoLabel = new JLabel("Course Information and Degree Paths");
		JLabel coursePrereqLabel = new JLabel("Course Pre-reqs");
		JLabel modifyElectivesLabel = new JLabel("Add/Remove Electives");
		JLabel modifyRequiredCoursesLabel = new JLabel("Add/Remove Required Courses");
		JLabel Label = new JLabel("Course Pre-reqs");
		//Student Info Labels
		JLabel studentInfoLabel = new JLabel("Individual Student Information");
		JLabel semesterLabel = new JLabel("Current Semester");
		JLabel currentStudentLabel = new JLabel("Current Student");
		JLabel coursesTakenLabel = new JLabel("Courses Taken");
		JLabel coursesNeededLabel = new JLabel("Courses Needed To Graduate");
		JLabel nextSemesterLabel = new JLabel("Courses You Can Take Next Semester");
		JLabel multiSemesterLabel = new JLabel("Multi-Semester Plan");
		JLabel addTakenCourseLabel = new JLabel("Add a Completed Course. (ex cosc422)");
		JLabel addFailedCourseLabel = new JLabel("Add a Failed Course. (ex cosc450)");
	
	// constructor
	public DisplayWindow() {
		createGroupLayout();
		
		semesterField.addItem("Spring Even");
		semesterField.addItem("Fall Even");
		semesterField.addItem("Spring Odd");
		semesterField.addItem("Fall Odd");
		
		containerPanel.setPreferredSize(new Dimension(1000, 700));
		
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
		
		// set background colors
		containerPanel.setBackground(Color.red);

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
				.addComponent(getMultiSemesterPlan)));
		multiSemesterPanelLayout.setVerticalGroup(multiSemesterPanelLayout
				.createSequentialGroup()
				.addComponent(multiSemesterLabel).addGroup(multiSemesterPanelLayout
						.createParallelGroup()
				.addComponent(multiSemesterField)
				.addComponent(getMultiSemesterPlan)));
		
		//addTakenCourse panel Layout
		addTakenCoursePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		javax.swing.GroupLayout addTakenCoursePanelLayout = new GroupLayout(addTakenCoursePanel);
		addTakenCoursePanel.setLayout(addTakenCoursePanelLayout);
		addTakenCoursePanelLayout.setAutoCreateGaps(true);
		addTakenCoursePanelLayout.setAutoCreateContainerGaps(true);
		addTakenCoursePanelLayout.setHorizontalGroup(addTakenCoursePanelLayout
				.createParallelGroup()
				.addComponent(addTakenCourseLabel)
				.addGroup(addTakenCoursePanelLayout
						.createSequentialGroup()
						.addComponent(addTakenCourseField)
						.addComponent(addTakenCourseBtn)));
		addTakenCoursePanelLayout.setVerticalGroup(addTakenCoursePanelLayout
				.createSequentialGroup()
				.addComponent(addTakenCourseLabel)
				.addGroup(addTakenCoursePanelLayout
						.createParallelGroup()
						.addComponent(addTakenCourseField)
						.addComponent(addTakenCourseBtn)));
		
		//addFailedCourse panel Layout
		addFailedCoursePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		javax.swing.GroupLayout addFailedCoursePanelLayout = new GroupLayout(addFailedCoursePanel);
		addFailedCoursePanel.setLayout(addFailedCoursePanelLayout);
		addFailedCoursePanelLayout.setAutoCreateGaps(true);
		addFailedCoursePanelLayout.setAutoCreateContainerGaps(true);
		addFailedCoursePanelLayout.setHorizontalGroup(addFailedCoursePanelLayout
				.createParallelGroup()
				.addComponent(addFailedCourseLabel)
				.addGroup(addFailedCoursePanelLayout
						.createSequentialGroup()
						.addComponent(addFailedCourseField)
						.addComponent(addFailedCourseBtn)));
		addFailedCoursePanelLayout.setVerticalGroup(addFailedCoursePanelLayout
				.createSequentialGroup()
				.addComponent(addFailedCourseLabel)
				.addGroup(addFailedCoursePanelLayout
						.createParallelGroup()
						.addComponent(addFailedCourseField)
						.addComponent(addFailedCourseBtn)));
		
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
		
		//modifyElectivePanel Layout
		modifyElectivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		modifyElectivePanel.setPreferredSize(new Dimension(480,60));
		modifyElectivePanel.setMaximumSize(new Dimension(480,60));
		javax.swing.GroupLayout modifyElectivePanelLayout = new GroupLayout(modifyElectivePanel);
		modifyElectivePanel.setLayout(modifyElectivePanelLayout);
		modifyElectivePanelLayout.setAutoCreateContainerGaps(true);
		modifyElectivePanelLayout.setAutoCreateGaps(true);
		modifyElectivePanelLayout.setHorizontalGroup(modifyElectivePanelLayout
				.createParallelGroup()
				.addComponent(modifyElectivesLabel)
				.addGroup(modifyElectivePanelLayout
						.createSequentialGroup()
						.addComponent(modifyElectiveField)
						.addComponent(addElectiveBtn)
						.addComponent(removeElectiveBtn)));
		modifyElectivePanelLayout.setVerticalGroup(modifyElectivePanelLayout
				.createSequentialGroup()
				.addComponent(modifyElectivesLabel)
				.addGroup(modifyElectivePanelLayout
						.createParallelGroup()
						.addComponent(modifyElectiveField)
						.addComponent(addElectiveBtn)
						.addComponent(removeElectiveBtn)));
		
		//modifyRequiredPanel layout
		modifyRequiredCoursePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		modifyRequiredCourseField.setPreferredSize(new Dimension(480, 120));
		modifyRequiredCourseField.setMaximumSize(new Dimension(480, 120));
		javax.swing.GroupLayout modifyRequiredPanelLayout = new GroupLayout(modifyRequiredCoursePanel);
		modifyRequiredCoursePanel.setLayout(modifyRequiredPanelLayout);
		modifyRequiredPanelLayout.setAutoCreateContainerGaps(true);
		modifyRequiredPanelLayout.setAutoCreateGaps(true);
		modifyRequiredPanelLayout.setHorizontalGroup(modifyRequiredPanelLayout
				.createParallelGroup()
				.addComponent(modifyRequiredCoursesLabel)
				.addGroup(modifyRequiredPanelLayout
						.createSequentialGroup()
						.addComponent(modifyRequiredCourseField)
						.addComponent(addRequiredCourseBtn)
						.addComponent(removeRequiredCourseBtn)));
		modifyRequiredPanelLayout.setVerticalGroup(modifyRequiredPanelLayout
				.createSequentialGroup()
				.addComponent(modifyRequiredCoursesLabel)
				.addGroup(modifyRequiredPanelLayout
						.createParallelGroup()
						.addComponent(modifyRequiredCourseField)
						.addComponent(addRequiredCourseBtn)
						.addComponent(removeRequiredCourseBtn)));
		
		
		//courseInfoPanel Layout
		courseInfoLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		courseInfoContainerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		courseInfoContainerPanel.setPreferredSize(new Dimension(490, 700));
		courseInfoContainerPanel.setMaximumSize(new Dimension(490, 700));
		javax.swing.GroupLayout courseInfoPanelLayout = new GroupLayout(courseInfoContainerPanel);
		courseInfoContainerPanel.setLayout(courseInfoPanelLayout);
		courseInfoPanelLayout.setAutoCreateContainerGaps(true);
		courseInfoPanelLayout.setAutoCreateGaps(true);
		courseInfoPanelLayout.setHorizontalGroup(courseInfoPanelLayout
				.createParallelGroup()
				.addComponent(courseInfoLabel)
				.addComponent(coursePrereqPanel)
				.addComponent(modifyElectivePanel)
				.addComponent(modifyRequiredCoursePanel));
				
		courseInfoPanelLayout.setVerticalGroup(courseInfoPanelLayout
				.createSequentialGroup()
				.addComponent(courseInfoLabel)
				.addComponent(coursePrereqPanel)
				.addComponent(modifyElectivePanel)
				.addComponent(modifyRequiredCoursePanel));

		// studentPanel layout
		studentInfoContainerPanel.setPreferredSize(new Dimension(490, 700));
		studentInfoContainerPanel.setMaximumSize(new Dimension(490, 700));
		studentInfoLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		studentInfoContainerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		javax.swing.GroupLayout studentPanelLayout = new GroupLayout(
				studentInfoContainerPanel);
		studentInfoContainerPanel.setLayout(studentPanelLayout);
		studentPanelLayout.setAutoCreateContainerGaps(true);
		studentPanelLayout.setAutoCreateGaps(true);
		studentPanelLayout.setHorizontalGroup(studentPanelLayout.createParallelGroup()
				.addComponent(studentInfoLabel)
				.addGroup(studentPanelLayout
				.createSequentialGroup()
				.addComponent(currentSemesterPanel)
				.addComponent(studentNamePanel))
					.addComponent(coursesTakenPanel)
					.addComponent(coursesNeededPanel)
					.addComponent(nextSemesterPanel)
					.addComponent(multiSemesterPanel)
					.addComponent(addTakenCoursePanel)
					.addComponent(addFailedCoursePanel));
					
		studentPanelLayout.setVerticalGroup(studentPanelLayout.createSequentialGroup()
				.addComponent(studentInfoLabel)
				.addGroup(studentPanelLayout
				.createParallelGroup()
				.addComponent(currentSemesterPanel)
				.addComponent(studentNamePanel))
				.addGroup(studentPanelLayout.createSequentialGroup()
				.addComponent(coursesTakenPanel)
				.addComponent(coursesNeededPanel)
				.addComponent(nextSemesterPanel)
				.addComponent(multiSemesterPanel)
				.addComponent(addTakenCoursePanel)
				.addComponent(addFailedCoursePanel)));
		
		//ContainerPanel layout
		containerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		javax.swing.GroupLayout containerPanelLayout = new GroupLayout(containerPanel);
		containerPanel.setLayout(containerPanelLayout);
		containerPanelLayout.setAutoCreateContainerGaps(true);
		containerPanelLayout.setAutoCreateGaps(true);
		containerPanelLayout.setHorizontalGroup(containerPanelLayout.createSequentialGroup()
				.addComponent(courseInfoContainerPanel)
				.addComponent(studentInfoContainerPanel));	
		containerPanelLayout.setVerticalGroup(containerPanelLayout
				.createParallelGroup()
				.addComponent(courseInfoContainerPanel)
				.addComponent(studentInfoContainerPanel));
		
		frame.add(containerPanel);
	}
}
