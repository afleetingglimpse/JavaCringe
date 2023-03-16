package SnakeCringe;

public class Move {
    public static Board move(Board board, int stepY, int stepX) {
        board.setStepY(stepY);
        board.setStepX(stepX);
        Snake snake = new Snake(board.getSnake());
        Segment segment = snake.getSegment(0);
        Spot nextSpot = new Spot(board.getSpot(segment.getY() + stepY, segment.getX() + stepX));
        Spot lastSpot = null;
        if (nextSpot.getContent() == null || nextSpot.getContent() instanceof Fruit) {
            for (int i = 0; i < snake.getSize(); i++) {
                
                segment = snake.getSegment(i);
                if (i > 0) {
                    stepY = lastSpot.getY() - segment.getY();
                    stepX = lastSpot.getX() - segment.getX();
                }
                lastSpot = board.getSpot(segment.getY(), segment.getX());
                board.getSpot(segment.getY() + stepY, segment.getX() + stepX).setContent(segment);
                board.getSnake().getSegment(i).updateSegmentCoords(stepY, stepX);
                board.getSpot(lastSpot).setContent(null);
            }
            if (nextSpot.getContent() instanceof Fruit) {
                board.getSpot(lastSpot).setContent(new Body(lastSpot.getY(), lastSpot.getX()));
                board.getSnake().addSegment(lastSpot.getY(), lastSpot.getX());
                board.spawnFruit();
            }
        }

        // if next spot is not free or fruit
        else {
            if (nextSpot.getContent() instanceof Border || nextSpot.getContent() instanceof Body) {
                board.setGame(false);
            }
        }
        return board;
    }
}
