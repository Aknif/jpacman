package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DifficultyUI extends JFrame implements ActionListener {
    private JLabel difficultyLabel;
    private JComboBox<String> difficultyComboBox;
    private String[] difficultyOptions = {"Easy", "Normal", "Hard"};
    private int difficultyLevel;
    public DifficultyUI() {
// Set the title of the window
        super("HomeUI");

        // Set the size of the window
        setSize(400, 300);

        // Create a new JPanel to hold the components
        JPanel panel = new JPanel();

        JButton PervButton = new JButton("Perv");
        PervButton.addActionListener(this);
        panel.add(PervButton);

        // Initialize the difficulty level and add a JComboBox to select the level
        difficultyLevel = 0;
        difficultyLabel = new JLabel("Select Difficulty Level:");
        difficultyComboBox = new JComboBox<>(difficultyOptions);
        difficultyComboBox.addActionListener(this);

        panel.add(difficultyLabel);
        panel.add(difficultyComboBox);
        add(panel, BorderLayout.CENTER);

        // Add the JPanel to the window
        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        JButton SelectButton = new JButton("Select");
        SelectButton.addActionListener(this);
        panel.add(SelectButton);
        // Make the window visible
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getActionCommand().equals("Select")) {
            dispose();
            new Launcher().launch();
        }
        if (e.getActionCommand().equals("Perv")) {
            dispose();
            new MapUI();
        }
    }
    public static void main(String[] args){
        DifficultyUI difficultyUI = new DifficultyUI();
    }
}
