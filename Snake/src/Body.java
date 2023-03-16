package SnakeCringe;

import java.awt.Image;

public class Body extends Segment {

    public Body(int y, int x) {
        setY(y);
        setX(x);
    }

    public Body(Body body) {
        setY(body.getY());
        setX(body.getX());
    }

    @Override
    public Image getImage() {
        return null;
    }
    
}
