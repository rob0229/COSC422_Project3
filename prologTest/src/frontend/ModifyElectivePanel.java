package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ModifyElectivePanel {
	JPanel modifyElectivePanel = new JPanel();
	JButton addElectiveBtn = new JButton("Add Elective");
	JButton removeElectiveBtn = new JButton("Remove Elective");
	JTextArea modifyElectiveField = new JTextArea();
	JLabel modifyElectivesLabel = new JLabel("Add/Remove Electives");

	public ModifyElectivePanel(){
		setLayout();
	}
	public JPanel getPanel(){
		return modifyElectivePanel;
	}
	public void addElectiveButtonActionListener(ActionListener listener) {
		addElectiveBtn.addActionListener(listener);
	}
	public void removeElectiveButtonActionListener(ActionListener listener) {
		removeElectiveBtn.addActionListener(listener);
	}
	
	private void setLayout(){
		//modifyElectivePanel Layout
		modifyElectivePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		modifyElectivePanel.setPreferredSize(new Dimension(480,60));
		modifyElectivePanel.setMaximumSize(new Dimension(480,60));
		javax.swing.GroupLayout modifyElectivePanelLayout = new GroupLayout(modifyElectivePanel);
		modifyElectivePanel.setLayout(modifyElectivePanelLayout);
		modifyElectivePanelLayout.setAutoCreateContainerGaps(true);
		modifyElectivePanelLayout.setAutoCreateGaps(true);
		modifyElectivePanelLayout.setHorizontalGroup(modifyElectivePanelLayout
				.createParallelGroup()
				.addComponent(modifyElectivesLabel)
				.addGroup(modifyElectivePanelLayout
						.createSequentialGroup()
						.addComponent(modifyElectiveField)
						.addComponent(addElectiveBtn)
						.addComponent(removeElectiveBtn)));
		modifyElectivePanelLayout.setVerticalGroup(modifyElectivePanelLayout
				.createSequentialGroup()
				.addComponent(modifyElectivesLabel)
				.addGroup(modifyElectivePanelLayout
						.createParallelGroup()
						.addComponent(modifyElectiveField)
						.addComponent(addElectiveBtn)
						.addComponent(removeElectiveBtn)));
	}
}
