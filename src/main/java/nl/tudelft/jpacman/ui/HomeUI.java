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
        frame.setTitle("My UI");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //add bg image
        ImageIcon icon = new ImageIcon("src/main/resources/pacman_bg/Main_bg _ 800, 600 px.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        frame.add(label);



        // Create and customize the button
        ImageIcon iconButton = new ImageIcon("src/main/resources/Button 266, 58 px/casual _ 266, 58 px.jpg");
        JButton CasualButton = new JButton(iconButton);

        CasualButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MapUI();
            }
        });

        ImageIcon iconButton_Endless = new ImageIcon("src/main/resources/Button 266, 58 px/endless _ 266, 58 px.jpg");
        JButton EndlessButton = new JButton(iconButton_Endless);
        EndlessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MapUI();
            }
        });

        ImageIcon iconButton_Score = new ImageIcon("src/main/resources/Button 266, 58 px/score _ 266, 58 px.jpg");
        JButton ScoreButton = new JButton(iconButton_Score);
        ScoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MapUI();
            }
        });

        // Create a JPanel with FlowLayout to center the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(Box.createVerticalStrut(250));
        buttonPanel.add(CasualButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(EndlessButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(ScoreButton);


        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        CasualButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        EndlessButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        ScoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add the panel to the frame
        frame.add(buttonPanel);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
