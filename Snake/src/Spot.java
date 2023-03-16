package SnakeCringe;

public class Spot {
    private int y, x;
    private Content content;

    public Spot(int y, int x, Content content) {
        setXY(x, y);
        setContent(content);
    }

    public Spot(Spot spot) {
        setXY(spot.getX(), spot.getY());
        setContent(spot.getContent());
    }


    public void setY(int y) {this.y = y;}
    public void setX(int x) {this.x = x;}
    public void setXY(int x, int y) {setX(x); setY(y);}
    public void setContent(Content content) {this.content = content;}


    public int getX() {return x;}
    public int getY() {return y;}
    public Content getContent() {return content;}
    public String toString() {return "Spot (" + y + ", " + x + ") " + content;}
}
