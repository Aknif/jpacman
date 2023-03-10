package nl.tudelft.jpacman;

import com.google.common.collect.Lists;
import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.*;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class JpacmanTest_UC002 {
    private Launcher launcher;
    private MapParser parser;

    private Level level;

    /**
     * An NPC on this level.
     */
    private final Ghost ghost = mock(Ghost.class);

    /**
     * Starting position 1.
     */
    private final Square square1 = mock(Square.class);

    /**
     * Starting position 2.
     */
    private final Square square2 = mock(Square.class);

    /**
     * The board for this level.
     */
    private final Board board = mock(Board.class);

    /**
     * The collision map.
     */
    private final CollisionMap collisions = mock(CollisionMap.class);

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

        final long defaultInterval = 100L;
        level = new Level(board, Lists.newArrayList(ghost), Lists.newArrayList(
            square1, square2), collisions);
        when(ghost.getInterval()).thenReturn(defaultInterval);
    }
    private Game getGame() {
        return launcher.getGame();
    }
    @Test
    @DisplayName("TS014_TC01 - game start")
    void UC002_TS014_TC01() {
        launcher.launch();
        getGame().start();

        assertThat(getGame().isInProgress()).isTrue(); //Check if game is running
    }
    @Test
    @DisplayName("TS015_TC01 - The state of the level when the game has not yet started")
    void UC002_TS015_TC01() {
        launcher.launch();

        assertThat(getGame().isInProgress()).isFalse(); //Check if game is running
    }
    @Test
    @DisplayName("TS016_TC01 - The state of the level when it is stopped even though the game has not yet started.")
    void UC002_TS016_TC01() {
        launcher.launch();
        getGame().stop();

        assertThat(getGame().isInProgress()).isFalse();
    }
    @Test
    @DisplayName("TS017_TC01 - The state of the level when the game starts.")
    void UC002_TS017_TC01() {
        launcher.launch();
        getGame().getLevel().start();

        assertThat(getGame().getLevel().isInProgress()).isTrue();
    }
    @Test
    @DisplayName("TS018_TC01 - The state of the level when the game starts and then stops.")
    void UC002_TS018_TC01() {
        launcher.launch();
        getGame().getLevel().start();
        getGame().getLevel().stop();

        assertThat(getGame().getLevel().isInProgress()).isFalse();
    }
    @Test
    @DisplayName("TS019_TC01 - The player starts the game in the correct slot position.")
    void UC002_TS019_TC01() {
        Player p = mock(Player.class);
        level.registerPlayer(p);
        verify(p).occupy(square1);
    }

    @Test
    @DisplayName("TS020_TC01 - Registering a player twice will not happen.")
    void UC002_TS020_TC01() {
        Player p = mock(Player.class);
        level.registerPlayer(p);
        level.registerPlayer(p);
        verify(p, times(1)).occupy(square1);
    }

    @Test
    @DisplayName("TS021_TC01 - Registering a second player puts that player in the correct starting slot.")
    void UC002_TS021_TC01() {
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        level.registerPlayer(p1);
        level.registerPlayer(p2);
        verify(p2).occupy(square2);
    }

    @Test
    @DisplayName("TS022_TC01 - Register a third player so that player is in the correct starting field.")
    void UC002_TS022_TC01() {
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        Player p3 = mock(Player.class);
        level.registerPlayer(p1);
        level.registerPlayer(p2);
        level.registerPlayer(p3);
        verify(p3).occupy(square1);
    }
}
