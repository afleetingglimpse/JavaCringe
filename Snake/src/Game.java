package SnakeCringe;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        GameFrame gameFrame = new GameFrame(board, "null", 800, 600);
        gameFrame.run();
    }
}
