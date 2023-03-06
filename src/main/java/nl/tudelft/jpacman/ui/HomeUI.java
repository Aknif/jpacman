package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.BorderLayout;
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

        // Create a new JButton and add an ActionListener to it
        JButton CasaulButton = new JButton("Casaul");
        CasaulButton.addActionListener(this);
        JButton EndlessButton = new JButton("Endless");
        EndlessButton.addActionListener(this);
        JButton scoreButton = new JButton("Score");
        scoreButton.addActionListener(this);

        // Add the JButton to the JPanel
        panel.add(CasaulButton);
        panel.add(EndlessButton);
        panel.add(scoreButton);

        // Add the JPanel to the window
        add(panel, BorderLayout.CENTER);

        // Make the window visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getActionCommand().equals("Casaul")) {
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
