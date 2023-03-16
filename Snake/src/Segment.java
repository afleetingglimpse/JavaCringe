package SnakeCringe;

public abstract class Segment implements Content {
    private int y, x;

    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public void updateSegmentCoords(int deltaY, int deltaX) {
        setY(getY() + deltaY);
        setX(getX() + deltaX);
    }

    public int getY() {return y;}
    public int getX() {return x;}


}
