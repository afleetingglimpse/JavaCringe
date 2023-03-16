package SnakeCringe;

import java.awt.Image;

public class Fruit implements Content{

    private int y, x;

    public Fruit(int y, int x) {
        setY(y);
        setX(x);
    }

    public void setY(int y) {this.y = y;}
    public void setX(int x) {this.x = x;}
    
    public int getY() {return y;}
    public int getX() {return x;}


    @Override
    public Image getImage() {
        return null;
    }
    
}
