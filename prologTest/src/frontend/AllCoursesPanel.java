package frontend;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class AllCoursesPanel extends JFrame {
	JPanel allCoursesPanel = new JPanel();
	JLabel allCoursesLabel = new JLabel("All Available Courses");
	JTextArea courseTextArea = new JTextArea();
	
	public AllCoursesPanel(){
		
		javax.swing.GroupLayout allCoursesPanelLayout = new GroupLayout(allCoursesPanel);
		allCoursesPanel.setLayout(allCoursesPanelLayout);
		allCoursesPanelLayout.setAutoCreateGaps(true);
		
		allCoursesPanelLayout.setHorizontalGroup(allCoursesPanelLayout
				.createParallelGroup()
				.addComponent(allCoursesLabel)
				.addComponent(courseTextArea));
		allCoursesPanelLayout.setVerticalGroup(allCoursesPanelLayout
				.createSequentialGroup()
				.addComponent(allCoursesLabel)
				.addComponent(courseTextArea));
	}
	public JPanel getPanel(){
		return allCoursesPanel;
	}
	public void setAllCoursesText(ArrayList<String> s){
		courseTextArea.setText("");
		for(int i = 0; i<s.size();i++){
			courseTextArea.append(s.get(i) + "  ");
			if(i%5==0 && i>3){
				courseTextArea.append("\n");
			}
		}
	}

}
