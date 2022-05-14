package a9.sounds;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ZombieSound extends SoundEffect {
    public ZombieSound() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super("src/a9/sounds/zombie.wav");
    }
}
