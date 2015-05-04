package frontend;

//Robs Mac run Config args: "/Developer/XSB/config/i386-apple-darwin14.1.0/bin"
//Robs Windows run config args: ""C:\\Users\\Rob\\Developer\\Studio_with_XSB-Windows\\fijiXSB\\bin""
//Kevins Run Config args: ""C:\\Program Files (x86)\\XSB\\bin""

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import com.declarativa.interprolog.PrologEngine;
import com.declarativa.interprolog.TermModel;
import com.declarativa.interprolog.XSBSubprocessEngine;

public class COSC422_Project3 {
	final String PROLOGFILE = "src/prolog/backend_logic.pl";
	final String COURSEPATH = "courseNames.txt";
	final String PREREQPATH = "coursePreReq.txt";
	final String STUDENT = "student_John_Doe.txt";
	PrologEngine engine;
	private final DisplayWindow dw = new DisplayWindow();

	// constructor
	public COSC422_Project3(PrologEngine e) {
		engine = e;
		engine.consultAbsolute(new File(PROLOGFILE));
		getCoursesTaken();
		getCoursesNeeded();

		dw.addSubmitButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button clicked");	
			}
		});
	}

	private void getCoursesNeeded() {
		File filetoopen = new File(COURSEPATH);
		engine.deterministicGoal("getCourses('"+ filetoopen.getAbsolutePath() + "')");
		TermModel list = nonDeterministicGoal("X", "course(X)");
		if (list == null){
			throw new RuntimeException("Prolog getCourses goal should not have failed!");
		}
		if (list.isList()) {
			// Visit the list using getChild(0) (for head) and getChild(1) (for
			// tail)
			dw.setCoursesNeeded(convertTermModeltoArrayList(list));
		}
		else{
			System.out.println("Error in getCOursesNeeded()");
		}
	}

	private void getCoursesTaken() {	
		File filetoopen = new File(STUDENT);
		engine.deterministicGoal("getCourses('"+ filetoopen.getAbsolutePath() + "')");
		TermModel list = nonDeterministicGoal("X", "taken(X)");
		if (list == null){
			throw new RuntimeException("Prolog getCourses goal should not have failed!");
		}
		if (list.isList()) {
			dw.setCoursesTaken(convertTermModeltoArrayList(list));
		}else{ 
			System.out.println("Error in getCoursesTaken()");
		}
		
	}

	public TermModel nonDeterministicGoal(String variables, String goal) {
		String fullgoal = "nonDeterministicGoal(" + variables + "," + goal + ",ListModel)";
		return (TermModel) (engine.deterministicGoal(fullgoal, "[ListModel]")[0]);
	}

	public static void main(String args[]) {
		final XSBSubprocessEngine engine = new XSBSubprocessEngine(args[0]);
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger
					.getLogger(COSC422_Project3.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger
					.getLogger(COSC422_Project3.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger
					.getLogger(COSC422_Project3.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger
					.getLogger(COSC422_Project3.class.getName()).log(
							java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new COSC422_Project3(engine);
			}
		});
	}
	
	public ArrayList<String> convertTermModeltoArrayList(TermModel old){
		TermModel tm =old;
		ArrayList<String> newArrayList = new ArrayList<String>();
		
		while(!tm.isListEnd()){
			String temp = tm.getChild(0).toString();
			System.out.println("Temp is: "+temp);
			newArrayList.add(temp);
			tm = (TermModel) tm.getChild(1);
		}
		return newArrayList;
	}
}
