package nl.tudelft.jpacman.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NewMapUI extends JFrame {

    public int stage = 0;

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
        ImageIcon transparentIcon2 = new ImageIcon("src/main/resources/Button 116, 51 px/map 2 _ 116, 51 px.jpg");
        ImageIcon transparentIcon3 = new ImageIcon("src/main/resources/Button 116, 51 px/map 3 _ 116, 51 px.jpg");
        ImageIcon transparentIcon4 = new ImageIcon("src/main/resources/Button 116, 51 px/map 4 _ 116, 51 px.jpg");
        ImageIcon transparentIcon5 = new ImageIcon("src/main/resources/Button 116, 51 px/map 5 _ 116, 51 px.jpg");
        ImageIcon transparentIcon6 = new ImageIcon("src/main/resources/Button 116, 51 px/perv _ 116, 51 px.jpg");
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



        JButton Map1Button = new JButton(transparentIcon1);
        Map1Button.setBorderPainted(false); // Remove the border
        Map1Button.setContentAreaFilled(false); // Remove the background color
        Map1Button.setFocusPainted(false); // Remove the focus border

        Map1Button.addActionListener(e -> {
            imageLabel.setIcon(map1Image);
            setStage(1);

        });

        JButton Map2Button = new JButton(transparentIcon2);
        Map2Button.setBorderPainted(false);
        Map2Button.setContentAreaFilled(false);
        Map2Button.setFocusPainted(false);

        Map2Button.addActionListener(e -> {
            imageLabel.setIcon(map2Image);
            setStage(2);

        });

        JButton Map3Button = new JButton(transparentIcon3);
        Map3Button.setBorderPainted(false);
        Map3Button.setContentAreaFilled(false);
        Map3Button.setFocusPainted(false);

        Map3Button.addActionListener(e -> {
            imageLabel.setIcon(map3Image);
            setStage(3);

        });


        JButton Map4Button = new JButton(transparentIcon4);
        Map4Button.setBorderPainted(false);
        Map4Button.setContentAreaFilled(false);
        Map4Button.setFocusPainted(false);

        Map4Button.addActionListener(e -> {
            imageLabel.setIcon(map4Image);
            setStage(4);

        });


        JButton Map5Button = new JButton(transparentIcon5);
        Map5Button.setBorderPainted(false);
        Map5Button.setContentAreaFilled(false);
        Map5Button.setFocusPainted(false);

        Map5Button.addActionListener(e -> {
            imageLabel.setIcon(map5Image);
            setStage(5);

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




        Map1Button.setBounds(buttonX-240, buttonY-150, buttonWidth, buttonHeight);
        backgroundLabel.add(Map1Button);

        Map2Button.setBounds(buttonX-240, buttonY-80, buttonWidth, buttonHeight);
        backgroundLabel.add(Map2Button);

        Map3Button.setBounds(buttonX-240, buttonY-10, buttonWidth, buttonHeight);
        backgroundLabel.add(Map3Button);

        Map4Button.setBounds(buttonX-240, buttonY+60, buttonWidth, buttonHeight);
        backgroundLabel.add(Map4Button);

        Map5Button.setBounds(buttonX-240, buttonY+130, buttonWidth, buttonHeight);
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
