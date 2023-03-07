package nl.tudelft.jpacman.ui;
import javax.swing.*;
import java.awt.*;

public class ImageUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My UI");

        ImageIcon icon = new ImageIcon("src/main/resources/PACMANBG.png");
        JLabel label = new JLabel(icon);
        label.setBounds(0, 0, 800, 600);
        frame.add(label);

        // Create and customize the button
        JButton startButton = new JButton("Start Game");
        startButton.setBounds(250, 175, 100, 50);

        // Create a JPanel with FlowLayout to center the button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(startButton);

        // Add the panel to the frame
        frame.add(buttonPanel);

        frame.setVisible(true);
    }
}
