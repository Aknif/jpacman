package nl.tudelft.jpacman.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveUI extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JTextField nameField;
    private JLabel nameLabel;
    private JButton saveButton;

    private JButton restartButton;

    public SaveUI() {
        setTitle("Jpacman");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // Add Jpacman icon
        ImageIcon icon = new ImageIcon("jpacman_icon.png");
        JLabel iconLabel = new JLabel(icon);
        GridBagConstraints iconConstraints = new GridBagConstraints();
        iconConstraints.gridx = 0;
        iconConstraints.gridy = 0;
        iconConstraints.insets = new Insets(20, 20, 20, 20);
        mainPanel.add(iconLabel, iconConstraints);

        // Add name label
        nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        GridBagConstraints nameLabelConstraints = new GridBagConstraints();
        nameLabelConstraints.gridx = 1;
        nameLabelConstraints.gridy = 0;
        nameLabelConstraints.anchor = GridBagConstraints.WEST;
        nameLabelConstraints.insets = new Insets(20, 0, 10, 0);
        mainPanel.add(nameLabel, nameLabelConstraints);

        // Add name input field
        nameField = new JTextField(20);
        nameField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        GridBagConstraints nameFieldConstraints = new GridBagConstraints();
        nameFieldConstraints.gridx = 1;
        nameFieldConstraints.gridy = 1;
        nameFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
        nameFieldConstraints.insets = new Insets(0, 0, 10, 0);
        mainPanel.add(nameField, nameFieldConstraints);

        // Add save button
        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setFont(new Font("Arial", Font.PLAIN, 14));
        saveButton.setForeground(Color.WHITE);
        saveButton.setBackground(new Color(255, 69, 0));
        saveButton.setFocusPainted(false);
        GridBagConstraints saveButtonConstraints = new GridBagConstraints();
        saveButtonConstraints.gridx = 1;
        saveButtonConstraints.gridy = 2;
        saveButtonConstraints.anchor = GridBagConstraints.CENTER;
        saveButtonConstraints.insets = new Insets(10, 0, 20, 0);
        mainPanel.add(saveButton, saveButtonConstraints);
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            // Save name to JSON file
            JSONObject obj = new JSONObject();
            obj.put("name", nameField.getText());

            try (FileWriter file = new FileWriter("name.json")) {
                file.write(obj.toJSONString());
                System.out.println("Name saved to file.");
            } catch (IOException ex) {
                System.out.println("Error saving name to file.");
            }
        }
    }

    public static void main(String[] args) {
        new SaveUI();
    }
}
