package frontend;

//Robs Mac run Config args: "/Developer/XSB/config/i386-apple-darwin14.1.0/bin"
//Robs Windows run config args: ""C:\\Users\\Rob\\Developer\\Studio_with_XSB-Windows\\fijiXSB\\bin""
//Kevins Run Config args: ""C:\\Program Files (x86)\\XSB\\bin""

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.declarativa.interprolog.PrologEngine;
import com.declarativa.interprolog.TermModel;
import com.declarativa.interprolog.XSBSubprocessEngine;

public class COSC422_Project3 {
	private final DisplayWindow dw = new DisplayWindow();
	final String PROLOGFILE = "src/prolog/backend_logic.pl";
	final String COURSEPATH = "courseNames.txt";
	final String PREREQPATH = "coursePreReq.txt";
	final String STUDENT = "student_";
	ArrayList<String> studentNames = new ArrayList<String>();
	PrologEngine engine;
	
	// constructor
	public COSC422_Project3(PrologEngine e) {
		engine = e;
		engine.consultAbsolute(new File(PROLOGFILE));
		getStudentNames();
		getCourses();

	
		dw.addSubmitButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(dw.getStudentName());	
				getCoursesTaken(dw.getStudentName());
				getCoursesNeeded(dw.getStudentName());
				getNextSemesterCourses(dw.getStudentName());
			}
		});
		
		dw.addGetCoursePrereqButtonActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked getCoursePrereq BTN");
				getCoursePrereq(dw.getCourseName());
			}	
		});
	}
	
	private void getNextSemesterCourses(String name) {
		// TODO: get the courses a student is eligible for from prolog
		//and add to view by calling setNextSemesterCourses(ArrayList)
			
	}
	private void getCoursePrereq(String courseName){
		File filetoopen = new File(PREREQPATH);
		engine.deterministicGoal("getPrereq('"+ filetoopen.getAbsolutePath() + "')");
		
		TermModel list = nonDeterministicGoal("X" , "prereq("+courseName+", X)");
		if (list == null){
			throw new RuntimeException("Prolog getCourses goal should not have failed!");
		}
		if (list.isList()) {
			System.out.println("List is: "+list);
			dw.setCoursePrereq(convertTermModeltoArrayList(list));
		}else{ 
			System.out.println("Error in getCoursesTaken()");
		}	
	}

	private void getCoursesNeeded(String name) {
		File filetoopen = new File(COURSEPATH);
		engine.deterministicGoal("getCourses('"+ filetoopen.getAbsolutePath() + "')");
		TermModel list = nonDeterministicGoal("X", "course(X)");
		if (list == null){
			throw new RuntimeException("Prolog getCourses goal should not have failed!");
		}
		if (list.isList()) {
			dw.setCoursesNeeded(convertTermModeltoArrayList(list));
		}
		else{
			System.out.println("Error in getCoursesNeeded()");
		}
	}

	private void getCoursesTaken(String name) {		
		String[] splitName = name.split(" ");	
		File filetoopen = new File(STUDENT+splitName[0]+"_"+splitName[1]+".txt");
		
		System.out.println("filename path: "+filetoopen.getAbsolutePath());
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
	
	public void getStudentNames(){
		//**************************************************************************************
		//This needs to be a relative path!
		//FIX MEEEEEE!!!!!!!!!!!!!!!!!
		//**************************************************************************************
		File dir = new File("/Users/rob0229/git/COSC422_Project3/prologTest");
		
		System.out.println(dir.getAbsolutePath());
		
		File[] foundFiles = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.startsWith("student_");
		    }
		});
		
		System.out.println("Size of foundFiles is " + foundFiles.length);

		for (File file : foundFiles) {
			//for each student file, add the name to the student name string
			//get all student files and add to prolog 
			engine.deterministicGoal("getStudent('"+ file.getAbsolutePath() + "')");
			
			TermModel list = nonDeterministicGoal("X", "name(X)");
			if (list == null){
				throw new RuntimeException("Prolog getCourses goal should not have failed!");
			}
			if (list.isList()) {
				studentNames.add(convertTermModeltoArrayList(list).get(0));
				dw.addStudentNames(convertTermModeltoArrayList(list).get(0));
			}else{ 
				System.out.println("Error in getCoursesTaken()");
			}	
		}
	}

	public void getCourses(){
			
		File file = new File("courseNames.txt");
		engine.deterministicGoal("getCourses('"+ file.getAbsolutePath() + "')");
		
		TermModel list = nonDeterministicGoal("X", "course(X)");
		if (list == null){
			throw new RuntimeException("Prolog getCourses goal should not have failed!");
		}
		if (list.isList()) {
			dw.setCourses(convertTermModeltoArrayList(list));
		}else{ 
			System.out.println("Error in getCoursesTaken()");
		}		
	}
	
	//helper function for template goals to prolog
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
	
	//Convert the TermModel Object returned from prolog into an ArrayList for easier passing to the View
	public ArrayList<String> convertTermModeltoArrayList(TermModel old){
		TermModel tm = old;
		ArrayList<String> newArrayList = new ArrayList<String>();
		String parsed[] = null;
		while(!tm.isListEnd()){
			
			String temp = tm.getChild(0).toString();
			//divides string from list format ([1, 2]) into individual strings and removes '[' and ']' chars
			if(temp.contains("[")){
				parsed = temp.split(",");
				for(int i=0; i<parsed.length; i++){
					parsed[i] = parsed[i].replace("[", "");
					parsed[i] = parsed[i].replace("]", "");
					newArrayList.add(parsed[i]);
				}
			}else
				newArrayList.add(temp);
			
			tm = (TermModel) tm.getChild(1);
		}
		return newArrayList;
	}
}
