package nl.tudelft.jpacman.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PacManHomeUI extends JFrame {

    private JButton playButton;
    private JButton showScoreButton;
    private JComboBox<String> modeComboBox;

    public PacManHomeUI() {
        super("Pac-Man Home");

        // Create the "Play" button
        playButton = new JButton("Play");
        playButton.addActionListener(e -> {
            // Add code to start the game here
            String selectedMode = (String) modeComboBox.getSelectedItem();
            System.out.println("Starting game in " + selectedMode + " mode...");
        });

        // Create the "Show Score" button
        showScoreButton = new JButton("Show Score");
        showScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new score page and show it
                int score = new Random().nextInt(1000);
                PacManScoreUI scorePage = new PacManScoreUI(score);
                scorePage.setVisible(true);
            }
        });

        // Create the "Game Mode" selection drop-down menu
        modeComboBox = new JComboBox<>(new String[]{"Normal", "Hard", "Expert"});

        // Add the buttons and drop-down menu to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));
        contentPane.add(playButton);
        contentPane.add(showScoreButton);
        contentPane.add(modeComboBox);

        // Set window properties
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new PacManHomeUI();
    }
}

class PacManScoreUI extends JFrame {

    private JLabel scoreLabel;
    private JButton closeButton;

    public PacManScoreUI(int score) {
        super("Score");

        // Create the score label
        scoreLabel = new JLabel("Your score is: " + score);
        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create the close button
        closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());

        // Add the components to the content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(scoreLabel, BorderLayout.CENTER);
        contentPane.add(closeButton, BorderLayout.SOUTH);

        // Set window properties
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

