package SnakeCringe;
import java.util.ArrayList;

public class Snake {
    
    //private Head head;
    private ArrayList<Segment> segments = new ArrayList<>();

    public Snake() {
        Head head = new Head(0, 0);
        segments.add(head);
    }

    public Snake(Snake snake) {
        segments.addAll(snake.segments);
    }

    public void addSegment(int y, int x) {segments.add(new Body(y, x));}
    

    public int getSize() {return segments.size();}
    public Segment getSegment(int index) {return segments.get(index);}
}
