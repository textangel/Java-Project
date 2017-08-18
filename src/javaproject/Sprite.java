package javaproject;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Sprite {

    protected int x;
    protected int y;
    protected int width = Constants.SPRITE_WIDTH;
    protected int height = Constants.SPRITE_HEIGHT;
    protected boolean vis;
    protected Image image;

    public Sprite(int x, int y) {

        this.x = x;
        this.y = y;
        vis = true;
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH ) ;  
        ImageIcon icon = new ImageIcon( newimg );
        image = icon.getImage();
    }
    
    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }    

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return vis;
    }

    public void setVisible(Boolean visible) {
        vis = visible;
    }
}