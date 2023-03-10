package nl.tudelft.jpacman;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.sprite.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

public class JpacmanTest_UC007 {
    private Launcher launcher;

    private MapParser parser;

    private Level level;

    private Sprite sprite;
    private SpriteStore store;

    private static final int SPRITE_SIZE = 64;
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

        store = new SpriteStore();
        try {
            sprite = store.loadSprite("/sprite/64x64white.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    @DisplayName("TS062_TC01 - Counting the remaining coins on the board")
    public void UC006_TC62() {
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        assertThat(launcher.getGame().getLevel().remainingPellets()).isEqualTo(4);
    }
}
