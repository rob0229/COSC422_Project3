package frontend;

//Robs Mac run Config args: "/Developer/XSB/config/i386-apple-darwin14.1.0/bin"
//Robs Windows run config args: ""C:\\Users\\Rob\\Developer\\Studio_with_XSB-Windows\\fijiXSB\\bin""
//Kevins Run Config args: ""C:\\Program Files (x86)\\XSB\\bin""


import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.declarativa.interprolog.PrologEngine;
import com.declarativa.interprolog.TermModel;
import com.declarativa.interprolog.XSBSubprocessEngine;

public class COSC422_Project3 extends JPanel {
	PrologEngine engine;
	String answer = "Select an answer and click submit";
	JFrame frame = new JFrame("Computer Science Class Scheduler");
	JPanel containerPanel = new JPanel();
	JPanel questionsPanel = new JPanel();
	JPanel optionsPanel = new JPanel();
	JLabel question = new JLabel("Enter a class to see its pre-reqs: ");
	JPanel answerPanel = new JPanel();
	JLabel answerLabel = new JLabel(answer);
	CheckboxGroup choices = new CheckboxGroup();
	Checkbox beer = new Checkbox("Beer", choices, true);
	Checkbox cleaning = new Checkbox("Cleaning",choices, false);
	Checkbox money = new Checkbox("Money",choices, false);
	Checkbox freeloaders = new Checkbox("Freeloaders",choices, false);
	JButton submit = new JButton("Submit");
	String result;
	//constructor
	 public COSC422_Project3(PrologEngine e){
		engine=e;
		submit.setBounds(130, 100, 100, 40);
		containerPanel.setBackground(new Color(255, 255, 255));
		
		//Container layout for rest of panels
		javax.swing.GroupLayout containerPanelLayout = new GroupLayout(containerPanel);
		containerPanel.setLayout(containerPanelLayout);
		containerPanelLayout.setAutoCreateGaps(true);
		containerPanelLayout.setAutoCreateContainerGaps(true);
		containerPanelLayout.setHorizontalGroup(containerPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(questionsPanel)
				.addComponent(optionsPanel)
				.addComponent(submit)
				.addComponent(answerPanel)
				);
		containerPanelLayout.setVerticalGroup(containerPanelLayout
				.createSequentialGroup()
				.addComponent(questionsPanel)
				.addComponent(optionsPanel)
				.addComponent(submit)
				.addComponent(answerPanel)
				);

		//Question Panel Layout
		javax.swing.GroupLayout questionPanelLayout = new GroupLayout(questionsPanel);
		questionsPanel.setLayout(questionPanelLayout);
		questionPanelLayout.setAutoCreateGaps(true);
		questionPanelLayout.setAutoCreateContainerGaps(true);
		questionPanelLayout.setHorizontalGroup(questionPanelLayout
				.createSequentialGroup().addComponent(question));
		questionPanelLayout.setVerticalGroup(questionPanelLayout
				.createSequentialGroup().addComponent(question));
				
		//answerPanel Layout
		javax.swing.GroupLayout answerPanelLayout = new GroupLayout(answerPanel);
		answerPanel.setLayout(answerPanelLayout);
		answerPanelLayout.setAutoCreateGaps(true);
		answerPanelLayout.setAutoCreateContainerGaps(true);
		answerPanelLayout.setHorizontalGroup(answerPanelLayout
				.createSequentialGroup().addComponent(answerLabel));
		answerPanelLayout.setVerticalGroup(answerPanelLayout
				.createSequentialGroup().addComponent(answerLabel));		
		
		//Check box layout
		javax.swing.GroupLayout selectionPanelLayout = new GroupLayout(optionsPanel);
		optionsPanel.setLayout(selectionPanelLayout);
		selectionPanelLayout.setAutoCreateGaps(true);
		selectionPanelLayout.setAutoCreateContainerGaps(true);
		selectionPanelLayout.setHorizontalGroup(selectionPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(beer)
					.addComponent(cleaning)
					.addComponent(money)
					.addComponent(freeloaders));
				

		selectionPanelLayout.setVerticalGroup(selectionPanelLayout
				.createSequentialGroup()
					.addComponent(beer)
					.addComponent(cleaning)
					.addComponent(money)
					.addComponent(freeloaders));

		frame.add(containerPanel);
		
		//button listener
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				 submitButtonActionPerformed(e);
			}
	
		});

		//Window close button listener
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		containerPanel.setPreferredSize(new Dimension(450, 300));
		frame.pack();
		frame.setVisible(true);
	}
	
	//Submit Button Listener
	public void submitButtonActionPerformed(ActionEvent evt){
		String coursePath = "courseNames.txt";
		String prereqpath = "coursePreReq.txt";
		
		String[] courses;
		System.out.println("Clicked submit");
		Boolean fact = false;
		String choice =choices.getSelectedCheckbox().getLabel();
		
		engine.consultAbsolute(new File("src/prolog/backend_logic.pl"));
		File filetoopen = new File(coursePath);
		
		filetoopen = new File(prereqpath);
		if (engine.consultAbsolute(filetoopen)){
			System.out.println(filetoopen.getAbsolutePath());
			boolean result = engine.deterministicGoal("getPreReq('"+filetoopen.getAbsolutePath()+"')"); 
			System.out.println("Did it work? "+result);
			
			
			String exp = "cosc350";
			TermModel list = nonDeterministicGoal("X","prereq("+exp+", X)"); 
			
			if (list==null) 
				throw new RuntimeException("Prolog getCourses goal should not have failed!");
			
			System.out.println("Here is the result:"+list); 
			 System.out.println( list.getChildCount());
			if (list.isList()) { 
				// Visit the list using getChild(0) (for head) and getChild(1) (for tail)/			 
				System.out.println( list.getChild(0));
			}	
		} else throw new RuntimeException("Prolog consult should not have failed!");
	}
	
	public TermModel nonDeterministicGoal(String variables, String goal) {
		String fullgoal = "nonDeterministicGoal(" + variables + "," + goal + ",ListModel)"; 
		return (TermModel)(engine.deterministicGoal(fullgoal,"[ListModel]")[0]);
	}
	
public static void main(String args[]) {

	final XSBSubprocessEngine engine = new XSBSubprocessEngine(args[0]);
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(COSC422_Project3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(COSC422_Project3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(COSC422_Project3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(COSC422_Project3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new COSC422_Project3(engine).setVisible(true);
			}
		});
}	
}

