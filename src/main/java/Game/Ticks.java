package Game;

/**
 * This class keeps track of the time elapsed since the beginning of the game
 *
 * @author Aidan Spendlove
 */
public class Ticks {
    private static int ticks = 0;

    public static int getTicks() {
        return ticks;
    }

    public static boolean isTicksEven() {
        return ticks % 2 == 0;
    }

    public static void incrementTicks() {
        ticks++;
    }

    public static void resetTicks() {
        ticks = 0;
    }

    public static long ticksToSeconds() {
        return ticks / 50;
    }

    /**
     * This method returns ticks % timeToPerform == 0
     * This is useful to only perform actions after a certain delay
     *
     * @param timeToPerform
     * @return
     */
    public static boolean actionReady(int timeToPerform) {
        return (ticks % timeToPerform == 0);
    }
}
