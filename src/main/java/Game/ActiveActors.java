package Game;

import java.util.ArrayList;

public class ActiveActors {
    protected ArrayList<Actor> actors;

    public ActiveActors() {
        actors = new ArrayList<>();
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public static boolean isColliding(Actor actor, Actor other) {
        return actor.hitbox.contains(other.getVector());
    }

    public static boolean isCollidingAny(Actor actor, ActiveActors actors) {
        for (Actor other : actors.actors) {
            if (actor.isColliding(other)) {
                return true;
            }
        }
        return false;
    }

}
