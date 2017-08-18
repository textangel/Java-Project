package javaproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel extends JPanel implements ActionListener{
	private JButton redButton;
	private JButton yellowButton;
	private JButton blueButton;
	
	public ButtonPanel() {
		yellowButton = new JButton("Yellow");
		blueButton = new JButton("Blue");
		redButton = new JButton("Red");
		yellowButton.addActionListener(this);
		blueButton.addActionListener(this);
		redButton.addActionListener(this);
		add(redButton); add(blueButton); add(yellowButton);
	}
	
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		Color color = getBackground();
		if (source == yellowButton) color = Color.yellow;
		else if (source == redButton) color = Color.red;
		else if (source == blueButton) color = Color.blue;
		setBackground(color);
		repaint();
	}
}
