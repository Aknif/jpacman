package nl.tudelft.jpacman.sound;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/*
*       SOUND CONTROLLER
*
*       !!how to call!!
*       playSound.play("path/to/sound/file.wav");
*
* from SOUNDPACK
*           SOUNDPACK/Pacman-death-sound.wav
*           SOUNDPACK/pickupPallets.wav
*           SOUNDPACK/test.wav
*
*       playsound in playerCollisions when hit padllets and ghost
* */


public class playSound {

    public static void play(String soundFile) {
        try {
            // Create a new AudioInputStream from the sound file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile).getAbsoluteFile());

            // Get a Clip object to play the sound
            Clip clip = AudioSystem.getClip();

            // Open the AudioInputStream with the Clip
            clip.open(audioInputStream);

            // Play the sound
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error playing sound file: " + ex.getMessage());
        }
    }

}


