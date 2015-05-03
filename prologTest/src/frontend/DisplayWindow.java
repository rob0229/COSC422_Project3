package frontend;

import java.awt.Dimension;

import javax.swing.*;

public class DisplayWindow extends JFrame {
	JFrame frame = new JFrame("Main");
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Hello World");
	
	public DisplayWindow(){
		panel.setPreferredSize(new Dimension(300,300));	
		panel.add(label);
		
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	
	}
	
	public void setText(String s){
		label.setText(s);
	}
	
}
