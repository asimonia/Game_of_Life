package life;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GameOfLife extends JFrame {

    public GameOfLife() throws InterruptedException {
        super("Game of Life");

        // Initialization
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setVisible(true);

        // Labels
        JLabel generationLabel = new JLabel();
        generationLabel.setFont(new Font("Arial", Font.BOLD, 18));
        generationLabel.setName("GenerationLabel");

        JLabel aliveLabel = new JLabel();
        aliveLabel.setFont(new Font("Arial", Font.BOLD, 18));
        aliveLabel.setName("AliveLabel");

        // Grid
        Grid grid = new Grid();
        grid.setName("GridPanel");

        // Buttons
        ImageIcon resetButtonIcon = createImageIcon("images/reset.png");
        ResetButton resetButton = new ResetButton(resetButtonIcon);
        resetButton.setName("ResetButton");

        ImageIcon pauseButtonIcon = createImageIcon("images/pause.png");
        PauseButton pauseButton = new PauseButton(pauseButtonIcon);
        pauseButton.setName("PlayToggleButton");

        add(resetButton);
        add(pauseButton);
        add(generationLabel);
        add(aliveLabel);
        add(grid);


        // draw the board
        Universe universe = new Universe(100);
        int generations = 500;

        for (int i = 1; i <= generations; i++) {
            generationLabel.setText("Generation #" + i);
            aliveLabel.setText("Alive: " + universe.countAlive());
            grid.setUniverse(universe);
            grid.repaint();
            universe = Generation.next(universe);
            Generation.sleep();
        }


    }

    protected static ImageIcon createImageIcon(String path) {
        URL imgURL = GameOfLife.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}