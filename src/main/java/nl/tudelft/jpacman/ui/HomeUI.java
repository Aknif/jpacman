package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUI extends JFrame implements ActionListener {

    public HomeUI() {
        // Set the title of the window
        super("HomeUI");

        // Set the size of the window
        setSize(400, 300);

        // Create a new JPanel to hold the components
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create a new JButton and add an ActionListener to it
        JButton CasaulButton = new JButton("Casual");
        CasaulButton.addActionListener(this);
        JButton EndlessButton = new JButton("Endless");
        EndlessButton.addActionListener(this);
        JButton scoreButton = new JButton("Score");
        scoreButton.addActionListener(this);

        CasaulButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        EndlessButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set the maximum size of each button to the same value
        Dimension maxButtonSize = new Dimension(80, 30);
        CasaulButton.setMaximumSize(maxButtonSize);
        EndlessButton.setMaximumSize(maxButtonSize);
        scoreButton.setMaximumSize(maxButtonSize);

        // Add the JButton to the JPanel
        panel.add(Box.createVerticalStrut(50));
        panel.add(CasaulButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(EndlessButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(scoreButton);
        panel.add(Box.createVerticalStrut(10));

        // Add the JPanel to the window
        add(panel, BorderLayout.CENTER);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getActionCommand().equals("Casual")) {
            dispose();
            new MapUI();
        }
        if (e.getActionCommand().equals("Endless")) {
            dispose();
            new MapUI();
        }
        if (e.getActionCommand().equals("Score")) {
            // Create a new ScoreUI object and display it
            ScoreUI scoreUI = new ScoreUI();
            scoreUI.setVisible(true);
            // Close the HomeUI window if needed
            dispose();
        }
    }
}
