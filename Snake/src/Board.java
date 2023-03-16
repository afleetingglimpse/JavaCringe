package SnakeCringe;

import java.util.Random;

public class Board {
    public static final int DEFAULT_SIZE = 12;

    private int size = DEFAULT_SIZE;
    
    
    private Spot[][] spotArray= new Spot[size][size];

    private Snake snake;
    private boolean game = true;
    private int stepY = 1;
    private int stepX = 0; 

    public Board() {
        initBoard();
        initSnake();
        spawnFruit();
    }


    private void initBoard() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                spotArray[i][j] = new Spot(i, j, null);

                spotArray[0][j] = new Spot(i, j, new Border());
                spotArray[i][0] = new Spot(i, j, new Border());
                spotArray[size - 1][j] = new Spot(i, j, new Border());
                spotArray[i][size - 1] = new Spot(i, j, new Border());
            }
                
    }

    private void initSnake() {
        snake = new Snake();
        snake.getSegment(0).setX(DEFAULT_SIZE/2);
        snake.getSegment(0).setY(DEFAULT_SIZE/2);
        getSpot(DEFAULT_SIZE/2, DEFAULT_SIZE/2).setContent(snake.getSegment(0));
    }

    public void spawnFruit() {

        Random random = new Random();
        int y = random.nextInt(DEFAULT_SIZE - 1);
        int x = random.nextInt(DEFAULT_SIZE - 1);

        int loopCounter = 0;
        while (getSpot(y, x).getContent() != null) {

            if (loopCounter > Math.pow(DEFAULT_SIZE, 2))
                return;

            y = random.nextInt(DEFAULT_SIZE - 1);
            x = random.nextInt(DEFAULT_SIZE - 1);
            loopCounter++;
        }
        getSpot(y, x).setContent(new Fruit(y ,x));

    }

    public void setSize(int size) {this.size = size;}
    public void setSpot(int y, int x, Spot spot) {spotArray[y][x] = new Spot(spot);}
    public void setSnake(Snake snake) {this.snake = snake;}
    public void setGame(boolean game) {this.game = game;}
    public void setStepY(int stepY) {this.stepY = stepY;}
    public void setStepX(int stepX) {this.stepX = stepX;}
    
   
    public int getSize() {return size;}
    public Spot getSpot(int y, int x) {return spotArray[y][x];}
    public Snake getSnake() {return snake;}
    public Spot getSpot(Spot nextSpot) {return spotArray[nextSpot.getY()][nextSpot.getX()];}
    public boolean isGame() {return game;}
    public int getStepY() {return stepY;}
    public int getStepX() {return stepX;}


}
