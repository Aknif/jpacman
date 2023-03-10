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
import static org.mockito.Mockito.*;

public class JpacmanTest_UC003 {
    private Launcher launcher;
    private MapParser parser;
    private Level level;
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
    }
    private Game getGame() {
        return launcher.getGame();
    }
    @Test
    @DisplayName("TS023_TC01 - testShortestPathEmpty")
    void UC003_TS023_TC01() {
        Board b = parser.parseMap(Lists.newArrayList(" ")).getBoard();
        Square s1 = b.squareAt(0, 0);
        Square s2 = b.squareAt(0, 0);
        List<Direction> path = Navigation
            .shortestPath(s1, s2, mock(Unit.class));
        assertThat(path).isEmpty();
    }

    /**
     * Verifies that if no path exists, the result is <code>null</code>.
     */
    @Test
    @DisplayName("TS024_TC01 - testNoShortestPath")
    void UC003_TS024_TC01() {
        Board b = parser
            .parseMap(Lists.newArrayList("#####", "# # #", "#####"))
            .getBoard();
        Square s1 = b.squareAt(1, 1);
        Square s2 = b.squareAt(3, 1);
        List<Direction> path = Navigation
            .shortestPath(s1, s2, mock(Unit.class));
        assertThat(path).isNull();
    }

    /**
     * Verifies that having no traveller ignores terrain.
     */
    @Test
    @DisplayName("TS025_TC01 - testNoTraveller")
    void UC003_TS025_TC01() {
        Board b = parser
            .parseMap(Lists.newArrayList("#####", "# # #", "#####"))
            .getBoard();
        Square s1 = b.squareAt(1, 1);
        Square s2 = b.squareAt(3, 1);
        List<Direction> path = Navigation.shortestPath(s1, s2, null);
        assertThat(path).containsExactly(Direction.EAST, Direction.EAST);
    }

    /**
     * Tests if the algorithm can find a path in a straight line.
     */
    @Test
    @DisplayName("TS026_TC01 - testSimplePath")
    void UC003_TS026_TC01() {
        Board b = parser.parseMap(Lists.newArrayList("####", "#  #", "####"))
            .getBoard();
        Square s1 = b.squareAt(1, 1);
        Square s2 = b.squareAt(2, 1);
        List<Direction> path = Navigation
            .shortestPath(s1, s2, mock(Unit.class));
        assertThat(path).containsExactly(Direction.EAST);
    }

    /**
     * Verifies that the algorithm can find a path when it has to take corners.
     */
    @Test
    @DisplayName("TS027_TC01 - testCornerPath")
    void UC003_TS027_TC01() {
        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square s1 = b.squareAt(1, 1);
        Square s2 = b.squareAt(2, 2);
        List<Direction> path = Navigation
            .shortestPath(s1, s2, mock(Unit.class));
        assertThat(path).containsExactly(Direction.EAST, Direction.SOUTH);
    }

    /**
     * Verifies that the nearest object is detected.
     */
    @Test
    @DisplayName("TS028_TC01 - testNearestUnit")
    void UC003_TS028_TC01() {
        Board b = parser
            .parseMap(Lists.newArrayList("#####", "# ..#", "#####"))
            .getBoard();
        Square s1 = b.squareAt(1, 1);
        Square s2 = b.squareAt(2, 1);
        Square result = Navigation.findNearest(Pellet.class, s1).getSquare();
        assertThat(result).isEqualTo(s2);
    }

    /**
     * Verifies that there is no such location if there is no nearest object.
     */
    @Test
    @DisplayName("TS029_TC01 - testNoNearestUnit")
    void UC003_TS029_TC01() {
        Board b = parser.parseMap(Lists.newArrayList(" ")).getBoard();
        Square s1 = b.squareAt(0, 0);
        Unit unit = Navigation.findNearest(Pellet.class, s1);
        assertThat(unit).isNull();
    }

    /**
     * Verifies that there is ghost on the default board
     * next to cell [1, 1].
     *
     * @throws IOException if board reading fails.
     */
    @Test
    @DisplayName("TS030_TC01 - testFullSizedLevel")
    void UC003_TS030_TC01() throws IOException {
        try (InputStream i = getClass().getResourceAsStream("/board.txt")) {
            Board b = parser.parseMap(i).getBoard();
            Square s1 = b.squareAt(1, 1);
            Unit unit = Navigation.findNearest(Ghost.class, s1);
            assertThat(unit).isNotNull();
        }
    }
    @Test
    @DisplayName("TS031_TC01 - The ghost moves where the player is.")
    void UC003_TS031_TC01() throws InterruptedException {
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
