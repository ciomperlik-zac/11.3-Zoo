
import java.awt.Graphics;

public abstract class Entity {
    // optional code to assign a sequencial entity ID
    private static int lastID = 0;
    protected int id;

    protected String name;
    protected int x, y;
    protected boolean isAlive;

    public Entity(String name, int x, int y) {
        // optional code to assign a sequencial entity ID
        this.id = lastID;
        lastID = lastID + 1;

        this.name = name;
        this.x = x;
        this.y = y;
    }

    // ABSTRACT METHODS
    // tick and draw are called by the Zoo class

    public abstract void tick(Zoo z, int tickCount);

    public abstract void draw(Graphics g);

    // NON-ABSTRACT METHODS
    // isAlive, getX, and getY are all called by the Zoo class

    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
