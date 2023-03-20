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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class JpacmanTest_Sprint2_UC003 {
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
    @DisplayName("UC004_TS032_TC01 - Move towards the hole where the pellet is located.")
    void UC003_TS015_TC01() {
        launcher.launch();
        getGame().stop();
        getGame().start();

        Game game = launcher.getGame();
        assertThat(game.isInProgress()).isTrue();
    }
    @Test
    @DisplayName("TS033_TC01 - Move into an empty space")
        void UC003_TS016_TC01() {
        launcher.launch();
        getGame().stop();

        Game game = launcher.getGame();
        assertThat(game.isInProgress()).isFalse();
    }
    @Test
    @DisplayName("TS033_TC01 - Move into an empty space")
    void UC003_TS017_TC01() {
        //Test restart button
    }
    @Test
    @DisplayName("TS033_TC01 - Move into an empty space")
    void UC003_TS018_TC01() {
        //Test home button
    }
    @Test
    @DisplayName("TS002_TC01 - Move towards the hole where the pellet is located.")
    void TS002_TC019_PlayerMove() {
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
    void TS002_TC020_PlayerMove() {
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
    void TS002_TC021_PlayerMove() {
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
    void TS002_TC022_PlayerMove() {
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
    void TS002_TC023_PlayerMove() {
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
