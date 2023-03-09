package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class newDifficultyUI extends JFrame implements ActionListener {

    private JButton easyButton, normalButton, hardButton, nextButton, prevButton;
    private JLabel imageLabel;
    private ImageIcon easyImage, normalImage, hardImage;

    public newDifficultyUI() {
        // Set up the JFrame
        setTitle("Difficulty");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        // Load the image file into an ImageIcon
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\phudiskey\\Desktop\\Pacman2\\jpacman\\src\\main\\resources\\pacman_bg\\Difficulty_bg _ 800, 600 px.png");

        // Create a new JLabel with the image as the icon
        JLabel backgroundLabel = new JLabel(imageIcon);

        // Set the size and position of the label to fill the JFrame
        backgroundLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        // Set the label as the content pane of the JFrame
        add(backgroundLabel);

        // Set up the buttons
        easyButton = new JButton(new ImageIcon("C:\\Users\\phudiskey\\Desktop\\Pacman2\\jpacman\\src\\main\\resources\\Button 266, 58 px\\easy _ 266, 58 px.jpg"));
        normalButton = new JButton(new ImageIcon("C:\\Users\\phudiskey\\Desktop\\Pacman2\\jpacman\\src\\main\\resources\\Button 266, 58 px\\normal _ 266, 58 px.jpg"));
        hardButton = new JButton(new ImageIcon("C:\\Users\\phudiskey\\Desktop\\Pacman2\\jpacman\\src\\main\\resources\\Button 266, 58 px\\hard _ 266, 58 px.jpg"));
        prevButton = new JButton(new ImageIcon("C:\\Users\\phudiskey\\Desktop\\Pacman2\\jpacman\\src\\main\\resources\\Button 116, 51 px\\perv _ 116, 51 px.jpg"));
        nextButton = new JButton(new ImageIcon("C:\\Users\\phudiskey\\Desktop\\Pacman2\\jpacman\\src\\main\\resources\\Button 116, 51 px\\next _ 116, 51 px.jpg"));

        // Set up the image icons
        easyImage = new ImageIcon("C:\\Users\\phudiskey\\Desktop\\Pacman2\\jpacman\\src\\main\\resources\\Description 316, 234 px\\easy.jpg");
        normalImage = new ImageIcon("C:\\Users\\phudiskey\\Desktop\\Pacman2\\jpacman\\src\\main\\resources\\Description 316, 234 px\\normal.jpg");
        hardImage = new ImageIcon("C:\\Users\\phudiskey\\Desktop\\Pacman2\\jpacman\\src\\main\\resources\\Description 316, 234 px\\hard.jpg");

        // Set up the image label
        imageLabel = new JLabel(easyImage);
        Border paddingImage = BorderFactory.createEmptyBorder(100, 0, 0, 0);
        imageLabel.setBorder(paddingImage);
        // Add the buttons to a JPanel
        JPanel buttonPanel = new JPanel();

        Border paddingBorder = BorderFactory.createEmptyBorder(0, 50, 0, 0);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createVerticalStrut(165));
        buttonPanel.add(easyButton);
        buttonPanel.add(Box.createVerticalStrut(25));
        buttonPanel.add(normalButton);
        buttonPanel.add(Box.createVerticalStrut(25));
        buttonPanel.add(hardButton);
        buttonPanel.setBorder(paddingBorder);
        buttonPanel.setPreferredSize(new Dimension(300,0));

        // Add the button panel and image label to the JFrame
        add(buttonPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);
        getContentPane().setComponentZOrder(imageLabel, getContentPane().getComponentZOrder(backgroundLabel));

        // Add action listeners to the buttons
        easyButton.addActionListener(this);
        normalButton.addActionListener(this);
        hardButton.addActionListener(this);

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        navPanel.add(prevButton);
        navPanel.add(nextButton);
        Border paddingBorder2 = BorderFactory.createEmptyBorder(0, 0, 0, 50);
        navPanel.setBorder(paddingBorder2);
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 180, 20);
        navPanel.setLayout(layout);

        prevButton.setPreferredSize(new Dimension(116,51));
        nextButton.setPreferredSize(new Dimension(116,51));

        // Add the nav panel to the JFrame
        add(navPanel, BorderLayout.SOUTH);

        prevButton.addActionListener(this);
        nextButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        // Change the image based on which button was clicked
        if (e.getSource() == easyButton) {
            imageLabel.setIcon(easyImage);
        } else if (e.getSource() == normalButton) {
            imageLabel.setIcon(normalImage);
        } else if (e.getSource() == hardButton) {
            imageLabel.setIcon(hardImage);
        }

    }

    public static void main(String[] args) {
        newDifficultyUI frame = new newDifficultyUI();
        frame.setVisible(true);
    }
}


