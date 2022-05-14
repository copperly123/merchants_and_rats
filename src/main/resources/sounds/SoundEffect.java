package a9.sounds;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


/**
 * @Author Aidan Spendlove
 * An extendable class designed to play a specific audio clip
 */
public class SoundEffect {
    private Clip soundEffect;
    private BooleanControl volume;

    /**
     * @param filePath Path to sound file
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    public SoundEffect(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream songStream;
        songStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        soundEffect = AudioSystem.getClip();
        soundEffect.open(songStream);
        volume = (BooleanControl) soundEffect.getControl(BooleanControl.Type.MUTE);
        volume.setValue(false);
    }

    /**
     * Plays the audio clip until the end
     *
     * @throws LineUnavailableException
     * @throws IOException
     */
    public void play() throws LineUnavailableException, IOException {
        soundEffect.setFramePosition(0);
        soundEffect.start();
    }

    /**
     * @param muteState Sets the mute state, true = sound off, false = sound on
     * @throws LineUnavailableException
     * @throws IOException
     */
    public void setMute(boolean muteState) throws LineUnavailableException, IOException {
        volume.setValue(muteState);
    }


    /**
     * Closes the audio stream
     */
    public void close() {
        soundEffect.close();
    }
}
