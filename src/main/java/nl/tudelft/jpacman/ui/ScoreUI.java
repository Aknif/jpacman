package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.level.Player;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ScoreUI extends JFrame {
    private JLabel scoreLabel;
    private int score;


    public ScoreUI() {
        // Initialize the ScoreUI screen
        setTitle("Score");
        setSize(200, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the score and add a JLabel to display it
        score = 0;
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        add(scoreLabel, BorderLayout.CENTER);
    }

    public void updateScore(int points) {
        // Update the score and update the JLabel to display it
        score += points;
        scoreLabel.setText("Score: " + score);
    }
}

