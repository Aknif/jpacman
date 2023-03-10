package nl.tudelft.jpacman;

import com.google.common.collect.Lists;
import nl.tudelft.jpacman.board.*;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.*;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.npc.ghost.Navigation;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class JpacmanTest_UC004 {
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
    void UC004_TS032_TC01() {
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        game.move(player, Direction.EAST);
        assertThat(player.getScore()).isEqualTo(10);
    }
    @Test
    @DisplayName("TS033_TC01 - Move into an empty space")
    void UC004_TS033_TC01() {
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
    @DisplayName("TS034_TC01 - Move towards the walled hole.")
    void UC004_TS034_TC01() {
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
    @DisplayName("TS035_TC01 - Move to the square where the Ghost is located.")
    void UC004_TS035_TC01() {
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
    @DisplayName("TS036_TC01 - Move to the square containing the last pellet.")
    void UC004_TS036_TC01() {
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
    @Test
    @DisplayName("TS037_TC01 - The player presses the \"Stop\" button.")
    void UC004_TS037_TC01(){
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        game.stop();
        assertThat(game.isInProgress()).isFalse();
    }
    @Test
    @DisplayName("TS038_TC01 - The player presses the \"Start\" button.")
    void UC004_TS038_TC01(){
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        game.stop();
        assertThat(game.isInProgress()).isFalse();
        game.start();
        assertThat(game.isInProgress()).isTrue();
    }
}
