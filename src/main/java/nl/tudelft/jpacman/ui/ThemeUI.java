package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.sprite.PacManSprites;

import javax.swing.*;

public class ThemeUI extends JFrame {



    int defaultTheme = 1;

    public ThemeUI(int stage) {


        setSize(800, 600);
        setTitle("Theme Selection");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int buttonWidth = 266;
        int buttonHeight = 58;
        int buttonX = (frameWidth - buttonWidth) / 2;
        int buttonY = (frameHeight - buttonHeight) / 2;

        ImageIcon transparentIcon1 = new ImageIcon("src/main/resources/Button 266, 58 px/Vivid 266, 58 px.png");

        ImageIcon transparentIcon2 = new ImageIcon("src/main/resources/Button 266, 58 px/music  266, 58 px.png");

        ImageIcon transparentIcon3 = new ImageIcon("src/main/resources/Button 266, 58 px/space 266, 58px.png");

        ImageIcon transparentIcon4 = new ImageIcon("src/main/resources/Button 116, 51 px/back  116, 51 px.png");
        ImageIcon transparentIcon5 = new ImageIcon("src/main/resources/Button 116, 51 px/next _ 116, 51 px.jpg");

        JLabel backgroundLabel = new JLabel(new ImageIcon("src/main/resources/pacman_bg/Themes_BG_800x600 px.png"));

        ImageIcon VividImage = new ImageIcon("src/main/resources/Description 330,303 px/theme.png");
        ImageIcon CityImage = new ImageIcon("src/main/resources/Description 330,303 px/theme3.png");
        ImageIcon SpaceImage = new ImageIcon("src/main/resources/Description 330,303 px/theme2.png");

        JButton imageLabel = new JButton(VividImage);
        imageLabel.setSize(330,303);
        imageLabel.setBorderPainted(false);
        imageLabel.setContentAreaFilled(false);
        imageLabel.setFocusPainted(false);
        imageLabel.setBounds(400, 150, 330, 303);
        backgroundLabel.add(imageLabel);

        //Create button
        JButton VividButton = new JButton(transparentIcon1);
        VividButton.setBorderPainted(false); // Remove the border
        VividButton.setContentAreaFilled(false); // Remove the background color
        VividButton.setFocusPainted(false); // Remove the focus border

        JButton CityButton = new JButton(transparentIcon2);
        CityButton.setBorderPainted(false);
        CityButton.setContentAreaFilled(false);
        CityButton.setFocusPainted(false);

        JButton SpaceButton = new JButton(transparentIcon3);
        SpaceButton.setBorderPainted(false);
        SpaceButton.setContentAreaFilled(false);
        SpaceButton.setFocusPainted(false);

        //Add action to button
        VividButton.addActionListener(e -> {
            imageLabel.setIcon(VividImage);
            PacManSprites.themeNUM=1;
        });

        CityButton.addActionListener(e -> {
            imageLabel.setIcon(CityImage);
            PacManSprites.themeNUM=2;
        });

        SpaceButton.addActionListener(e -> {
            imageLabel.setIcon(SpaceImage);
            PacManSprites.themeNUM=3;
        });

        JButton PreviousButton = new JButton(transparentIcon4);
        PreviousButton.setBorderPainted(false);
        PreviousButton.setContentAreaFilled(false);
        PreviousButton.setFocusPainted(false);
        PreviousButton.addActionListener(e -> {
            newDifficultyUI diffUI = new newDifficultyUI(stage);
            dispose();
        });

        JButton NextButton = new JButton(transparentIcon5);
        NextButton.setBorderPainted(false);
        NextButton.setContentAreaFilled(false);
        NextButton.setFocusPainted(false);
        NextButton.addActionListener(e -> {
            new Launcher().launch();
            dispose();
            });


        VividButton.setBounds(buttonX-200, buttonY-75, buttonWidth, buttonHeight);
        backgroundLabel.add(VividButton);

        CityButton.setBounds(buttonX-200, buttonY, buttonWidth, buttonHeight);
        backgroundLabel.add(CityButton);

        SpaceButton.setBounds(buttonX-200, buttonY+75, buttonWidth, buttonHeight);
        backgroundLabel.add(SpaceButton);

        PreviousButton.setBounds(buttonX-300, buttonY+250, buttonWidth, buttonHeight);
        backgroundLabel.add(PreviousButton);

        NextButton.setBounds(buttonX+300, buttonY+250, buttonWidth, buttonHeight);
        backgroundLabel.add(NextButton);

        add(backgroundLabel);

        pack();
        setVisible(true);
    }

    public int getDefaultTheme() {
        return defaultTheme;
    }

    public void setDefaultTheme(int defaultTheme) {
        this.defaultTheme = defaultTheme;
    }

    public static void main(String[] args) {
        new ThemeUI(1);
    }

}
