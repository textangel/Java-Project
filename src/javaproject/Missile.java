package javaproject;
import javaproject.Constants;

public class Missile extends Sprite {

    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y) {
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile() {
        
        loadImage("./docs/missile.png");  
        getImageDimensions();
    }


    public void move() {
        
        x += MISSILE_SPEED;
        
        if (x > Constants.BOARD_WIDTH) {
            vis = false;
        }
    }
}