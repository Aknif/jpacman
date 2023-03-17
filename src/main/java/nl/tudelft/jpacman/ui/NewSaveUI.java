package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;


public class NewSaveUI extends JFrame {

    JTextField textField;
    public int finalscore = 10;
    private HashMap<String, Integer> scores = new HashMap<>();
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

        summitButton.setBounds(buttonX, buttonY+40, buttonWidth, buttonHeight); // Center the button
        backgroundLabel.add(summitButton);

        //Create JTextField
        JTextField textField = new JTextField(20);
        textField.setBounds(textFieldX, textFieldY, textFieldWidth, textFieldHeight);
        textField.setHorizontalAlignment(JTextField.CENTER);
        backgroundLabel.add(textField);

        add(backgroundLabel);
        setVisible(true);

        summitButton.addActionListener(e -> {
            String name = textField.getText();
            scores.put(name, finalscore);
            saveScoresToFile();
            JOptionPane.showMessageDialog(NewSaveUI.this, "Score saved successfully!");
            dispose();
        });


    }

    private void saveScoresToFile() {
        File fileToSave = new File("src/main/resources/score.jason");
        try {
            FileWriter writer = new FileWriter(fileToSave);
            writer.write(scores.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NewSaveUI Saveui = new NewSaveUI();
    }

}
