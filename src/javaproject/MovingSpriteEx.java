package javaproject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javaproject.Constants;
public class MovingSpriteEx extends JFrame {

    public MovingSpriteEx() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Game());
        setSize(Constants.BOARD_HEIGHT, Constants.BOARD_WIDTH);
        setResizable(false);
        setTitle("Moving sprite");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                MovingSpriteEx ex = new MovingSpriteEx();
                ex.setVisible(true);
            }
        });
    }
}