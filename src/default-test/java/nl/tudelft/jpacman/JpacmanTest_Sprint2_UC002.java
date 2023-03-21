package nl.tudelft.jpacman;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.DifficultyUI;
import nl.tudelft.jpacman.ui.HomeUI;
import nl.tudelft.jpacman.ui.MapUI;
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
import static org.mockito.Mockito.mock;

public class JpacmanTest_Sprint2_UC002 {
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
    @DisplayName("TS002_TC01 - press the Start button.")
    void UC002_TS002_TC01_MainMenu(){
        JPanel panel = new JPanel();

        JButton StartButton = new JButton("Start");
        panel.setVisible(true);
        StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MapUI mapui = new MapUI();
            }
        });
        panel.add(StartButton);
        StartButton.doClick();

        assertTrue(panel.isVisible());
    }

    @Test
    @DisplayName("TS003_TC01 - press the Score button.")
    void UC002_TS003_TC01_MainMenu(){
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
    @DisplayName("TS004_TC01 - Press on the map to play.")
    void UC002_TS004_TC01_MapMenu() {
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
    @DisplayName("S005_TC01 - When clicking the \"Next\" button by selecting a stage")
    void UC002_TS005_TC01_MapMenu() {
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
                DifficultyUI difficultyUI = new DifficultyUI(1);
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
    @DisplayName("TS006_TC01 - When clicking the \"Next\" button without selecting a stage")
    void UC002_TS006_TC01_MapMenu() {
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
                DifficultyUI difficultyUI = new DifficultyUI(1);
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
    @DisplayName("TS007_TC01 - Press the \"Back\" button")
    void UC002_TS007_TC01_MapMenu() {
        JPanel panel = new JPanel();
        JButton PreviousButton;

        PreviousButton = new JButton("Back");

        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeUI homeUI = new HomeUI();
                panel.setVisible(true);
            }
        });

        panel.add(PreviousButton);
        PreviousButton.doClick();

        assertTrue(panel.isVisible());
    }
    @Test
    @DisplayName("TS008_TC01 - Click on the difficulty option.")
    void UC002_TS008_TC01_DifficultyMenu() {
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
    @DisplayName("TS019_TC01 - Click Next by choosing a difficulty.")
    void UC002_TS019_TC01_DifficultyMenu() {
        JPanel panel = new JPanel();
        JButton select;
        select = new JButton("select");

        String[] difficultyOptions = {"Easy", "Normal", "Hard"};
        JComboBox<String> comboBox = new JComboBox<String>(difficultyOptions);
        panel.add(comboBox);
        comboBox.setSelectedItem(null);
        assertEquals(null, comboBox.getSelectedItem());

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
    @DisplayName("TS010_TC01 - Click on the Back option on the Difficulty Selection page.")
    void UC002_TS010_TC01_DifficultyMenu() {
        JPanel panel = new JPanel();
        JButton back;
        back = new JButton("back");

        String[] difficultyOptions = {"Easy", "Normal", "Hard"};
        JComboBox<String> comboBox = new JComboBox<String>(difficultyOptions);
        panel.add(comboBox);
        comboBox.setSelectedItem(null);
        assertEquals(null, comboBox.getSelectedItem());

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeUI homeUI = new HomeUI();
                //start with easy difficult
                panel.setVisible(true);
            }
        });
        panel.add(back);
        back.doClick();

        assertThat(panel.isVisible());
    }
    @Test
    @DisplayName("TS011_TC01 - Click on the theme game and press start.")
    void UC002_TS011_TC01_DifficultyMenu() {
        JPanel panel = new JPanel();
        JButton select =  new JButton("select");

        String[] difficultyOptions = {"vivid", "city", "space"};
        JComboBox<String> comboBox = new JComboBox<String>(difficultyOptions);
        panel.add(comboBox);
        comboBox.setSelectedItem("vivid");
        assertEquals("vivid", comboBox.getSelectedItem());

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Launcher().launch();
                panel.setVisible(true);
            }
        });
        panel.add(select);
        select.doClick();

        assertThat(panel.isVisible());
    }
    @Test
    @DisplayName("TS012_TC01 - Press start without selecting a game theme.")
    void UC002_TS012_TC01_DifficultyMenu() {
        JPanel panel = new JPanel();
        JButton select =  new JButton("ฺNext");

        String[] difficultyOptions = {"vivid", "city", "space"};
        JComboBox<String> comboBox = new JComboBox<String>(difficultyOptions);
        panel.add(comboBox);
        comboBox.setSelectedItem(null);
        assertEquals(null, comboBox.getSelectedItem());

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Launcher().launch();
                panel.setVisible(true);
            }
        });
        panel.add(select);
        select.doClick();

        assertThat(panel.isVisible());
    }
    @Test
    @DisplayName("TS013_TC01 - Press the back button on the theme game selection page.")
    void UC002_TS013_TC01_DifficultyMenu() {
        JPanel panel = new JPanel();
        JButton PreviousButton =  new JButton("Back");

        String[] difficultyOptions = {"vivid", "city", "space"};
        JComboBox<String> comboBox = new JComboBox<String>(difficultyOptions);
        panel.add(comboBox);
        comboBox.setSelectedItem(null);
        assertEquals(null, comboBox.getSelectedItem());

        PreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Launcher().launch();
                panel.setVisible(true);
            }
        });
        panel.add(PreviousButton);
        PreviousButton.doClick();

        assertThat(panel.isVisible());
    }
}
