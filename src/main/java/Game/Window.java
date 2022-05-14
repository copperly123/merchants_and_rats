package Game;

import org.pixel.commons.DeltaTime;
import org.pixel.core.PixelWindow;
import org.pixel.core.WindowMode;
import org.pixel.core.WindowSettings;

public class Window extends PixelWindow {

    public static void main(String[] args) {
        WindowSettings settings = new WindowSettings("game",500,500);
        settings.setWindowResizable(true);
        settings.setVsync(true);
        settings.setMultisampling(2);
        settings.setWindowMode(WindowMode.WINDOWED);
        Window window = new Window(settings);
        window.start();
    }

    /**
     * Constructor
     *
     * @param settings
     */
    public Window(WindowSettings settings) {
        super(settings);
    }

    /**
     * Where the content of the game is loaded.
     */
    @Override
    public void load() {

    }

    /**
     * Where the game logic is updated.
     *
     * @param delta The elapsed time since the last frame
     */
    @Override
    public void update(DeltaTime delta) {

    }

    /**
     * Where the drawing of textures/text/primitives/etc happens.
     *
     * @param delta The elapsed time since the last frame
     */
    @Override
    public void draw(DeltaTime delta) {

    }

    /**
     * Where native instances are released from memory.
     */
    @Override
    public void dispose() {
        super.dispose();
    }
}
