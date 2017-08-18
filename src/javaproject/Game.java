package javaproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Game extends JPanel implements ActionListener {

	private final int IPERSON_X = 40;
    private final int IPERSON_Y = 60;
    private Timer timer;
    private PersonSprite personSprite;
//    private Sprite sprite2;
    private final int DELAY = 10;

    public Game() {

        initGame();
    }
    
    private void initGame() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        personSprite = new PersonSprite(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT
        		, "./docs/sprite.png", IPERSON_X, IPERSON_Y);
//        sprite2 = new Sprite(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, "./docs/sprite2.png");

        timer = new Timer(DELAY, this);
        timer.start();        
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(personSprite.getImage(), personSprite.getX(), personSprite.getY(), this);
//        g2d.drawImage(sprite2.getImage(), sprite2.getX(), sprite2.getY(), this);
        
        ArrayList<Missile> ms = personSprite.getMissiles();

        for (Object m1 : ms) {
            Missile m = (Missile) m1;
            g2d.drawImage(m.getImage(), m.getX(),
                    m.getY(), this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        sprite2.move();
        updateMissiles();
        updatePersonSprite();
        repaint();  
    }
    
    private void updateMissiles() {
        ArrayList<Missile> ms = personSprite.getMissiles();
        for (int i = 0; i < ms.size(); i++) {
            Missile m = (Missile) ms.get(i);
            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

    private void updatePersonSprite() {
        personSprite.move();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            personSprite.keyReleased(e);
//            sprite2.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            personSprite.keyPressed(e);
//            sprite2.keyPressed(e);
        }
    }
}