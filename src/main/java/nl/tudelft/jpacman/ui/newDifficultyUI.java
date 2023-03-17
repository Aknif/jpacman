package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class newDifficultyUI extends JFrame {

    private int defaultDiff = 1;

    public newDifficultyUI(int stage) {

        setSize(800, 600);
        setTitle("Difficulty Selection");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int buttonWidth = 266;
        int buttonHeight = 58;
        int buttonX = (frameWidth - buttonWidth) / 2;
        int buttonY = (frameHeight - buttonHeight) / 2;

        ImageIcon transparentIcon1 = new ImageIcon("src/main/resources/Button 266, 58 px/easy _ 266, 58 px.jpg");
        ImageIcon greenE = new ImageIcon("src/main/resources/Green Button/easy  266, 58 px.png");

        ImageIcon transparentIcon2 = new ImageIcon("src/main/resources/Button 266, 58 px/normal _ 266, 58 px.jpg");
        ImageIcon greenN = new ImageIcon("src/main/resources/Green Button/normal  266, 58 px.png");

        ImageIcon transparentIcon3 = new ImageIcon("src/main/resources/Button 266, 58 px/hard _ 266, 58 px.jpg");
        ImageIcon greenH = new ImageIcon("src/main/resources/Green Button/hard  266, 58 px.png");

        ImageIcon transparentIcon4 = new ImageIcon("src/main/resources/Button 116, 51 px/perv _ 116, 51 px.jpg");
        ImageIcon transparentIcon5 = new ImageIcon("src/main/resources/Button 116, 51 px/next _ 116, 51 px.jpg");
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/pacman_bg/Difficulty_bg _ 800, 600 px.png"));

        ImageIcon easyImage = new ImageIcon("src/main/resources/Description 316, 234 px/easy.jpg");
        ImageIcon normalImage = new ImageIcon("src/main/resources/Description 316, 234 px/normal.jpg");
        ImageIcon hardImage = new ImageIcon("src/main/resources/Description 316, 234 px/hard.jpg");


        JButton imageLabel = new JButton(normalImage);
        imageLabel.setSize(344,315);
        imageLabel.setBorderPainted(false);
        imageLabel.setContentAreaFilled(false);
        imageLabel.setFocusPainted(false);
        imageLabel.setBounds(400, 150, 344, 315);
        backgroundLabel.add(imageLabel);

        //Create Button
        JButton easyButton = new JButton(transparentIcon1);
        easyButton.setBorderPainted(false); // Remove the border
        easyButton.setContentAreaFilled(false); // Remove the background color
        easyButton.setFocusPainted(false); // Remove the focus border

        JButton normalButton = new JButton(greenN);
        normalButton.setBorderPainted(false);
        normalButton.setContentAreaFilled(false);
        normalButton.setFocusPainted(false);

        JButton hardButton = new JButton(transparentIcon3);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);


        //Add action when click button
        easyButton.addActionListener(e -> {
            imageLabel.setIcon(easyImage);
            if(stage==1){
                new Launcher().DYNAMIC_MAP = "/board1E.txt";
            }
            else if(stage==2){
                new Launcher().DYNAMIC_MAP = "/board2E.txt";
            }
            else if(stage==3){
                new Launcher().DYNAMIC_MAP = "/board3E.txt";
            }
            else if(stage==4){
                new Launcher().DYNAMIC_MAP = "/board4E.txt";
            }
            else if(stage==5){
                new Launcher().DYNAMIC_MAP = "/board5E.txt";
            }
            defaultDiff = 0;
            easyButton.setIcon(greenE);
            normalButton.setIcon(transparentIcon2);
            hardButton.setIcon(transparentIcon3);
        });

        normalButton.addActionListener(e -> {
            imageLabel.setIcon(normalImage);
            if(stage==1){
                new Launcher().DYNAMIC_MAP = "/board1N.txt";
            }
            else if(stage==2){
                new Launcher().DYNAMIC_MAP = "/board2N.txt";
            }
            else if(stage==3){
                new Launcher().DYNAMIC_MAP = "/board3N.txt";
            }
            else if(stage==4){
                new Launcher().DYNAMIC_MAP = "/board4N.txt";
            }
            else if(stage==5){
                new Launcher().DYNAMIC_MAP = "/board5N.txt";
            }
            defaultDiff = 0;
            easyButton.setIcon(transparentIcon1);
            normalButton.setIcon(greenN);
            hardButton.setIcon(transparentIcon3);
        });

        hardButton.addActionListener(e -> {
            imageLabel.setIcon(hardImage);
            if(stage==1){
                new Launcher().DYNAMIC_MAP = "/board1H.txt";
            }
            else if(stage==2){
                new Launcher().DYNAMIC_MAP = "/board2H.txt";
            }
            else if(stage==3){
                new Launcher().DYNAMIC_MAP = "/board3H.txt";
            }
            else if(stage==4){
                new Launcher().DYNAMIC_MAP = "/board4H.txt";
            }
            else if(stage==5){
                new Launcher().DYNAMIC_MAP = "/board5H.txt";
            }
            defaultDiff = 0;
            easyButton.setIcon(transparentIcon1);
            normalButton.setIcon(transparentIcon2);
            hardButton.setIcon(greenH);
        });

        JButton PreviousButton = new JButton(transparentIcon4);
        PreviousButton.setBorderPainted(false);
        PreviousButton.setContentAreaFilled(false);
        PreviousButton.setFocusPainted(false);

        PreviousButton.addActionListener(e -> {
            NewMapUI mapUI = new NewMapUI();
            dispose();
        });

        JButton NextButton = new JButton(transparentIcon5);
        NextButton.setBorderPainted(false);
        NextButton.setContentAreaFilled(false);
        NextButton.setFocusPainted(false);

        NextButton.addActionListener(e -> {
            if(defaultDiff == 1){
                if(stage==1){
                    new Launcher().DYNAMIC_MAP = "/board1N.txt";
                }
                else if(stage==2){
                    new Launcher().DYNAMIC_MAP = "/board2N.txt";
                }
                else if(stage==3){
                    new Launcher().DYNAMIC_MAP = "/board3N.txt";
                }
                else if(stage==4){
                    new Launcher().DYNAMIC_MAP = "/board4N.txt";
                }
                else if(stage==5){
                    new Launcher().DYNAMIC_MAP = "/board5N.txt";
                }
                new Launcher().launch();
                dispose();
            }
            else {
                new Launcher().launch();
                dispose();
            }
        });


        easyButton.setBounds(buttonX-225, buttonY-75, buttonWidth, buttonHeight);
        backgroundLabel.add(easyButton);

        normalButton.setBounds(buttonX-225, buttonY, buttonWidth, buttonHeight);
        backgroundLabel.add(normalButton);

        hardButton.setBounds(buttonX-225, buttonY+75, buttonWidth, buttonHeight);
        backgroundLabel.add(hardButton);

        PreviousButton.setBounds(buttonX-300, buttonY+250, buttonWidth, buttonHeight);
        backgroundLabel.add(PreviousButton);

        NextButton.setBounds(buttonX+300, buttonY+250, 116, 51);
        backgroundLabel.add(NextButton);


        add(backgroundLabel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new newDifficultyUI(1);
    }
}
