package Sprint1Test;

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
import nl.tudelft.jpacman.ui.HomeUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */

public class TC006Test {
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
    private Game getGame() {
        return launcher.getGame();
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
    @DisplayName("TS006_TC01 - Press on the map to play.")
    void TS006_TC01_MapMenu() {
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
    @DisplayName("TS006_TC03 - When clicking the \"Next\" button by selecting a stage")
    void TS006_TC02_MapMenu() {
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
    @DisplayName("TS006_TC03 - When clicking the \"Next\" button without selecting a level")
    void TS006_TC03_MapMenu() {
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
    @DisplayName("TS006_TC04 - Press the \"Prev\" button.")
    void TS006_TC04_MapMenu() {
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
}
