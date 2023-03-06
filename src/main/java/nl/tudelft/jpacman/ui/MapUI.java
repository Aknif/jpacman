package nl.tudelft.jpacman.ui;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.GameFactory;
import nl.tudelft.jpacman.level.Level;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MapUI extends JFrame implements ActionListener {
    private JButton scoreButton;

    public MapUI() {
        // Set the title of the window
        super("MapUI");

        // Set the size of the window
        setSize(400, 300);

        // Create a new JPanel to hold the components
        JPanel panel = new JPanel();

        // Create a new JButton and add an ActionListener to it
        JButton Map1Button = new JButton("Map 1");
        Map1Button.addActionListener(this);
        JButton Map2Button = new JButton("Map 2");
        Map2Button.addActionListener(this);

        JButton Map3Button = new JButton("Map 3");
        Map3Button.addActionListener(this);
        JButton Map4Button = new JButton("Map 4");
        Map4Button.addActionListener(this);

        // Add the JButton to the JPanel
        panel.add(Map1Button);
        panel.add(Map2Button);
        panel.add(Map3Button);
        panel.add(Map4Button);

        // Add the JPanel to the window
        add(panel, BorderLayout.CENTER);

        // Make the window visible
        setVisible(true);
    }

    /*
    * ADDED change selected map on click
    *
    * */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getActionCommand().equals("Map 1")) {
            dispose();
            new Launcher().DYNAMIC_MAP = "/board3.txt"; //เพิ่มใหม่มา
            new Launcher().launch();
        }
        if (e.getActionCommand().equals("Map 2")) {
           dispose();
           new Launcher().DYNAMIC_MAP = "/board2.txt"; //เพิ่มใหม่มา
           new Launcher().launch();
        }
        if (e.getActionCommand().equals("Map 3")) {
            dispose();
            new Launcher().DYNAMIC_MAP = "/board_Plain.txt"; //เพิ่มใหม่มา
            new Launcher().launch();
        }
        if (e.getActionCommand().equals("Map 4")) {
            dispose();
            new Launcher().DYNAMIC_MAP = "/board_Plain.txt"; //เพิ่มใหม่มา
            new Launcher().launch(); // fix
        }
    }
public static void main(String[] args){
        MapUI mapUI = new MapUI();
    }
}



/*
 * Creates and starts a JPac-Man game.

public void launch() {
    makeGame();
    PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
    addSinglePlayerKeys(builder);
    pacManUI = builder.build(getGame());
    pacManUI.start();
}




    public Game makeGame() {
        GameFactory gf = getGameFactory();
        Level level = makeLevel();
        game = gf.createSinglePlayerGame(level, loadPointCalculator());
        return game;
    }

*
*
*
*/
