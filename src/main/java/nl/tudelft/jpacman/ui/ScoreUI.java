package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;

public class ScoreUI extends JFrame {
    private JLabel scoreLabel;
    private int score;


    public ScoreUI() {
        // Initialize the ScoreUI screen
        setTitle("Score");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int buttonWidth = 116;
        int buttonHeight = 51;
        int buttonX = frameWidth - buttonWidth;
        int buttonY = frameHeight - buttonHeight;

        ImageIcon transparentIcon = new ImageIcon("src/main/resources/Button 116, 51 px/back  116, 51 px.png");
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/pacman_bg/Score_bg  800, 600 px.png"));

        JButton BackButton = new JButton(transparentIcon);
        BackButton.setBorderPainted(false);
        BackButton.setContentAreaFilled(false);
        BackButton.setFocusPainted(false);

        BackButton.addActionListener(e -> {
            HomeUI homeUI = new HomeUI();
            dispose();
        });

        BackButton.setBounds(buttonX-640, buttonY-25, buttonWidth, buttonHeight);
        backgroundLabel.add(BackButton);

        add(backgroundLabel);

        pack();
        setVisible(true);

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
    public static void main(String[] args){
        ScoreUI scoreUI = new ScoreUI();
    }
}


