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
import nl.tudelft.jpacman.ui.ScoreUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
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

public class TC005Test {
    private Launcher launcher;

    @BeforeEach
    public void before() {
        launcher = new Launcher();
        launcher.levelMap = "/boardTest.txt";

        PacManSprites sprites = new PacManSprites();
        LevelFactory levelFactory = new LevelFactory(
            sprites,
            new GhostFactory(sprites),
            mock(PointCalculator.class));
        MapParser parser = new MapParser(levelFactory, new BoardFactory(sprites));
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
    @DisplayName("TS005_TC01 - press the casual button.")
    void TS005_TC01_MainMenu(){
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
    @DisplayName("TS005_TC02 - press the Endless button.")
    void TS005_TC02_MainMenu(){
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
    @DisplayName("TS005_TC03 - press the Score button.")
    void TS005_TC03_MainMenu(){
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
}
