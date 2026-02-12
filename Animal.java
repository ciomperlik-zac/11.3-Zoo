
public abstract class Animal extends Entity {
    protected int hunger;
    protected boolean isSick;

    public Animal(String name, int x, int y) {
        super(name, x, y);
    }

    public abstract void eat(Food food);

    public abstract void move(Zoo zoo);

    public int getHunger() {
        return hunger;
    }

    public boolean isSick() {
        return isSick;
    }
}
