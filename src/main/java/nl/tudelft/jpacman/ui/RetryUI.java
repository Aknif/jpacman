package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;

public class RetryUI extends JFrame {
    public RetryUI() {


        setSize(300, 400);
        setTitle("Save");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int buttonWidth = 266;
        int buttonHeight = 58;
        int buttonX = (frameWidth - buttonWidth) / 2;
        int buttonY = (frameHeight - buttonHeight) / 2;


        ImageIcon transparentIcon1 = new ImageIcon("src/main/resources/Button 266, 58 px/Retry  266, 58 px.png");
        ImageIcon transparentIcon2 = new ImageIcon("src/main/resources/Button 266, 58 px/Main Menu  266, 58 px.png");

        //add BG image
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/pacman_bg/Retry 300,400px.png"));

        JButton RetryButton = new JButton("Retry");
        //RetryButton.setBorderPainted(false); // Remove the border
        RetryButton.setContentAreaFilled(false); // Remove the background color
        RetryButton.setFocusPainted(false); // Remove the focus border

        RetryButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        RetryButton.setForeground(Color.WHITE);

        RetryButton.addActionListener(e -> {
            Window[] windows = Window.getWindows();
            for (Window window : windows) {
                if (window instanceof JFrame) {
                    window.dispose();
                }
            }
            new Launcher().launch();
            dispose();
        });

        JButton MainButton = new JButton("Main Menu");
        //MainButton.setBorderPainted(false); // Remove the border
        MainButton.setContentAreaFilled(false); // Remove the background color
        MainButton.setFocusPainted(false); // Remove the focus border
        MainButton.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        MainButton.setForeground(Color.WHITE);
        MainButton.addActionListener(e -> {
            SaveUI saveUI = new SaveUI();
            dispose();
        });

        RetryButton.setBounds(buttonX -9, buttonY, buttonWidth, buttonHeight);
        backgroundLabel.add(RetryButton);

        MainButton.setBounds(buttonX-9, buttonY+100, buttonWidth, buttonHeight);
        backgroundLabel.add(MainButton);
        add(backgroundLabel);

        add(backgroundLabel);
        setVisible(true);



    }

    public static void main(String[] args) {
        RetryUI RetryUI = new RetryUI();
    }



}
