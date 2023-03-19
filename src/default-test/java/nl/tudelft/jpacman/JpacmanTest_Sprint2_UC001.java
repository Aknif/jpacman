package nl.tudelft.jpacman;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.*;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class JpacmanTest_Sprint2_UC001 {
    Square square;
    private Launcher launcher;
    private MapParser parser;
    private BoardFactory factory;
    private Square s1;
    private Square s2;

    public static void move(Game game, Direction dir, int numSteps) {
        Player player = game.getPlayers().get(0);
        for (int i = 0; i < numSteps; i++) {
            game.move(player, dir);
        }
    }

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
        square = new BasicSquare();
    }

    private Game getGame() {
        return launcher.getGame();
    }

    @AfterEach
    public void after() {
        //launcher.dispose();
    }

    @Test
    @DisplayName("TS001_TC01 - launcher running")
    void UC001_TS001_TC01() {
        launcher.launch();
        getGame().start();
        assertThat(getGame().isInProgress()).isTrue(); //Check if game is running
    }


}
