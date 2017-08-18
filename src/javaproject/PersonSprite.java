package javaproject;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class PersonSprite extends Sprite{

    private int dx;
    private int dy;
    protected int upKey;
    protected int downKey;
    protected int leftKey;
    protected int rightKey;
    protected String imgpath;
    private ArrayList<Missile> missiles;
    
    public PersonSprite(int upKey , int downKey, int leftKey, int rightKey, String imgpath, int x, int y) {
    		super(x,y);
    		initPersonSprite(imgpath);
        this.upKey = upKey;
        this.downKey = downKey;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        
    }
    
    private void initPersonSprite(String imgpath) {
    	missiles = new ArrayList<Missile>() ;
        loadImage(imgpath); 
        getImageDimensions();
        x = 40;
        y = 60;        
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_SPACE) {
            fire();
        }
        
        if (key == leftKey) {
            dx = -1;
        }

        if (key == rightKey) {
            dx = 1;
        }

        if (key == upKey) {
            dy = -1;
        }

        if (key == downKey) {
            dy = 1;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == leftKey) {
            dx = 0;
        }

        if (key == rightKey) {
            dx = 0;
        }

        if (key == upKey) {
            dy = 0;
        }

        if (key == downKey) {
            dy = 0;
        }
    }
    
    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }
    
    public ArrayList<Missile> getMissiles() {
        return missiles;
    }
    
    
}