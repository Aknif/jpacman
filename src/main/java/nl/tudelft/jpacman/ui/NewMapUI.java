package nl.tudelft.jpacman.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NewMapUI extends JFrame {

    public int stage = 1;

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }
    public NewMapUI() {

        setSize(800, 600);
        setTitle("Stage Selection");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int buttonWidth = 116;
        int buttonHeight = 51;
        int buttonX = (frameWidth - buttonWidth) / 2;
        int buttonY = (frameHeight - buttonHeight) / 2;

        ImageIcon transparentIcon1 = new ImageIcon("src/main/resources/Button 116, 51 px/map 1 _ 116, 51 px.jpg");
        ImageIcon green1 = new ImageIcon("src/main/resources/Green Button/map 1  116, 51 px.png");

        ImageIcon transparentIcon2 = new ImageIcon("src/main/resources/Button 116, 51 px/map 2 _ 116, 51 px.jpg");
        ImageIcon green2 = new ImageIcon("src/main/resources/Green Button/map 2  116, 51 px.png");

        ImageIcon transparentIcon3 = new ImageIcon("src/main/resources/Button 116, 51 px/map 3 _ 116, 51 px.jpg");
        ImageIcon green3 = new ImageIcon("src/main/resources/Green Button/map 3  116, 51 px.png");

        ImageIcon transparentIcon4 = new ImageIcon("src/main/resources/Button 116, 51 px/map 4 _ 116, 51 px.jpg");
        ImageIcon green4 = new ImageIcon("src/main/resources/Green Button/map 4  116, 51 px.png");

        ImageIcon transparentIcon5 = new ImageIcon("src/main/resources/Button 116, 51 px/map 5 _ 116, 51 px.jpg");
        ImageIcon green5 = new ImageIcon("src/main/resources/Green Button/map 5  116, 51 px.png");

        ImageIcon transparentIcon6 = new ImageIcon("src/main/resources/Button 116, 51 px/back  116, 51 px.png");
        ImageIcon transparentIcon7 = new ImageIcon("src/main/resources/Button 116, 51 px/next _ 116, 51 px.jpg");
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/pacman_bg/Map_bg _ 800, 600 px.png"));

        ImageIcon map1Image = new ImageIcon("src/main/resources/Map/Map 1 _ 344, 315 px.jpg");
        ImageIcon map2Image = new ImageIcon("src/main/resources/Map/Map 2 _ 344, 315 px.jpg");
        ImageIcon map3Image = new ImageIcon("src/main/resources/Map/Map 3 _ 344, 315 px.jpg");
        ImageIcon map4Image = new ImageIcon("src/main/resources/Map/Map 4 _ 344, 315 px.jpg");
        ImageIcon map5Image = new ImageIcon("src/main/resources/Map/Map 5 _ 344, 315 px.jpg");

        JButton imageLabel = new JButton(map1Image);
        imageLabel.setSize(344,315);
        imageLabel.setBorderPainted(false);
        imageLabel.setContentAreaFilled(false);
        imageLabel.setFocusPainted(false);
        imageLabel.setBounds(400, 150, 344, 315);
        backgroundLabel.add(imageLabel);


        //Create button
        JButton Map1Button = new JButton(green1);
        Map1Button.setBorderPainted(false); // Remove the border
        Map1Button.setContentAreaFilled(false); // Remove the background color
        Map1Button.setFocusPainted(false); // Remove the focus border


        JButton Map2Button = new JButton(transparentIcon2);
        Map2Button.setBorderPainted(false);
        Map2Button.setContentAreaFilled(false);
        Map2Button.setFocusPainted(false);

        JButton Map3Button = new JButton(transparentIcon3);
        Map3Button.setBorderPainted(false);
        Map3Button.setContentAreaFilled(false);
        Map3Button.setFocusPainted(false);

        JButton Map4Button = new JButton(transparentIcon4);
        Map4Button.setBorderPainted(false);
        Map4Button.setContentAreaFilled(false);
        Map4Button.setFocusPainted(false);

        JButton Map5Button = new JButton(transparentIcon5);
        Map5Button.setBorderPainted(false);
        Map5Button.setContentAreaFilled(false);
        Map5Button.setFocusPainted(false);

        //Add action to button
        Map1Button.addActionListener(e -> {
            imageLabel.setIcon(map1Image);
            setStage(1);
            Map1Button.setIcon(green1);
            Map2Button.setIcon(transparentIcon2);
            Map3Button.setIcon(transparentIcon3);
            Map4Button.setIcon(transparentIcon4);
            Map5Button.setIcon(transparentIcon5);

        });

        Map2Button.addActionListener(e -> {
            imageLabel.setIcon(map2Image);
            setStage(2);
            Map1Button.setIcon(transparentIcon1);
            Map2Button.setIcon(green2);
            Map3Button.setIcon(transparentIcon3);
            Map4Button.setIcon(transparentIcon4);
            Map5Button.setIcon(transparentIcon5);
        });

        Map3Button.addActionListener(e -> {
            imageLabel.setIcon(map3Image);
            setStage(3);
            Map1Button.setIcon(transparentIcon1);
            Map2Button.setIcon(transparentIcon2);
            Map3Button.setIcon(green3);
            Map4Button.setIcon(transparentIcon4);
            Map5Button.setIcon(transparentIcon5);
        });

        Map4Button.addActionListener(e -> {
            imageLabel.setIcon(map4Image);
            setStage(4);
            Map1Button.setIcon(transparentIcon1);
            Map2Button.setIcon(transparentIcon2);
            Map3Button.setIcon(transparentIcon3);
            Map4Button.setIcon(green4);
            Map5Button.setIcon(transparentIcon5);
        });

        Map5Button.addActionListener(e -> {
            imageLabel.setIcon(map5Image);
            setStage(5);
            Map1Button.setIcon(transparentIcon1);
            Map2Button.setIcon(transparentIcon2);
            Map3Button.setIcon(transparentIcon3);
            Map4Button.setIcon(transparentIcon4);
            Map5Button.setIcon(green5);
        });


        JButton PreviousButton = new JButton(transparentIcon6);
        PreviousButton.setBorderPainted(false);
        PreviousButton.setContentAreaFilled(false);
        PreviousButton.setFocusPainted(false);

        PreviousButton.addActionListener(e -> {
            HomeUI homeUI = new HomeUI();
            dispose();
        });

        JButton NextButton = new JButton(transparentIcon7);
        NextButton.setBorderPainted(false);
        NextButton.setContentAreaFilled(false);
        NextButton.setFocusPainted(false);

        NextButton.addActionListener(e -> {
            newDifficultyUI difficultyUI = new newDifficultyUI(stage);
            difficultyUI.setVisible(true);
            dispose();
        });


        Map1Button.setBounds(buttonX-225, buttonY-120, buttonWidth, buttonHeight);
        backgroundLabel.add(Map1Button);

        Map2Button.setBounds(buttonX-225, buttonY-55, buttonWidth, buttonHeight);
        backgroundLabel.add(Map2Button);

        Map3Button.setBounds(buttonX-225, buttonY+10, buttonWidth, buttonHeight);
        backgroundLabel.add(Map3Button);

        Map4Button.setBounds(buttonX-225, buttonY+75, buttonWidth, buttonHeight);
        backgroundLabel.add(Map4Button);

        Map5Button.setBounds(buttonX-225, buttonY+140, buttonWidth, buttonHeight);
        backgroundLabel.add(Map5Button);

        PreviousButton.setBounds(buttonX-300, buttonY+250, buttonWidth, buttonHeight);
        backgroundLabel.add(PreviousButton);

        NextButton.setBounds(buttonX+300, buttonY+250, buttonWidth, buttonHeight);
        backgroundLabel.add(NextButton);

        add(backgroundLabel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new NewMapUI();
    }
}
