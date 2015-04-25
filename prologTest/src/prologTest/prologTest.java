package prologTest;
import java.io.File;

import com.declarativa.interprolog.XSBSubprocessEngine;
public class prologTest{
	
  public static void main(String args[]) {
	  
	  System.out.println("here");
	  
	  XSBSubprocessEngine engine = new XSBSubprocessEngine(args[0]);
	  System.out.println("here2");
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
	  System.exit(0);
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
