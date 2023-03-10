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
import nl.tudelft.jpacman.ui.DifficultyUI;
import nl.tudelft.jpacman.ui.HomeUI;
import nl.tudelft.jpacman.ui.MapUI;
import nl.tudelft.jpacman.ui.ScoreUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class JpacmanTest_UC006 {
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
    @DisplayName("TS050_TC01 - at the start of the game Direction.Unit is east")
    void UC006_TS050_TC01(){
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        game.move(player, Direction.EAST);
        assertThat(player.getDirection()).isEqualTo(Direction.EAST);
    }
    @Test
    @DisplayName("TS051_TC02 - at the start of the game Direction.Unit is west")
    void UC006_TS051_TC02(){
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        game.move(player, Direction.WEST);
        assertThat(player.getDirection()).isEqualTo(Direction.WEST);
    }
    @Test
    @DisplayName("TS051_TC03 - at the start of the game Direction.Unit is north")
    void UC006_TS051_TC03(){
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        game.move(player, Direction.NORTH);
        assertThat(player.getDirection()).isEqualTo(Direction.NORTH);
    }
    @Test
    @DisplayName("TS051_TC04 - at the start of the game Direction.Unit is south")
    void UC006_TS051_TC04(){
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        game.move(player, Direction.SOUTH);
        assertThat(player.getDirection()).isEqualTo(Direction.SOUTH);
    }
    @Test
    @DisplayName("TS052_TC01 - Player status before game start")
    void UC006_TS052_TC01(){

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        assertThat(player.isAlive()).isTrue();
    }

    @Test
    @DisplayName("TS053_TC01 - Player status after starting the game")
    void UC006_TS053_TC01(){
        launcher.launch();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        assertThat(player.isAlive()).isTrue();
    }
    @Test
    @DisplayName("TS054_TC01 - Player status on start")
    void UC006_TS054_TC01(){
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        assertThat(player.isAlive()).isTrue();
    }
    @Test
    @DisplayName("TS055_TC01 - Player status when stopped")
    void UC006_TS055_TC01(){
        launcher.launch();
        getGame().stop();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        assertThat(player.isAlive()).isTrue();
    }
    @Test
    @DisplayName("TS056_TC01 - Player state when start and then stop")
    void UC006_TS056_TC01(){
        launcher.launch();
        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        getGame().stop();

        assertThat(player.isAlive()).isTrue();
    }
    @Test
    @DisplayName("TS057_TC01 - Player status on Level when not started")
    void UC006_TS057_TC01(){

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        assertThat(level.isAnyPlayerAlive()).isFalse();
    }

    @Test
    @DisplayName("TS057_TC02 - Player status on Level when not started")
    void UC006_TS057_TC02(){
        launcher.launch();
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        assertThat(level.isAnyPlayerAlive()).isTrue();
    }

    @Test
    @DisplayName("TS058_TC01 - Player status on Level when stopped without starting")
    void UC006_TS058_TC01(){


        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();
        level.stop();
        assertThat(player.isAlive()).isFalse();
    }
    @Test
    @DisplayName("TS058_TC02 - Player status on Level when stopped without starting")
    void UC006_TS058_TC02(){
        launcher.launch();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();
        level.stop();
        assertThat(player.isAlive()).isTrue();
    }
    @Test
    @DisplayName("TS059_TC01 - Player status on Level on start")
    void UC006_TS059_TC01(){

        getGame().start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        assertThat(player.isAlive()).isFalse();
    }
    @Test
    @DisplayName("TS059_TC02 - Player status on Level on start")
    void UC006_TS059_TC02(){
        launcher.launch();
        level.start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();

        assertThat(player.isAlive()).isTrue();
    }
    @Test
    @DisplayName("TS060_TC01 - Player status on Level when start then stop")
    void UC006_TS060_TC01(){

        level.start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();
        level.stop();
        assertThat(player.isAlive()).isFalse();
    }
    @Test
    @DisplayName("TS060_TC02 - Player status on Level when start then stop")
    void UC006_TS060_TC02(){
        launcher.launch();
        level.start();

        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        assertThat(game.isInProgress()).isTrue();
        level.stop();
        assertThat(player.isAlive()).isTrue();
    }
    @Test
    @DisplayName("TS061_TC01 - Width Size of Sprites")
    public void  UC006_TS061_TC01_spriteWidth() {
        assertThat(sprite.getWidth()).isEqualTo(SPRITE_SIZE);
    }

    /**
     * Verifies the height of a static sprite.
     */
    @Test
    @DisplayName("TS061_TC02 - Height Size of Sprites")
    public void UC006_TS061_TC02_spriteHeight() {
        assertThat(sprite.getHeight()).isEqualTo(SPRITE_SIZE);
    }

    /**
     * Verifies that an IOException is thrown when the resource could not be
     * loaded.
     *
     * @throws IOException
     *             since the sprite cannot be loaded.
     */
    @Test
    @DisplayName("TS061_TC03 - Verifies that an IOException is thrown when the resource could not be loaded.")
    public void UC006_TS061_TC03_resourceMissing() throws IOException {
        assertThatThrownBy(() -> store.loadSprite("/sprite/nonexistingresource.png"))
            .isInstanceOf(IOException.class);
    }

    /**
     * Verifies that an animated sprite is correctly cut from its base image.
     */
    @Test
    @DisplayName("TS061_TC04 - Verifies that an animated sprite is correctly cut from its base image.")
    public void UC006_TS061_TC04_animationWidth() {
        AnimatedSprite animation = store.createAnimatedSprite(sprite, 4, 0,
            false);
        assertThat(animation.getWidth()).isEqualTo(16);
    }

    /**
     * Verifies that an animated sprite is correctly cut from its base image.
     */
    @Test
    @DisplayName("TS061_TC05 - Verifies that an animated sprite is correctly cut from its base image.")
    public void UC006_TS061_TC05_animationHeight() {
        AnimatedSprite animation = store.createAnimatedSprite(sprite, 4, 0,
            false);
        assertThat(animation.getHeight()).isEqualTo(64);
    }

    /**
     * Verifies that an split sprite is correctly cut from its base image.
     */
    @Test
    @DisplayName("TS061_TC06 - Verifies that an animated sprite is correctly cut from its base image.")
    public void UC006_TS061_TC06_splitWidth() {
        Sprite split = sprite.split(10, 11, 12, 13);
        assertThat(split.getWidth()).isEqualTo(12);
    }

    /**
     * Verifies that an split sprite is correctly cut from its base image.
     */
    @Test
    @DisplayName("TS061_TC07 - Verifies that an split sprite is correctly cut from its base image.")
    public void UC006_TS061_TC07_splitHeight() {
        Sprite split = sprite.split(10, 11, 12, 13);
        assertThat(split.getHeight()).isEqualTo(13);
    }

    /**
     * Verifies that a split that isn't within the actual sprite returns an empty sprite.
     */
    @Test
    @DisplayName("TS061_TC08 - Verifies that a split that isn't within the actual sprite returns an empty sprite.")
    public void UC006_TS061_TC08_splitOutOfBounds() {
        Sprite split = sprite.split(10, 10, 64, 10);
        assertThat(split).isInstanceOf(EmptySprite.class);
    }

}
