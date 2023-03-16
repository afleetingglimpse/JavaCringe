package SnakeCringe;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame implements ActionListener, KeyListener{
    private JFrame frame;
    private JPanel panel;
    private Board board;
    private GridLayout buttonGrid;
    private boolean buttonClicked = false;

    private static final int DEFAULT_BUTTON_GAP_Y = 1;
    private static final int DEFAULT_BUTTON_GAP_X = 1;

    public GameFrame(Board board, String name, int width, int height) {
        setupFrame(board, name, width, height);
    }

    private void setupFrame(Board board, String name, int width, int height) {
        frame = new JFrame();
        panel = new JPanel();
        frame.setName(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        this.board = board;
        buttonGrid = new GridLayout(board.getSize(), board.getSize(), DEFAULT_BUTTON_GAP_Y, DEFAULT_BUTTON_GAP_X);
        panel.setBounds(0, 0, width, height);
        initButtons();
        frame.add(panel);
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setVisible(true);
    }

    private void initButtons() {
        for (int i = 0; i < board.getSize(); i++)
            for (int j = 0; j < board.getSize(); j++) {
                Button button = new Button(board.getSpot(i, j));

                try {
                    button.setIcon(new ImageIcon(button.getSpot().getContent().getImage()));
                }

                catch (NullPointerException e) {
                    button.setIcon(null);
                    if (button.getSpot().getContent() != null)
                        button.setBackground(new Color(0, 0, 0));

                    if (button.getSpot().getContent() instanceof Head)
                        button.setBackground(new Color(0, 155, 0));

                    if (button.getSpot().getContent() instanceof Body)
                        button.setBackground(new Color(0, 100, 0));

                    if (button.getSpot().getContent() instanceof Fruit)
                        button.setBackground(new Color(100, 0, 0));

                    if (button.getSpot().getContent() instanceof Border)
                        button.setBackground(new Color(0, 0, 0));
                }

                button.addActionListener(this);
                panel.add(button);
            }
        panel.setLayout(buttonGrid);
    }

    private void update() {
        panel.removeAll();

        if (board.isGame()) {
            initButtons();
            frame.add(panel);
        }

        else {
            gameOver();
        }
        frame.setVisible(true);
    }


    private void gameOver() {
        System.out.println("Game Over");
    }


    public void run() {
        Timer timer = new Timer(500, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!buttonClicked)
                    Move.move(board, board.getStepY(), board.getStepX());
                update();
                buttonClicked = false;
                if (!board.isGame())
                    return;
            }
        });

        while (board.isGame())
            timer.start();
        timer.stop();
    }




    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (board.isGame()) {
            if (e.getKeyChar() == 'w') 
                Move.move(board, -1, 0);
        
            if (e.getKeyChar() == 'd') 
                Move.move(board, 0, 1);
                
            if (e.getKeyChar() == 's') 
                Move.move(board, 1, 0);

            if (e.getKeyChar() == 'a') 
                Move.move(board, 0, -1);

            buttonClicked = true;
            // update();
        }     
    }

    @Override
    public void keyReleased(KeyEvent e) {}


    @Override
    public void actionPerformed(ActionEvent e) {
        Button btn = (Button)e.getSource();
        System.out.println(btn.getSpot());
        update();
    }
    
}
