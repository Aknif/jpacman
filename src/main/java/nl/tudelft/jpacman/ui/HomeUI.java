package nl.tudelft.jpacman.ui;

import java.awt.*;
import javax.swing.*;

public class HomeUI extends JFrame {
    public HomeUI() {

        setSize(800, 600);
        setTitle("Main Menu");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int buttonWidth = 266;
        int buttonHeight = 58;
        int buttonX = (frameWidth - buttonWidth) / 2;
        int buttonY = (frameHeight - buttonHeight) / 2;

        ImageIcon transparentIcon1 = new ImageIcon("src/main/resources/Button 266, 58 px/casual _ 266, 58 px.jpg");
        ImageIcon transparentIcon2 = new ImageIcon("src/main/resources/Button 266, 58 px/endless _ 266, 58 px.jpg");
        ImageIcon transparentIcon3 = new ImageIcon("src/main/resources/Button 266, 58 px/score _ 266, 58 px.jpg");
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/pacman_bg/Main_bg _ 800, 600 px.png"));

        JButton CasualButton = new JButton(transparentIcon1);
        CasualButton.setBorderPainted(false); // Remove the border
        CasualButton.setContentAreaFilled(false); // Remove the background color
        CasualButton.setFocusPainted(false); // Remove the focus border

        CasualButton.addActionListener(e -> {
            NewMapUI newMapUI = new NewMapUI();
            newMapUI.setVisible(true);
            dispose();
        });

        JButton EndlessButton = new JButton(transparentIcon2);
        EndlessButton.setBorderPainted(false);
        EndlessButton.setContentAreaFilled(false);
        EndlessButton.setFocusPainted(false);

        EndlessButton.addActionListener(e -> {
            NewMapUI newMapUI = new  NewMapUI();
            newMapUI.setVisible(true);
            dispose();
        });

        JButton ScoreButton = new JButton(transparentIcon3);
        ScoreButton.setBorderPainted(false);
        ScoreButton.setContentAreaFilled(false);
        ScoreButton.setFocusPainted(false);

        ScoreButton.addActionListener(e -> {
            ScoreUI scoreUI = new ScoreUI();
            scoreUI.setVisible(true);
            dispose();
        });

        CasualButton.setBounds(buttonX, buttonY-20, buttonWidth, buttonHeight);
        backgroundLabel.add(CasualButton);

        EndlessButton.setBounds(buttonX, buttonY+50, buttonWidth, buttonHeight);
        backgroundLabel.add(EndlessButton);

        ScoreButton.setBounds(buttonX, buttonY+120, buttonWidth, buttonHeight);
        backgroundLabel.add(ScoreButton);
        add(backgroundLabel);



        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new HomeUI();
    }
}
