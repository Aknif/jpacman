package nl.tudelft.jpacman.ui;

import top.jfunc.json.impl.JSONArray;
import top.jfunc.json.impl.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class ScoreUI extends JFrame {
    private JLabel topScoresLabel;

    public ScoreUI(){

        setTitle("Score");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int buttonWidth = 116;
        int buttonHeight = 51;
        int buttonX = frameWidth - buttonWidth;
        int buttonY = frameHeight - buttonHeight;

        // Load background image
        ImageIcon backgroundImage = new ImageIcon("src/main/resources/pacman_bg/Score_bg  800, 600 px.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);


        ImageIcon transparentIcon = new ImageIcon("src/main/resources/Button 116, 51 px/back  116, 51 px.png");

        JButton BackButton = new JButton(transparentIcon);
        BackButton.setBorderPainted(false);
        BackButton.setContentAreaFilled(false);
        BackButton.setFocusPainted(false);

        BackButton.addActionListener(e -> {
            HomeUI homeUI = new HomeUI();
            dispose();
        });

        BackButton.setBounds(buttonX-640, buttonY-25, buttonWidth, buttonHeight);
        backgroundLabel.add(BackButton);

        add(backgroundLabel);

        // Load top scores from JSON file
        JSONArray scoresArray = null;
        try {
            String jsonString = new Scanner(new File("scores.json")).useDelimiter("\\Z").next();
            scoresArray = new JSONArray(jsonString);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Sort scores in descending order
        List<JSONObject> scoreList = new ArrayList<>();
        for (int i = 0; i < scoresArray.size(); i++) {
            scoreList.add((JSONObject) scoresArray.getJsonObject(i));
        }
        Collections.sort(scoreList, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject o1, JSONObject o2) {
                int score1 = o1.getInteger("score");
                int score2 = o2.getInteger("score");
                return Integer.compare(score2, score1);
            }
        });

        // Display top 5 scores in JLabel
        StringBuilder sb = new StringBuilder("<html><center><font size=5><b></b></font><br><br>");
        int count = 0;
        for (JSONObject scoreObj : scoreList) {
            sb.append(scoreObj.getString("name")).append(": ").append(scoreObj.getInteger("score")).append("<br>");
            count++;
            if (count == 5) {
                break;
            }
        }
        sb.append("</center></html>");
        topScoresLabel = new JLabel(sb.toString());
        topScoresLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        topScoresLabel.setForeground(Color.WHITE);
        topScoresLabel.setHorizontalAlignment(JLabel.CENTER);
        topScoresLabel.setVerticalAlignment(JLabel.CENTER);
        backgroundLabel.add(topScoresLabel);

        // Set JFrame properties


        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new ScoreUI();
    }
}
