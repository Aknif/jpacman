package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static nl.tudelft.jpacman.Launcher.DYNAMIC_MAP;

public class MapUI extends JFrame implements ActionListener {
    private JLabel mapLabel;
    private JComboBox<String> mapComboBox;
    private String[] mapOptions = {"Map1", "Map2", "Map3", "Map4", "Map5"};
    private int mapLevel;

    public MapUI() {
        // Set the title of the window
        super("MapUI");

        // Set the size of the window
        // Set the size of the window
        setSize(400, 300);

        // Create a new JPanel to hold the components
        JPanel panel = new JPanel();

        // Initialize the difficulty level and add a JComboBox to select the level
        mapLevel = 0;
        mapLabel = new JLabel("Select Map:");
        mapComboBox = new JComboBox<>(mapOptions);
        mapComboBox.addActionListener(this);

        panel.add(mapLabel);
        panel.add(mapComboBox);
        add(panel, BorderLayout.CENTER);

        // Add the JPanel to the window
        add(panel, BorderLayout.CENTER);

        JButton SelectButton = new JButton("Select");
        SelectButton.addActionListener(this);
        panel.add(SelectButton);
        // Make the window visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Select")) {
            dispose();
            new DifficultyUI();
        }
        // Handle user selection of the difficulty level
        if (e.getSource() == mapComboBox) {
            String selectedDifficulty = (String) mapComboBox.getSelectedItem();
            if (selectedDifficulty.equals("Map1")) {
                new Launcher().DYNAMIC_MAP = "/board.txt";
                System.out.println(DYNAMIC_MAP);
            }
            if (selectedDifficulty.equals("Map2")) {
                new Launcher().DYNAMIC_MAP = "/board2.txt";
                System.out.println(DYNAMIC_MAP);
            }
            if (selectedDifficulty.equals("Map3")) {
                new Launcher().DYNAMIC_MAP = "/board3.txt";
                System.out.println(DYNAMIC_MAP);
            }
            if (selectedDifficulty.equals("Map4")) {
                new Launcher().DYNAMIC_MAP = "/board4.txt";
                System.out.println(DYNAMIC_MAP);
            }
            if (selectedDifficulty.equals("Map5")) {
                new Launcher().DYNAMIC_MAP = "/board5.txt";
                System.out.println(DYNAMIC_MAP);
            }
        }
    }
}




