package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MapUI extends JFrame implements ActionListener {

    private JButton map1;
    private JButton map2;
    private JButton map3;
    private JButton map4;
    private JButton map5;
    private Image backgroundImage;

    public MapUI() {
        // Set the title of the window
        super("MapUI");

        // Set the size of the window
        setSize(800, 600);

        // Create a new JPanel to hold the components
        JPanel panel = new JPanel();

        // Create a new JButton and add an ActionListener to it

        map1 = new JButton("Map 1");
        map1.addActionListener(this);

        map2 = new JButton("Map 2");
        map2.addActionListener(this);

        map3 = new JButton("Map 3");
        map3.addActionListener(this);

        map4 = new JButton("Map 4");
        map4.addActionListener(this);

        map5 = new JButton("Map 5");
        map5.addActionListener(this);

        JButton PervButton = new JButton("Perv");
        PervButton.addActionListener(this);

        JButton NextButton = new JButton("Next");
        NextButton.addActionListener(this);

        // Add the JButton to the JPanel
        panel.add(map1);
        panel.add(map2);
        panel.add(map3);
        panel.add(map4);
        panel.add(map5);
        panel.add(PervButton);
        panel.add(NextButton);

        // Add the JPanel to the window
        add(panel, BorderLayout.CENTER);

        //make pop-up in the middle of the screen
        setLocationRelativeTo(null);

        // Make the window visible
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks

        if (e.getActionCommand().equals("Map 1")) {
            new Launcher().DYNAMIC_MAP = "/board.txt";
            map1.setBackground(Color.GREEN);
            map2.setBackground(null);
            map3.setBackground(null);
            map4.setBackground(null);
            map5.setBackground(null);

        }
        if (e.getActionCommand().equals("Map 2")) {

            new Launcher().DYNAMIC_MAP = "/board2.txt";
            map2.setBackground(Color.GREEN);
            map1.setBackground(null);
            map3.setBackground(null);
            map4.setBackground(null);
            map5.setBackground(null);
        }
        if (e.getActionCommand().equals("Map 3")) {

            new Launcher().DYNAMIC_MAP = "/board3.txt";
            map3.setBackground(Color.GREEN);
            map2.setBackground(null);
            map1.setBackground(null);
            map4.setBackground(null);
            map5.setBackground(null);
        }
        if (e.getActionCommand().equals("Map 4")) {

            new Launcher().DYNAMIC_MAP = "/board4.txt";
            map4.setBackground(Color.GREEN);
            map2.setBackground(null);
            map3.setBackground(null);
            map1.setBackground(null);
            map5.setBackground(null);
        }
        if (e.getActionCommand().equals("Map 5")) {
            new Launcher().DYNAMIC_MAP = "/board5.txt";
            map5.setBackground(Color.GREEN);
            map2.setBackground(null);
            map3.setBackground(null);
            map4.setBackground(null);
            map1.setBackground(null);
        }
        if (e.getActionCommand().equals("Perv")) {
            dispose();
            HomeUI homeUI = new HomeUI();
        }
        if (e.getActionCommand().equals("Next")) {
            dispose();
            DifficultyUI difficultyUI = new DifficultyUI();
            // Goto Difficulty UI
        }

    }

    public static void main(String[] args){
        MapUI mapUI = new MapUI();
    }
}
