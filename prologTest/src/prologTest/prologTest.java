package prologTest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.declarativa.interprolog.XSBSubprocessEngine;
public class prologTest{

public static void main(String args[]) {
	  JFrame frame = new JFrame("Computer Science Class Scheduler");
	  JPanel panel = new JPanel();
	  JLabel label = new JLabel(" Does Rob Like: ");
	  JTextField answer = new JTextField();
	  answer.setEditable(true);
	  answer.setPreferredSize(new Dimension(200, 60));
	  panel.setBackground(new Color(255,255,255));
	  panel.add(label);
	  panel.add(answer);
	  frame.add(panel);
		// Add a window listener for close button
		frame.addWindowListener(new WindowAdapter() {
	
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	  
	  label.setPreferredSize(new Dimension(600, 600));
	  //frame.getContentPane().add(label, BorderLayout.CENTER);
	 // frame.getContentPane().add(answer, BorderLayout.CENTER);
	  frame.pack();
	  frame.setVisible(true);
	  
	  
	  
	  XSBSubprocessEngine engine = new XSBSubprocessEngine(args[0]);

	  engine.command("import append/3 from basics");
	  
	  Object[] bindings = engine.deterministicGoal("name(User,UL),append(\"Hello,\", UL, ML), name(Message,ML)","[string(User)]",new Object[]{System.getProperty("user.name")},"[string(Message)]");
	 
	  String message = (String)bindings[0];
	  engine.consultAbsolute(new File("like.pl"));
	  System.out.println(engine.deterministicGoal("likes(rob,beer)"));
	  System.out.println("\nMessage:"+message);
	  
	  // the above demonstrates object passing both ways; 
	  // since we may simply concatenate strings, an alternative coding would be:
	  
	  bindings = engine.deterministicGoal("name('"+System.getProperty("user.name")+"',UL),append(\"Hello,\", UL, ML), name(Message,ML)","[string(Message)]");
	  // (notice the ' surrounding the user name, unnecessary in the first case)
	  System.out.println("Same:"+bindings[0]);

  }
  
}

//
//import com.declarativa.interprolog.XSBSubprocessEngine;
//
//public class prologTest {
//	
//	public static void main(String args[]){
//	
//		XSBSubprocessEngine engine = new XSBSubprocessEngine("C:\\Users\\Rob\\XSB");
//		if (engine.deterministicGoal("writeln('Hello, Prolog world'), javaMessage('java.lang.System'-out,println(string('Hello, Java world!')))"))
//			System.out.println("This goal succeeded");
//		System.out.println(System.getProperty("user.name"));
//		
//	}
//		
//
//}
