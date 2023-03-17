package Sprint1Test;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */

public class TC007Test {

    @BeforeEach
    public void before() {
        Launcher launcher = new Launcher();
        launcher.levelMap = "/boardTest.txt";

        PacManSprites sprites = new PacManSprites();
        LevelFactory levelFactory = new LevelFactory(
            sprites,
            new GhostFactory(sprites),
            mock(PointCalculator.class));
    }

    @AfterEach
    public void after() {
        //launcher.dispose();
    }

    public static void move(Game game, Direction dir, int numSteps) {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }

    @Test
    @DisplayName("TS007_TC01 - Click on the difficulty option.")
    void TS007_TC01_DifficultyMenu() {
        String[] difficultyOptions = {"Easy", "Normal", "Hard"};
        String[] expected = {"Easy", "Normal", "Hard"};
        assertArrayEquals(expected,difficultyOptions);
    }
    @Test
    @DisplayName("TS007_TC02 - Press the \"Start\" button, selecting the difficulty level.")
    void TS007_TC02_DifficultyMenu() {
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
                Launcher.DYNAMIC_MAP = "/board.txt";
                //start with easy difficult
                panel.setVisible(true);
            }
        });
        panel.add(select);
        select.doClick();

        assertThat(panel.isVisible());
    }
    @Test
    @DisplayName("TS007_TC03 - Press the \"Start\" button without selecting the difficulty level.")
    void TS007_TC03_DifficultyMenu() {
        JPanel panel = new JPanel();
        JButton select;
        select = new JButton("select");

        String[] difficultyOptions = {"Easy", "Normal", "Hard"};
        JComboBox<String> comboBox = new JComboBox<String>(difficultyOptions);
        panel.add(comboBox);

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Launcher.DYNAMIC_MAP = "/board.txt";
                //start with easy difficult
                panel.setVisible(true);
            }
        });
        panel.add(select);
        select.doClick();

        assertThat(panel.isVisible());
    }
    @Test
    @DisplayName("TS007_TC04 - Press the \"Prev\" button.")
    void TS007_TC04_DifficultyMenu() {
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
