package frontend;

//Robs Mac run Config args: "/Developer/XSB/config/i386-apple-darwin14.1.0/bin"
//Robs Windows run config args: ""C:\\Users\\Rob\\Developer\\Studio_with_XSB-Windows\\fijiXSB\\bin""
//Kevins Run Config args: ""C:\\Program Files (x86)\\XSB\\bin""

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import com.declarativa.interprolog.PrologEngine;
import com.declarativa.interprolog.TermModel;
import com.declarativa.interprolog.XSBSubprocessEngine;

public class COSC422_Project3 {
	PrologEngine engine;
	private final DisplayWindow dw = new DisplayWindow();

	// constructor
	public COSC422_Project3(PrologEngine e) {
		engine = e;
		String coursePath = "courseNames.txt";
		String prereqpath = "coursePreReq.txt";
		String studentpath = "student_John_Doe.txt";
		String[] courses;

		engine.consultAbsolute(new File("src/prolog/backend_logic.pl"));

		File filetoopen = new File(coursePath);

		System.out.println(filetoopen.getAbsolutePath());
		boolean result = engine.deterministicGoal("getCourses('"+ filetoopen.getAbsolutePath() + "')");
		System.out.println("Did it work? " + result);

		TermModel list = nonDeterministicGoal("X", "taken(X)");

		if (list == null)
			throw new RuntimeException("Prolog getCourses goal should not have failed!");

		System.out.println("Here is the result:" + list);
		System.out.println(list.getChildCount());
		if (list.isList()) {
			// Visit the list using getChild(0) (for head) and getChild(1) (for tail)
			System.out.println(list.getChild(0));
		}
		
		dw.addSubmitButtonActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						dw.setText("It Works!");
					}
				}
		);
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
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new COSC422_Project3(engine);
			}
		});
	}
}
