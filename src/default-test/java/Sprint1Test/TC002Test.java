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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * A very simple (and not particularly useful)
 * test class to have a starting point where to put tests.
 *
 * @author Arie van Deursen
 */

public class TC002Test {
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
    @DisplayName("TS002_TC01 - Move towards the hole where the pellet is located.")
    void TS002_TC01_PlayerMove() {
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        game.move(player, Direction.EAST);
        assertThat(player.getScore()).isEqualTo(10);
    }
    @Test
    @DisplayName("TS002_TC02 - Move towards free space")
    void TS002_TC02_PlayerMove() {
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        game.move(player, Direction.EAST);
        assertThat(player.getScore()).isEqualTo(10);

        //if player move to empty space ,player should not get more score
        game.move(player, Direction.WEST);
        assertThat(player.getScore()).isEqualTo(10);
    }
    @Test
    @DisplayName("TS002_TC03 - Move towards a wall block")
    void TS002_TC03_PlayerMove() {
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        //move player to wall ,player shouldn't go there
        game.move(player, Direction.NORTH);
        assertThat(player.getScore()).isEqualTo(0);
    }
    @Test
    @DisplayName("TS002_TC04 - Move into a block with ghosts.")
    void TS002_TC04_PlayerMove() {
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        move(game, Direction.SOUTH, 4);
        assertThat(player.isAlive()).isFalse();

        game.stop();
        assertThat(game.isInProgress()).isFalse();
    }
    @Test
    @DisplayName("TS002_TC05 - Collect all Pellet points")
    void TS002_TC05_PlayerMove() {
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        move(game, Direction.EAST, 2);
        move(game, Direction.WEST, 5);


        assertThat(launcher.getGame().getLevel().remainingPellets()).isEqualTo(0);

        game.stop();
        assertThat(game.isInProgress()).isFalse();
    }

}
