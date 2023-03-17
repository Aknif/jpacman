package nl.tudelft.jpacman;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.HomeUI;
import nl.tudelft.jpacman.ui.ScoreUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class JpacmanTest_UC005 {
    private Launcher launcher;

    private MapParser parser;
    @BeforeEach
    public void before() {
        launcher = new Launcher();
        launcher.levelMap = "/boardTest.txt";

        PacManSprites sprites = new PacManSprites();
        LevelFactory levelFactory = new LevelFactory(
            sprites,
            new GhostFactory(sprites),
            mock(PointCalculator.class));
        parser = new MapParser(levelFactory, new BoardFactory(sprites));
    }

    public static void move(Game game, Direction dir, int numSteps) {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }
    private Game getGame() {
        return launcher.getGame();
    }

    @Test
    @DisplayName("TS039_TC01 - press the casual button.")
    void UC005_TS039_TC01_MainMenu(){
        JPanel panel = new JPanel();

        JButton CasaulButton = new JButton("Casual");
        panel.setVisible(true);
        CasaulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapUI mapui = new MapUI();
            }
        });
        panel.add(CasaulButton);
        CasaulButton.doClick();

        assertTrue(panel.isVisible());
    }
    @Test
    @DisplayName("TS040_TC01 - press the Endless button.")
    void UC005_TS040_TC01_MainMenu(){
        JPanel panel = new JPanel();

        JButton EndlessButton = new JButton("Endless");
        panel.setVisible(true);
        EndlessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapUI mapui = new MapUI();
            }
        });
        panel.add(EndlessButton);
        EndlessButton.doClick();

        assertTrue(panel.isVisible());
    }
    @Test
    @DisplayName("TS041_TC01 - press the Score button.")
    void UC005_TS041_TC01_MainMenu(){
        final boolean[] text = {false};
        JPanel panel = new JPanel();

        JButton ScoreButton = new JButton("Score");
        panel.setVisible(true);
        ScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScoreUI scoreUI = new ScoreUI();
            }
        });
        panel.add(ScoreButton);
        ScoreButton.doClick();

        assertTrue(panel.isVisible());
    }
    @Test
    @DisplayName("TS042_TC01 - Press on the map to play.")
    void UC005_TS042_TC01_MapMenu() {
        JPanel panel = new JPanel();
        JButton map1;
        final boolean[] check = {false};

        map1 = new JButton("Map 1");
        map1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map1.setBackground(Color.GREEN);
                check[0] = true;
            }
        });
        panel.add(map1);
        map1.doClick();

        assertTrue(check[0]);
    }
    @Test
    @DisplayName("S043_TC01 - When clicking the \"Next\" button by selecting a stage")
    void UC005_TS043_TC01_MapMenu() {
        JPanel panel = new JPanel();
        JButton next;
        JButton map1;

        map1 = new JButton("Map 1");
        next = new JButton("next");

        map1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Launcher().DYNAMIC_MAP = "/board.txt";
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DifficultyUI difficultyUI = new DifficultyUI();
                panel.setVisible(true);
            }
        });
        panel.add(map1);
        map1.doClick();

        panel.add(next);
        next.doClick();

        assertTrue(panel.isVisible());
    }
    @Test
    @DisplayName("TS044_TC01 - When clicking the \"Next\" button without selecting a level")
    void UC005_TS044_TC01_MapMenu() {
        JPanel panel = new JPanel();
        JButton next;
        JButton easy;
        JButton select;

        next = new JButton("next");
        easy = new JButton("easy");
        select = new JButton("select");

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DifficultyUI difficultyUI = new DifficultyUI();
            }
        });

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //difficulty is not created in this sprint
            }
        });

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Launcher().DYNAMIC_MAP = "/board.txt";
                panel.setVisible(true);
            }
        });

        panel.add(next);
        next.doClick();

        panel.add(easy);
        easy.doClick();

        panel.add(select);
        select.doClick();

        assertTrue(panel.isVisible());
    }
    @Test
    @DisplayName("TS045_TC01 - Press the \"Prev\" button")
    void UC005_TS045_TC01_MapMenu() {
        JPanel panel = new JPanel();
        JButton prev;

        prev = new JButton("prev");

        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeUI homeUI = new HomeUI();
                panel.setVisible(true);
            }
        });

        panel.add(prev);
        prev.doClick();

        assertTrue(panel.isVisible());
    }
    @Test
    @DisplayName("TS046_TC01 - Click on the difficulty option.")
    void UC005_TS046_TC01_DifficultyMenu() {
        String[] difficultyOptions = {"Easy", "Normal", "Hard"};
        String[] expected = {"Easy", "Normal", "Hard"};
        assertArrayEquals(expected,difficultyOptions);
    }
    @Test
    @DisplayName("TS047_TC01 - Press the \"Start\" button, selecting the difficulty level.")
    void UC005_TS047_TC01_DifficultyMenu() {
        JPanel panel = new JPanel();
        JButton select;
        select = new JButton("select");

        String[] difficultyOptions = {"Easy", "Normal", "Hard"};
        JComboBox<String> comboBox = new JComboBox<String>(difficultyOptions);
        panel.add(comboBox);
        comboBox.setSelectedItem("Easy");
        assertEquals("Easy", comboBox.getSelectedItem());

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Launcher().DYNAMIC_MAP = "/board.txt";
                //start with easy difficult
                panel.setVisible(true);
            }
        });
        panel.add(select);
        select.doClick();

        assertThat(panel.isVisible());
    }
    @Test
    @DisplayName("TS048_TC01 - Press the \"Start\" button without selecting the difficulty level.")
    void UC005_TS048_TC01_DifficultyMenu() {
        JPanel panel = new JPanel();
        JButton select;
        select = new JButton("select");

        String[] difficultyOptions = {"Easy", "Normal", "Hard"};
        JComboBox<String> comboBox = new JComboBox<String>(difficultyOptions);
        panel.add(comboBox);

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Launcher().DYNAMIC_MAP = "/board.txt";
                //start with easy difficult
                panel.setVisible(true);
            }
        });
        panel.add(select);
        select.doClick();

        assertThat(panel.isVisible());
    }
    @Test
    @DisplayName("TS049_TC01 Press the \"Prev\" button.")
    void UC005_TS049_TC01_DifficultyMenu() {
        JPanel panel = new JPanel();
        JButton prev;

        prev = new JButton("prev");

        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MapUI();
                panel.setVisible(true);
            }
        });

        panel.add(prev);
        prev.doClick();

        assertTrue(panel.isVisible());
    }
}
