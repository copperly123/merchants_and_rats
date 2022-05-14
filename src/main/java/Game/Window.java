package Game;

import org.pixel.commons.DeltaTime;
import org.pixel.core.Camera2D;
import org.pixel.core.PixelWindow;
import org.pixel.core.WindowMode;
import org.pixel.core.WindowSettings;
import org.pixel.graphics.render.SpriteBatch;

public class Window extends PixelWindow {

    /**
     * Constructor
     *
     * @param settings
     */
    public Window(WindowSettings settings) {
        super(settings);
    }

    ActiveActors activeActors;
    private SpriteBatch spriteBatch;
    Camera2D viewport;

    private Actor test;
    private Actor test2;

    /**
     * Where the content of the game is loaded.
     */
    @Override
    public void load() {
        activeActors = new ActiveActors();
        spriteBatch = new SpriteBatch();
        viewport = new Camera2D(this);
        viewport.setZoom(3);

        test = new Actor(1, 0, 0, 0, 0, 0, 0, "images/bombMouse.png");
        activeActors.addActor(test);
        test2 = new Actor(2, 20, 20, 0, 0, 0, 0, "images/mouse.png");
        activeActors.addActor(test2);

    }

    /**
     * Where the game logic is updated.
     *
     * @param delta The elapsed time since the last frame
     */
    @Override
    public void update(DeltaTime delta) {
        Ticks.incrementTicks();

//        if(Ticks.actionReady(40)) {
//            for(Actor actor: activeActors.actors) {
//                actor.setPosition(new Vector2(actor.getVector().getX(),actor.getVector().getY()+10));
//            }
//        }
    }

    /**
     * Where the drawing of textures/text/primitives/etc happens.
     *
     * @param delta The elapsed time since the last frame
     */
    @Override
    public void draw(DeltaTime delta) {
        spriteBatch.begin(viewport.getViewMatrix());

        for (Actor actor : activeActors.actors) {
            spriteBatch.draw(actor.getTexture(), actor.getVector());
//            spriteBatch.draw(actor.getTexture(),actor.getVector(),Color.WHITE, actor.getCenter(),4);
        }

        spriteBatch.end();

    }

    /**
     * Where native instances are released from memory.
     */
    @Override
    public void dispose() {
        super.dispose();
    }

    public static void main(String[] args) {
        WindowSettings settings = new WindowSettings("game", 800, 500);
//        settings.setWindowResizable(true);
        settings.setVsync(true);
        settings.setMultisampling(2);
        settings.setWindowMode(WindowMode.WINDOWED);
        Window window = new Window(settings);
        window.start();
    }
}
