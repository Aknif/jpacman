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

        JButton invisibleButton1 = new JButton(transparentIcon1);
        invisibleButton1.setBorderPainted(false); // Remove the border
        invisibleButton1.setContentAreaFilled(false); // Remove the background color
        invisibleButton1.setFocusPainted(false); // Remove the focus border

        invisibleButton1.addActionListener(e -> {
            NewMapUI newMapUI = new NewMapUI();
            newMapUI.setVisible(true);
            dispose();
        });

        JButton invisibleButton2 = new JButton(transparentIcon2);
        invisibleButton2.setBorderPainted(false);
        invisibleButton2.setContentAreaFilled(false);
        invisibleButton2.setFocusPainted(false);

        invisibleButton2.addActionListener(e -> {
            NewMapUI newMapUI = new NewMapUI();
            newMapUI.setVisible(true);
            dispose();
        });

        JButton invisibleButton3 = new JButton(transparentIcon3);
        invisibleButton3.setBorderPainted(false);
        invisibleButton3.setContentAreaFilled(false);
        invisibleButton3.setFocusPainted(false);

        invisibleButton3.addActionListener(e -> {
            ScoreUI scoreUI = new ScoreUI();
            scoreUI.setVisible(true);
            dispose();
        });

        invisibleButton1.setBounds(buttonX, buttonY-20, buttonWidth, buttonHeight);
        backgroundLabel.add(invisibleButton1);

        invisibleButton2.setBounds(buttonX, buttonY+50, buttonWidth, buttonHeight);
        backgroundLabel.add(invisibleButton2);

        invisibleButton3.setBounds(buttonX, buttonY+120, buttonWidth, buttonHeight);
        backgroundLabel.add(invisibleButton3);
        add(backgroundLabel);



        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new HomeUI();
    }
}
