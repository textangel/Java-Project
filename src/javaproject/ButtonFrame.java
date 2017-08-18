package javaproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFrame extends JFrame implements WindowListener {
	private Container contentPane;
	public ButtonFrame() {
		setTitle("ButtonTest");
		setSize(300,400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		addWindowListener(this);
		
		contentPane = this.getContentPane();
		contentPane.add(new ButtonPanel());
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	public void windowOpened(WindowEvent e) {};
    public void windowClosed(WindowEvent e) {};
    public void windowIconified(WindowEvent e) {};
    public void windowDeiconified(WindowEvent e) {};
    public void windowActivated(WindowEvent e) {};
    public void windowDeactivated(WindowEvent e) {};
}
