package Game;

import org.pixel.content.ContentManager;
import org.pixel.content.Texture;
import org.pixel.math.Rectangle;
import org.pixel.math.Vector2;

public class Actor {

    protected Vector2 position;

    private int size;
    private int health;
    private int coolDown;
    private int speed;
    private int attackDamage;
    private Texture texture;

    protected Rectangle hitbox;

    public Actor(int id, float xPosition, float yPosition, int health, int coolDown, int speed, int attackDamage, String texturePath) {
        position = new Vector2(xPosition, yPosition);
        this.health = health;
        this.coolDown = coolDown;
        this.speed = speed;
        this.attackDamage = attackDamage;

        texture = new Texture(id);
        ContentManager contentManager = new ContentManager();
        texture = contentManager.load(texturePath, Texture.class);

        hitbox = new Rectangle(position.getX(), position.getY(), texture.getWidth(), texture.getHeight());
    }

    public Vector2 getVector() {
        return position;
    }

    public Vector2 getCenter() {
        return new Vector2(position.getX() / 2, position.getY() / 2);
    }

    public void setPosition(Vector2 newPosition) {
        position = newPosition;
    }

    public void move(ActiveActors activeActors) {
        if (!isCollidingAny(activeActors)) {

        }

    }

    public boolean isAlive() {
        return health > 0;
    }

    public void makeDead() {
        health = 0;
    }

    public Texture getTexture() {
        return texture;
    }

    public boolean isColliding(Actor other) {
        return hitbox.contains(other.getVector());
//        return position.getX() +
//
//            (yPosition + size >= other.yPosition) // See if this rectangle is above other
//                    && (yPosition <= other.yPosition + other.size) // See if this rectangle is below other
//                    && (xPosition + size >= other.xPosition) // See if this rectangle is left of other
//                    && (xPosition <= other.xPosition + other.size)
    }

    public boolean isCollidingAny(ActiveActors activeActors) {
        for (Actor other : activeActors.actors) {
            if (isColliding(other)) {
                return true;
            }
        }
        return false;
    }

}
