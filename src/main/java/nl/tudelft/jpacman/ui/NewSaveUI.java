package nl.tudelft.jpacman.ui;

import javax.swing.*;

public class NewSaveUI extends JFrame {
    public NewSaveUI(){
        setSize(600, 380);
        setTitle("Save");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int buttonWidth = 210;
        int buttonHeight = 58;
        int buttonX = (frameWidth - buttonWidth) / 2;
        int buttonY = (frameHeight / 2 + 20) - buttonHeight / 2;
        int textFieldWidth = 400;
        int textFieldHeight = 40;
        int textFieldX = (frameWidth - textFieldWidth) / 2;
        int textFieldY = buttonY - 40;

        ImageIcon transparentIcon1 = new ImageIcon("src/main/resources/SummitButton/Summit Button210x58.png");

        //Create Button
        JButton summitButton = new JButton(transparentIcon1);
        summitButton.setBorderPainted(false); // Remove the border
        summitButton.setContentAreaFilled(false); // Remove the background color
        summitButton.setFocusPainted(false); // Remove the focus border

        //add BG image
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/pacman_bg/FinalScore_600x350.png"));

        summitButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight); // Center the button
        backgroundLabel.add(summitButton);

        //Create JTextField
        JTextField textField = new JTextField();
        textField.setBounds(textFieldX, textFieldY, textFieldWidth, textFieldHeight);
        textField.setHorizontalAlignment(JTextField.CENTER);
        backgroundLabel.add(textField);

        add(backgroundLabel);
        setVisible(true);

    }
    public static void main(String[] args) {
        NewSaveUI Saveui = new NewSaveUI();
    }

}
