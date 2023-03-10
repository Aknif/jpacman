package nl.tudelft.jpacman;

import com.google.common.collect.Lists;
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

import java.util.Arrays;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class JpacmanTest_UC001 {
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

    @Test
    @DisplayName("TS002_TC01 - The width of the board is equal to 2")
    void UC001_TS002_TC01() {

        final int MAX_WIDTH = 2;

        final Square[][] grid = {
            {mock(Square.class), mock(Square.class), mock(Square.class)},
            {mock(Square.class), mock(Square.class), mock(Square.class)},
        };
        final Board board = new Board(grid);

        assertThat(board.getWidth()).isEqualTo(MAX_WIDTH);
    }

    @Test
    @DisplayName("TS003_TC01 - The height of the board is equal to 3")
    void UC001_TS003_TC01() {

        final int MAX_HEIGHT = 3;

        final Square[][] grid = {
            {mock(Square.class), mock(Square.class), mock(Square.class)},
            {mock(Square.class), mock(Square.class), mock(Square.class)},
        };
        final Board board = new Board(grid);

        assertThat(board.getHeight()).isEqualTo(MAX_HEIGHT);
    }

    @Test
    @DisplayName("TS004_TC01 - Coordinates (0,0) on the board")
    void UC001_TS004_TC01() {
        int x = 0, y = 0;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(0, 0);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC02 - Coordinates (0,1) on the board")
    void UC001_TS004_TC02() {
        int x = 0, y = 1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(0, 1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC03 - Coordinates (0,2) on the board")
    void UC001_TS004_TC03() {
        int x = 0, y = 2;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(0, 2);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC04 - Coordinates (1,0) on the board")
    void UC001_TS004_TC04() {
        int x = 1, y = 0;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(1, 0);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC05 - Coordinates (1,1) on the board")
    void UC001_TS004_TC05() {
        int x = 1, y = 1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(1, 1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC06 - Coordinates (1,2) on the board")
    void UC001_TS004_TC06() {
        int x = 1, y = 2;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(1, 2);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC07 - Coordinates (-1,0) on the board")
    void UC001_TS004_TC07() {
        int x = -1, y = 0;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(-1, 0);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC08 - Coordinates (-1,1) on the board")
    void UC001_TS004_TC08() {
        int x = -1, y = 1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(-1, 1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC09 - Coordinates (-1,2) on the board")
    void UC001_TS004_TC09() {
        int x = -1, y = 2;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(-1, 2);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC10 - Coordinates (2,0) on the board")
    void UC001_TS004_TC10() {
        int x = 2, y = 0;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(2, 0);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC11 - Coordinates (2,1) on the board")
    void UC001_TS004_TC11() {
        int x = 2, y = 1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(2, 1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC12 - Coordinates (2,2) on the board")
    void UC001_TS004_TC12() {
        int x = 2, y = 2;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(2, 2);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC13 - Coordinates (0,-1) on the board")
    void UC001_TS004_TC13() {
        int x = 0, y = -1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(0, -1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC14 - Coordinates (0,3) on the board")
    void UC001_TS004_TC14() {
        int x = 0, y = 3;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(0, 3);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC15 - Coordinates (1,-1) on the board")
    void UC001_TS004_TC15() {
        int x = 1, y = -1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(1, -1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC16 - Coordinates (1,3) on the board")
    void UC001_TS004_TC16() {
        int x = 1, y = 3;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(1, 3);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC17 - Coordinates (-1,-1) on the board")
    void UC001_TS004_TC17() {
        int x = -1, y = -1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(-1, -1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC18 - Coordinates (-1,3) on the board")
    void UC001_TS004_TC18() {
        int x = -1, y = 3;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(-1, 3);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC19 - Coordinates (2,-1) on the board")
    void UC001_TS004_TC19() {
        int x = 2, y = -1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(2, -1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS004_TC20 - Coordinates (2,3) on the board")
    void UC001_TS004_TC20() {
        int x = 2, y = 3;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        Square result = b.squareAt(x, y);
        Square expected = b.squareAt(2, 3);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("TS005_TC01 - The coordinates (0,0) on the board do exist")
    void UC001_TS005_TC01() {
        int x = 0, y = 0;
        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC02 - The coordinates (0,1) on the board do exist")
    void UC001_TS005_TC02() {
        int x = 0, y = 1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC03 - The coordinates (0,2) on the board do exist")
    void UC001_TS005_TC03() {
        int x = 0, y = 2;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC04 - The coordinates (1,0) on the board do exist")
    void UC001_TS005_TC04() {
        int x = 1, y = 0;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC05 - The coordinates (1,1) on the board do exist")
    void UC001_TS005_TC05() {
        int x = 1, y = 1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC06 - The coordinates (1,2) on the board do exist")
    void UC001_TS005_TC06() {
        int x = 1, y = 2;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC07 - The coordinates (-1,0) on the board do exist")
    void UC001_TS005_TC07() {
        int x = -1, y = 0;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC08 - The coordinates (-1,1) on the board do exist")
    void UC001_TS005_TC08() {
        int x = -1, y = 1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC09 - The coordinates (-1,2) on the board do exist")
    void UC001_TS005_TC09() {
        int x = -1, y = 2;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC10 - The coordinates (2,0) on the board do exist")
    void UC001_TS005_TC10() {
        int x = 2, y = 0;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC11 - The coordinates (2,-1) on the board do exist")
    void UC001_TS005_TC11() {
        int x = 2, y = 1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC12 - The coordinates (2,2) on the board do exist")
    void UC001_TS005_TC12() {
        int x = 2, y = 2;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC13 - The coordinates (0,-1) on the board do exist")
    void UC001_TS005_TC13() {
        int x = 0, y = -1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC14 - The coordinates (0,3) on the board do exist")
    void UC001_TS005_TC14() {
        int x = 0, y = 3;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC15 - The coordinates (1,-1) on the board do exist")
    void UC001_TS005_TC15() {
        int x = 1, y = -1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC16 - The coordinates (1,3) on the board do exist")
    void UC001_TS005_TC16() {
        int x = 1, y = 3;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC17 - The coordinates (-1,-1) on the board do exist")
    void UC001_TS005_TC17() {
        int x = -1, y = -1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC18 - The coordinates (-1,3) on the board do exist")
    void UC001_TS005_TC18() {
        int x = -1, y = 3;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC19 - The coordinates (2,-1) on the board do exist")
    void UC001_TS005_TC19() {
        int x = 2, y = -1;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS005_TC20 - The coordinates (2,3) on the board do exist")
    void UC001_TS005_TC20() {
        int x = 2, y = 3;

        Board b = parser.parseMap(
            Lists.newArrayList("####", "#  #", "## #", "####")).getBoard();
        boolean result = b.withinBorders(x, y);

        assertThat(result).isEqualTo(TRUE);
    }

    @Test
    @DisplayName("TS006_TC01 - The cell is connected to itself on all sides.")
    void UC001_TS006_TC01() {
        PacManSprites sprites = mock(PacManSprites.class);
        factory = new BoardFactory(sprites);

        s1 = new BasicSquare();
        s2 = new BasicSquare();

        factory.createBoard(new Square[][]{{s1}});
        assertThat(Arrays.stream(Direction.values()).map(s1::getSquareAt)).containsOnly(s1);
    }

    @Test
    @DisplayName("TS007_TC01 - the cell is connected to the east.")
    void UC001_TS007_TC01() {
        PacManSprites sprites = mock(PacManSprites.class);
        factory = new BoardFactory(sprites);

        s1 = new BasicSquare();
        s2 = new BasicSquare();

        factory.createBoard(new Square[][]{{s1}, {s2}});
        assertThat(s1.getSquareAt(Direction.EAST)).isEqualTo(s2);
        assertThat(s2.getSquareAt(Direction.EAST)).isEqualTo(s1);
    }

    @Test
    @DisplayName("TS008_TC01 - the cell is connected to the west.")
    void UC001_TS008_TC01() {
        PacManSprites sprites = mock(PacManSprites.class);
        factory = new BoardFactory(sprites);

        s1 = new BasicSquare();
        s2 = new BasicSquare();

        factory.createBoard(new Square[][]{{s1}, {s2}});
        assertThat(s1.getSquareAt(Direction.WEST)).isEqualTo(s2);
        assertThat(s2.getSquareAt(Direction.WEST)).isEqualTo(s1);
    }

    @Test
    @DisplayName("TS009_TC01 - the cell is connected to the north.")
    void UC001_TS009_TC01() {
        PacManSprites sprites = mock(PacManSprites.class);
        factory = new BoardFactory(sprites);

        s1 = new BasicSquare();
        s2 = new BasicSquare();

        factory.createBoard(new Square[][]{{s1, s2}});
        assertThat(s1.getSquareAt(Direction.NORTH)).isEqualTo(s2);
        assertThat(s2.getSquareAt(Direction.NORTH)).isEqualTo(s1);
    }

    @Test
    @DisplayName("TS010_TC01 - the cell is connected to the south.")
    void UC001_TS010_TC01() {
        PacManSprites sprites = mock(PacManSprites.class);
        factory = new BoardFactory(sprites);

        s1 = new BasicSquare();
        s2 = new BasicSquare();

        factory.createBoard(new Square[][]{{s1, s2}});
        assertThat(s1.getSquareAt(Direction.SOUTH)).isEqualTo(s2);
        assertThat(s2.getSquareAt(Direction.SOUTH)).isEqualTo(s1);
    }

    @Test
    @DisplayName("TS011_TC01 - Units are occupied by square blocks.")
    void UC001_TS011_TC01() {
        Unit occupant = mock(Unit.class);
        square.put(occupant);

        assertThat(square.getOccupants()).contains(occupant);
    }

    @Test
    @DisplayName("TS012_TC01 - There is no occupant of the block after the unit has left the block.")
    void UC001_TS012_TC01() {
        Unit occupant = mock(Unit.class);
        square.put(occupant);
        square.remove(occupant);

        assertThat(square.getOccupants()).doesNotContain(occupant);
    }

    @Test
    @DisplayName("TS013_TC01 - The order of entering squares is maintained.")
    void UC001_TS013_TC01() {
        Unit o1 = mock(Unit.class);
        Unit o2 = mock(Unit.class);
        square.put(o1);
        square.put(o2);

        assertThat(square.getOccupants()).containsSequence(o1, o2);
    }
}
