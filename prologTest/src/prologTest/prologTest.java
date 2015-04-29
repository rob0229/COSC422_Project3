package prologTest;

//Robs Mac run Config args: "/Developer/XSB/config/i386-apple-darwin14.1.0/bin"
//Robs Windows run config args: ""C:\\Users\\Rob\\Developer\\Studio_with_XSB-Windows\\fijiXSB\\bin""
//Kevins Run Config args: ""


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

public class prologTest extends JPanel {
	
	String answer = "Select an answer and click submit";
	JFrame frame = new JFrame("Computer Science Class Scheduler");
	JPanel containerPanel = new JPanel();
	JPanel questionsPanel = new JPanel();
	JPanel selectionPanel = new JPanel();
	JLabel question = new JLabel("Does Rob Like: ");
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
	 public prologTest(String args[]){
		 init(args);
	 }
	
	//init control method
	public void init(final String args[]){
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
				.addComponent(selectionPanel)
				.addComponent(submit)
				.addComponent(answerPanel)
				);
		containerPanelLayout.setVerticalGroup(containerPanelLayout
				.createSequentialGroup()
				.addComponent(questionsPanel)
				.addComponent(selectionPanel)
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
		javax.swing.GroupLayout selectionPanelLayout = new GroupLayout(selectionPanel);
		selectionPanel.setLayout(selectionPanelLayout);
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
				 submitButtonActionPerformed(e, args);
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
	public void submitButtonActionPerformed(ActionEvent evt, String args[]){
		System.out.println("Clicked submit");
		Boolean fact = false;
		String choice =choices.getSelectedCheckbox().getLabel();
		//System.out.println(choice);
		PrologEngine engine = new XSBSubprocessEngine(args[0]);
		engine.consultAbsolute(new File("like.pl"));
		
		//returns true/false boolean
		boolean result = engine.command("likes("+choice+")");
		System.out.println("Choice is: "+choice);
		System.out.println("result: "+result);
		
		if(result)
			answerLabel.setText("Yes he does!");
		else
			answerLabel.setText("No he doesn't!");
		
		Object[] res = engine.deterministicGoal(" rob(List), buildTermModel(List,TM)","[TM]"); 

		TermModel list = (TermModel)res[0]; 
		System.out.println("Here is the result:"+list); 
		 System.out.println( list.getChildCount());
		if (list.isList()) { 
			// Visit the list using getChild(0) (for head) and getChild(1) (for tail)/			 
			System.out.println( list.getChild(0));
			System.out.println( list.getChild(1));
		}
		
	}
	
public static void main(String args[]) {

		final String[] arg = args;
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(prologTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(prologTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(prologTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(prologTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new prologTest(arg).setVisible(true);
			}
		});
}	
}

