package SnakeCringe;

import java.awt.Image;

public class Head extends Segment{
    
    private int direction;
    
    public Head(int y, int x) {
        setY(y);
        setX(x);
    }

    public Head(Head head) {
        setY(head.getY());
        setX(head.getX());
    }

    public void setDirection(int direction) {this.direction = direction;}

    public int getDirection() {return direction;}
    @Override
    public Image getImage() {
        return null;
    }
 

}
