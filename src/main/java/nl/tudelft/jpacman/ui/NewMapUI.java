package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class NewMapUI extends JFrame implements ActionListener {

    private JButton map1Button, map2Button, map3Button, map4Button, map5Button, nextButton, prevButton;
    private JLabel imageLabel;
    private ImageIcon map1Image, map2Image, map3Image, map4Image, map5Image;



    public int stage = 0;

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }


    public NewMapUI() {
        // Set up the JFrame


        setTitle("Stage Select");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Load the image file into an ImageIcon
        ImageIcon imageIcon = new ImageIcon("src/main/resources/pacman_bg/Map_bg _ 800, 600 px.png");

        // Create a new JLabel with the image as the icon
        JLabel backgroundLabel = new JLabel(imageIcon);

        // Set the size and position of the label to fill the JFrame
        backgroundLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        // Set the label as the content pane of the JFrame
        add(backgroundLabel);

        // Set up the buttons
        map1Button = new JButton(new ImageIcon("src/main/resources/Button 116, 51 px/map 1 _ 116, 51 px.jpg"));
        map2Button = new JButton(new ImageIcon("src/main/resources/Button 116, 51 px/map 2 _ 116, 51 px.jpg"));
        map3Button = new JButton(new ImageIcon("src/main/resources/Button 116, 51 px/map 3 _ 116, 51 px.jpg"));
        map4Button = new JButton(new ImageIcon("src/main/resources/Button 116, 51 px/map 4 _ 116, 51 px.jpg"));
        map5Button = new JButton(new ImageIcon("src/main/resources/Button 116, 51 px/map 5 _ 116, 51 px.jpg"));
        prevButton = new JButton(new ImageIcon("src/main/resources/Button 116, 51 px/perv _ 116, 51 px.jpg"));
        nextButton = new JButton(new ImageIcon("src/main/resources/Button 116, 51 px/next _ 116, 51 px.jpg"));

        // Set up the image icons
        map1Image = new ImageIcon("src/main/resources/Map/Map 1 _ 344, 315 px.jpg");
        map2Image = new ImageIcon("src/main/resources/Map/Map 2 _ 344, 315 px.jpg");
        map3Image = new ImageIcon("src/main/resources/Map/Map 3 _ 344, 315 px.jpg");
        map4Image = new ImageIcon("src/main/resources/Map/Map 4 _ 344, 315 px.jpg");
        map5Image = new ImageIcon("src/main/resources/Map/Map 5 _ 344, 315 px.jpg");

        // Set up the image label
        imageLabel = new JLabel(map1Image);
        Border paddingImage = BorderFactory.createEmptyBorder(100, 0, 0, 0);
        imageLabel.setBorder(paddingImage);
        // Add the buttons to a JPanel
        JPanel buttonPanel = new JPanel();

        Border paddingBorder = BorderFactory.createEmptyBorder(0, 50, 0, 0);

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createVerticalStrut(100));
        buttonPanel.add(map1Button);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(map2Button);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(map3Button);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(map4Button);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(map5Button);
        buttonPanel.setBorder(paddingBorder);
        buttonPanel.setPreferredSize(new Dimension(300,0));
        // Add the button panel and image label to the JFrame
        add(buttonPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);
        getContentPane().setComponentZOrder(imageLabel, getContentPane().getComponentZOrder(backgroundLabel));

        // Add action listeners to the buttons
        map1Button.addActionListener(this);
        map2Button.addActionListener(this);
        map3Button.addActionListener(this);
        map4Button.addActionListener(this);
        map5Button.addActionListener(this);

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

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeUI homeUI = new HomeUI();
                dispose();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newDifficultyUI difficultyUI = new newDifficultyUI(stage);
                difficultyUI.setVisible(true);
                dispose();
            }
        });

    }

    public void actionPerformed(ActionEvent e) {
        // Change the image based on which button was clicked
        if (e.getSource() == map1Button) {
            imageLabel.setIcon(map1Image);
            //new Launcher().DYNAMIC_MAP = "/board1N.txt";
            setStage(1);
            map1Button.setBackground(Color.GREEN);
            map2Button.setBackground(null);
            map3Button.setBackground(null);
            map4Button.setBackground(null);
            map5Button.setBackground(null);
        } else if (e.getSource() == map2Button) {
            imageLabel.setIcon(map2Image);
            //new Launcher().DYNAMIC_MAP = "/board2N.txt";
            setStage(2);
            map2Button.setBackground(Color.GREEN);
            map1Button.setBackground(null);
            map3Button.setBackground(null);
            map4Button.setBackground(null);
            map5Button.setBackground(null);
        } else if (e.getSource() == map3Button) {
            imageLabel.setIcon(map3Image);
            //new Launcher().DYNAMIC_MAP = "/board3N.txt";
            setStage(3);
            map3Button.setBackground(Color.GREEN);
            map1Button.setBackground(null);
            map2Button.setBackground(null);
            map4Button.setBackground(null);
            map5Button.setBackground(null);
        } else if (e.getSource() == map4Button) {
            imageLabel.setIcon(map4Image);
            //new Launcher().DYNAMIC_MAP = "/board4N.txt";
            setStage(4);
            map4Button.setBackground(Color.GREEN);
            map1Button.setBackground(null);
            map3Button.setBackground(null);
            map2Button.setBackground(null);
            map5Button.setBackground(null);

        } else if (e.getSource() == map5Button) {
            imageLabel.setIcon(map5Image);
            //new Launcher().DYNAMIC_MAP = "/board5N.txt";
            setStage(5);
            map5Button.setBackground(Color.GREEN);
            map1Button.setBackground(null);
            map2Button.setBackground(null);
            map3Button.setBackground(null);
            map4Button.setBackground(null);
        }

    }

    public static void main(String[] args) {
        NewMapUI frame = new NewMapUI();
        frame.setVisible(true);
    }
}

