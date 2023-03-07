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
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My UI");
        frame.setLocationRelativeTo(null);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);

        ImageIcon icon = new ImageIcon("src/main/resources/PACMANBG.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 800, 600);
        frame.add(label);

        // Create and customize the button
        JButton CasualButton = new JButton("Casual");
        CasualButton.setBounds(250, 175, 100, 50);
        CasualButton.addActionListener(this);

        JButton EndlessButton = new JButton("Endless");
        EndlessButton.setBounds(250, 175, 100, 50);
        EndlessButton.addActionListener(this);

        JButton ScoreButton = new JButton("Score");
        ScoreButton.setBounds(250, 175, 100, 50);
        ScoreButton.addActionListener(this);

        // Create a JPanel with FlowLayout to center the button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(CasualButton);
        buttonPanel.add(EndlessButton);
        buttonPanel.add(ScoreButton);

        // Add the panel to the frame
        frame.add(buttonPanel);

        frame.setVisible(true);
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
