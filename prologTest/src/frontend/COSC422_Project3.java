package frontend;

//Robs Mac run Config args: "/Developer/XSB/config/i386-apple-darwin14.1.0/bin"
//Robs Windows run config args: ""C:\\Users\\Rob\\Developer\\Studio_with_XSB-Windows\\fijiXSB\\bin""
//Kevins Run Config args: ""C:\\Program Files (x86)\\XSB\\bin""

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

import com.declarativa.interprolog.PrologEngine;
import com.declarativa.interprolog.TermModel;
import com.declarativa.interprolog.XSBSubprocessEngine;

public class COSC422_Project3 {
	private final DisplayWindow dw = new DisplayWindow();
	final String PROLOGFILE = "./src/prolog/backend_logic.pl";
	final String COURSEPATH = "./courseNames.txt";
	final String PREREQPATH = "./coursePreReq.txt";
	final String DEGREEREQPATH = "./degreeRequirement.txt";
	final String STUDENT = "student_";
	ArrayList<String> studentNames = new ArrayList<String>();
	PrologEngine engine;
	
	// constructor
	public COSC422_Project3(PrologEngine e) {
		engine = e;
		engine.consultAbsolute(new File(PROLOGFILE));
		getStudentNames();
		getCourses();
		getAllCoursesTextField();
		
		File filetoopen = new File(PREREQPATH);
		engine.deterministicGoal("getPrereq('"+ filetoopen.getName() + "')");

	
		dw.studentNamePanel.addStudentButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(dw.studentNamePanel.getStudentName());	
				getCoursesTaken(dw.studentNamePanel.getStudentName());
				getCoursesNeeded();
				getNextSemesterCourses();
			}
		});
		
		dw.coursePrereqPanel.addGetCoursePrereqButtonActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked getCoursePrereq BTN");
				getCoursePrereq(dw.coursePrereqPanel.getCourseName());
			}	
		});
		
		dw.modifyElectivePanel.addElectiveButtonActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked addElective BTN "+dw.modifyElectivePanel.modifyElectiveField.getText());
				engine.deterministicGoal("assert(course("+dw.modifyElectivePanel.modifyElectiveField.getText()+"))");
				engine.deterministicGoal("assert(degreeElectives("+dw.modifyElectivePanel.modifyElectiveField.getText()+"))");
				dw.modifyElectivePanel.modifyElectiveField.setText("");
				getAllCoursesTextField();
			}	
		});		
	
		dw.modifyElectivePanel.removeElectiveButtonActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked removeElective BTN "+dw.modifyElectivePanel.modifyElectiveField.getText());
				engine.deterministicGoal("retract(course("+dw.modifyElectivePanel.modifyElectiveField.getText()+"))");
				engine.deterministicGoal("retract(degreeElectives("+dw.modifyElectivePanel.modifyElectiveField.getText()+"))");
				dw.modifyElectivePanel.modifyElectiveField.setText("");
				getAllCoursesTextField();
			}
		});

		dw.modifyRequiredCoursePanel.addRequiredCourseButtonActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked addCourse BTN "+dw.modifyRequiredCoursePanel.modifyRequiredCourseField.getText());
				System.out.println(engine.deterministicGoal("assert(course("+dw.modifyRequiredCoursePanel.modifyRequiredCourseField.getText()+"))"));
				System.out.println(engine.deterministicGoal("assert(degree("+dw.modifyRequiredCoursePanel.modifyRequiredCourseField.getText()+"))"));
				dw.modifyRequiredCoursePanel.modifyRequiredCourseField.setText("");
				getAllCoursesTextField();
			}	
		});

		dw.modifyRequiredCoursePanel.removeRequiredCourseButtonActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked removeCourse BTN "+dw.modifyRequiredCoursePanel.modifyRequiredCourseField.getText());
				System.out.println(engine.deterministicGoal("retract(course("+dw.modifyRequiredCoursePanel.modifyRequiredCourseField.getText()+"))"));
				System.out.println(engine.deterministicGoal("retract(degree("+dw.modifyRequiredCoursePanel.modifyRequiredCourseField.getText()+"))"));
				dw.modifyRequiredCoursePanel.modifyRequiredCourseField.setText("");
				getAllCoursesTextField();
			}	
		});
		
		dw.addTakenCoursePanel.addTakenCourseButtonActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked addTakenCourseButton BTN "+dw.addTakenCoursePanel.addTakenCourseField.getText());
				System.out.println(engine.deterministicGoal("assert(taken("+dw.addTakenCoursePanel.addTakenCourseField.getText()+"))"));
				dw.addTakenCoursePanel.addTakenCourseField.setText("");

				ArrayList<String> taken = getNonDeterministicGoalList("X" , "taken(X)", "taken", "getCoursesTaken()");
				dw.coursesTakenPanel.setCoursesTaken(taken);
				getCoursesNeeded();
				getNextSemesterCourses();
			}	
		});
		
		dw.addFailedCoursePanel.addFailedCourseButtonActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked addFailedCourseButton BTN "+dw.addFailedCoursePanel.addFailedCourseField.getText());
				System.out.println(engine.deterministicGoal("assert(failed("+dw.addFailedCoursePanel.addFailedCourseField.getText()+"))"));
				dw.addFailedCoursePanel.addFailedCourseField.setText("");
			}	
		});
	}
	
	private void getNextSemesterCourses() {
		ArrayList<String> courses = getNonDeterministicGoalList("X", "eligibleToTake(X)", "eligibleToTake", "getNextSemesterCourses()");
		dw.nextSemesterPanel.setNextSemesterCourses(courses);
	}
	
	private void getAllCoursesTextField(){
		ArrayList<String> courses = getNonDeterministicGoalList("X" , "course(X)", "getCOurses", "getAllCoursesTextField");
		dw.allCoursesPanel.setAllCoursesText(courses);
	}
	
	private void getCoursePrereq(String courseName){
		File filetoopen = new File(PREREQPATH);
		engine.deterministicGoal("getPrereq('"+ filetoopen.getName() + "')");
		
		ArrayList<String> prereqs = getNonDeterministicGoalList("X" , "prereq("+courseName+", X)", "getPrereq", "getCoursesPrereq()");
		dw.coursePrereqPanel.setCoursePrereq(prereqs);
	}

	private void getCoursesNeeded() {
		File filetoopen = new File(DEGREEREQPATH);
		engine.deterministicGoal("getDegreeRequirements('"+ filetoopen.getName() + "')");
		
		TermModel required = nonDeterministicGoal("X", "requiredToTake(X)");
		TermModel electives = nonDeterministicGoal("X", "electivesToTake(X)");
		TermModel electivesTaken = nonDeterministicGoal("X", "electivesTaken(X)");
		TermModel electives1of3 = nonDeterministicGoal("X", "degree1of3(X)");
		
		boolean takenResearch = engine.deterministicGoal("takenResearch()");
		
		if (required == null || electives == null || electivesTaken == null){
			throw new RuntimeException("Prolog getCourses goal should not have failed!");
		}
		if (required.isList() && electives.isList() && electivesTaken.isList()) {
			ArrayList<String> electivesTakenList = convertTermModeltoArrayList(electivesTaken);
			int numneeded = 3 - electivesTakenList.size();
			ArrayList<String> list1of3 = null;
			
			if (takenResearch) {
				numneeded--;
			} else {
				list1of3 = convertTermModeltoArrayList(electives1of3);
			}
			if (numneeded < 0) numneeded = 0;
			
			dw.coursesNeededPanel.setCoursesNeeded(convertTermModeltoArrayList(required), convertTermModeltoArrayList(electives), numneeded, list1of3);
		}
		else{
			System.out.println("Error in getCoursesNeeded()");
		}
		

		//add multi-semester plan
		ArrayList<String> needed = getNonDeterministicGoalList("X", "multisem(X)", "multisem", "constructor()");
		dw.multiSemesterPanel.setMultiSemesterCourses(needed);
		
	}

	private void getCoursesTaken(String name) {		
		String[] splitName = name.split(" ");	
		File filetoopen = new File("./"+STUDENT+splitName[0]+"_"+splitName[1]+".txt");
		
		System.out.println("filename path: "+filetoopen.getAbsolutePath());
		engine.deterministicGoal("retractall(taken(_))");
		engine.deterministicGoal("retractall(planTaken(_))");
		engine.deterministicGoal("getCourses('"+ filetoopen.getName() + "')");
		
		ArrayList<String> taken = getNonDeterministicGoalList("X" , "taken(X)", "taken", "getCoursesTaken()");
		dw.coursesTakenPanel.setCoursesTaken(taken);
	}
	
	public void getStudentNames(){
		File dir = new File(".");
				
		File[] foundFiles = dir.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.startsWith(STUDENT);
		    }
		});
		
		System.out.println("Size of foundFiles is " + foundFiles.length);

		for (File file : foundFiles) {
			System.out.println(file.getName());
			//for each student file, add the name to the student name string
			//get all student files and add to prolog 
			engine.deterministicGoal("getStudent('"+ file.getName() + "')");
			engine.deterministicGoal("getStudent('"+ file.getName() + "')");
			
			ArrayList<String> names = getNonDeterministicGoalList("X", "name(X)", "getStudent", "getStudentNames()");
			studentNames.add(names.get(0));
			dw.studentNamePanel.addStudentNames(names.get(0));
		}
	}

	public void getCourses(){
			
		File file = new File(COURSEPATH);
		engine.deterministicGoal("getCourses('"+ file.getName() + "')");
		
		ArrayList<String> courses = getNonDeterministicGoalList("X", "course(X)", "getCourses", "getCourses()");
		System.out.println("Course list is: "+courses);
		dw.coursePrereqPanel.setCourses(courses);
	}
	
	//helper function for template goals to prolog
	public TermModel nonDeterministicGoal(String variables, String goal) {
		String fullgoal = "nonDeterministicGoal(" + variables + "," + goal + ",ListModel)";
		return (TermModel) (engine.deterministicGoal(fullgoal, "[ListModel]")[0]);
	}
	
	//helper function to make a list out of a nonDeterministicGoal call
	public ArrayList<String> getNonDeterministicGoalList(String variables, String goal) {
		return getNonDeterministicGoalList(variables, goal, "Unknown", "Unknown");
	}
	public ArrayList<String> getNonDeterministicGoalList(String variables, String goal, String goalName, String funcName) {
		TermModel list = nonDeterministicGoal(variables, goal);
		if (list == null) {
			throw new RuntimeException("Prolog " + goalName + " goal should not have failed!");
		}
		if (list.isList()) {
			return convertTermModeltoArrayList(list);			
		} else { 
			System.out.println("Error calling " + funcName);
		}
		return null;
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
