package Sprint1Test;

import com.google.common.collect.Lists;
import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.*;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.npc.ghost.Navigation;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */

public class TC003Test {
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
    @DisplayName("TS003_TC01 - when the game starts")
    void TS003_TC01_GhostMove() {
        Board b = parser.parseMap(Lists.newArrayList("####", "#  #", "####"))
            .getBoard();
        Square s1 = b.squareAt(1, 1);
        Square s2 = b.squareAt(2, 1);
        List<Direction> path = Navigation
            .shortestPath(s1, s2, mock(Unit.class));
        assertThat(path).containsExactly(Direction.EAST);
    }
    @Test
    @DisplayName("TS003_TC02 - the ghost starts to move")
    void TS003_TC02_GhostMove() {
        //Verifies that the nearest object is detected
        Board b = parser
            .parseMap(Lists.newArrayList("#####", "# ..#", "#####"))
            .getBoard();
        Square s1 = b.squareAt(1, 1);
        Square s2 = b.squareAt(2, 1);
        Square result = Objects.requireNonNull(Navigation.findNearest(Pellet.class, s1)).getSquare();
        assertThat(result).isEqualTo(s2);
    }
    @Test
    @DisplayName("TS003_TC03 - When the ghost moves to where the player is")
    void TS003_TC03_GhostMove() throws InterruptedException {
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        move(game, Direction.WEST, 2);
        move(game, Direction.NORTH, 3);
        Thread.sleep(1500L);

        assertThat(player.isAlive()).isFalse();

        game.stop();
        assertThat(game.isInProgress()).isFalse();
    }

}
