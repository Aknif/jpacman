package nl.tudelft.jpacman.ui;

import javax.swing.*;

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

        JButton RetryButton = new JButton(transparentIcon1);
        RetryButton.setBorderPainted(false); // Remove the border
        RetryButton.setContentAreaFilled(false); // Remove the background color
        RetryButton.setFocusPainted(false); // Remove the focus border

        JButton MainButton = new JButton(transparentIcon2);
        MainButton.setBorderPainted(false); // Remove the border
        MainButton.setContentAreaFilled(false); // Remove the background color
        MainButton.setFocusPainted(false); // Remove the focus border

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
