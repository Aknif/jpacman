package nl.tudelft.jpacman.ui;

import com.google.gson.Gson;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import top.jfunc.json.impl.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


public class SaveUI extends JFrame {

    JTextField textField;
    private List<Score> scores = new ArrayList<Score>();
    private Pellet pellet;
    int score = 10;
    public SaveUI(){
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
        JButton summitButton = new JButton("SUBMIT");
        /*summitButton.setBorderPainted(false); // Remove the border
        summitButton.setContentAreaFilled(false); // Remove the background color
        summitButton.setFocusPainted(false); // Remove the focus border
         */
        summitButton.setFont(new Font("Arial", Font.PLAIN, 20));



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
            int score = Player.getScore();

            JSONObject json = new JSONObject();
            json.put("name", name);
            json.put("score", score);

            try (RandomAccessFile file = new RandomAccessFile("scores.json", "rw")) {
                long length = file.length();
                if (length > 0) {
                    file.seek(length - 1); // move file pointer to last byte
                    byte lastByte = file.readByte();
                    if (lastByte == ']') {
                        file.seek(length - 1); // move file pointer back one byte
                        file.writeBytes(","); // write comma separator
                    } else {
                        file.seek(length); // move file pointer to end of file
                    }
                } else {
                    file.writeBytes("["); // write opening bracket
                }
                file.writeBytes(json.toString()); // write JSON object
                file.writeBytes("]"); // write closing bracket
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            JOptionPane.showMessageDialog(SaveUI.this, "Score saved successfully!");
            Window[] windows = Window.getWindows();
            for (Window window : windows) {
                if (window instanceof JFrame) {
                    window.dispose();
                }
            }
            HomeUI homeUI = new HomeUI();
            dispose();
        });


    }



    private static class Score {
        private String name;
        private int score;

        public Score(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }
    public static void main(String[] args) {
        SaveUI Saveui = new SaveUI();
    }

}
