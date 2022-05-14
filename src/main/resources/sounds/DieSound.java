package a9.sounds;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class DieSound extends SoundEffect {
    public DieSound() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super("src/a9/sounds/die.wav");
    }
}
