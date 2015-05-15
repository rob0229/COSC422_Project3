package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayWindow extends JFrame {
	//frame
	JFrame frame = new JFrame("Math & Computer Science Degree Course Monitor");
	//Panels
	AllCoursesPanel allCoursesPanel = new AllCoursesPanel();
	StudentNamePanel studentNamePanel = new StudentNamePanel();
	CurrentSemesterPanel currentSemesterPanel = new CurrentSemesterPanel();
	CoursesTakenPanel coursesTakenPanel = new CoursesTakenPanel();
	CoursesNeededPanel coursesNeededPanel = new CoursesNeededPanel();
	NextSemesterPanel nextSemesterPanel = new NextSemesterPanel();
	MultiSemesterPanel multiSemesterPanel = new MultiSemesterPanel();
	AddTakenCoursePanel addTakenCoursePanel = new AddTakenCoursePanel();
	AddFailedCoursePanel addFailedCoursePanel = new AddFailedCoursePanel();
	CoursePrereqPanel coursePrereqPanel = new CoursePrereqPanel();
	ModifyElectivePanel modifyElectivePanel = new ModifyElectivePanel();
	ModifyRequiredCoursePanel modifyRequiredCoursePanel = new ModifyRequiredCoursePanel();
	JPanel containerPanel = new JPanel();
	JPanel courseInfoContainerPanel = new JPanel();
	JPanel studentInfoContainerPanel = new JPanel();
	//labels
	JLabel courseInfoLabel = new JLabel("Course Information and Degree Paths");
	JLabel studentInfoLabel = new JLabel("Individual Student Information");
	
	// constructor
	public DisplayWindow() {
		createGroupLayout();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		containerPanel.setPreferredSize(new Dimension(1000, 740));
		frame.pack();
		frame.setVisible(true);
	}

	//Layout function	
	private void createGroupLayout() {
		// set background colors
		containerPanel.setBackground(Color.red);
		//courseInfoPanel Layout
		courseInfoLabel.setFont(new Font("Courier New", Font.BOLD, 20));
		courseInfoContainerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		courseInfoContainerPanel.setPreferredSize(new Dimension(490, 730));
		courseInfoContainerPanel.setMaximumSize(new Dimension(490, 730));
		javax.swing.GroupLayout courseInfoPanelLayout = new GroupLayout(courseInfoContainerPanel);
		courseInfoContainerPanel.setLayout(courseInfoPanelLayout);
		courseInfoPanelLayout.setAutoCreateContainerGaps(true);
		courseInfoPanelLayout.setAutoCreateGaps(true);
		courseInfoPanelLayout.setHorizontalGroup(courseInfoPanelLayout
				.createParallelGroup()
				.addComponent(courseInfoLabel)
				.addComponent(coursePrereqPanel.getPanel())
				.addComponent(modifyElectivePanel.getPanel())
				.addComponent(modifyRequiredCoursePanel.getPanel())
				.addComponent(allCoursesPanel.getPanel()));
				
		courseInfoPanelLayout.setVerticalGroup(courseInfoPanelLayout
				.createSequentialGroup()
				.addComponent(courseInfoLabel)
				.addComponent(coursePrereqPanel.getPanel())
				.addComponent(modifyElectivePanel.getPanel())
				.addComponent(modifyRequiredCoursePanel.getPanel())
				.addComponent(allCoursesPanel.getPanel()));

		// studentPanel layout
		studentInfoContainerPanel.setPreferredSize(new Dimension(490, 730));
		studentInfoContainerPanel.setMaximumSize(new Dimension(490, 730));
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
				.addComponent(currentSemesterPanel.getPanel())
				.addComponent(studentNamePanel.getPanel()))
					.addComponent(coursesTakenPanel.getPanel())
					.addComponent(coursesNeededPanel.getPanel())
					.addComponent(nextSemesterPanel.getPanel())
					.addComponent(multiSemesterPanel.getPanel())
					.addComponent(addTakenCoursePanel.getPanel())
					.addComponent(addFailedCoursePanel.getPanel()));
					
		studentPanelLayout.setVerticalGroup(studentPanelLayout.createSequentialGroup()
				.addComponent(studentInfoLabel)
				.addGroup(studentPanelLayout
				.createParallelGroup()
				.addComponent(currentSemesterPanel.getPanel())
				.addComponent(studentNamePanel.getPanel()))
				.addGroup(studentPanelLayout.createSequentialGroup()
				.addComponent(coursesTakenPanel.getPanel())
				.addComponent(coursesNeededPanel.getPanel())
				.addComponent(nextSemesterPanel.getPanel())
				.addComponent(multiSemesterPanel.getPanel())
				.addComponent(addTakenCoursePanel.getPanel())
				.addComponent(addFailedCoursePanel.getPanel())));
		
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
