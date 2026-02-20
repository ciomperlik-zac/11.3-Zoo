import java.util.ArrayList;
import java.awt.*;

public class Rat extends Animal implements Edible {
    private int dx, dy = 0;
    private int timeTillTurn = 0;

    protected int nutritionalValue = 10;

    // TODO: add constructor
    public Rat(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public void beEaten(Animal a) {
        isAlive = false;
    }

    // TODO: override the tick method
    @Override
    public void tick(Zoo zoo, int tickCount) {
        boolean past500 = tickCount > 500;

        // Handle death
        if (isSick) {
            if (past500) {
                isAlive = !Zoo.percentChance(20);
            } else {
                isAlive = !Zoo.percentChance(1);
            }
        } else if (past500) {
            isAlive = !Zoo.percentChance(1.5);
        }

        // Handle direction change
        if (timeTillTurn < 0) {
            dx = (int) (Math.random() * 3) - 1;

            if (dx == 0) {
                dy = Zoo.rand.nextBoolean() ? -1 : 1;
            } else {
                dy = (int) (Math.random() * 3) - 1;
            }

            timeTillTurn = 40 + Zoo.rand.nextInt(20);
        } else {
            timeTillTurn--;
        }

        // Handle movement
        if (tickCount % 5 == 0) move(zoo);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🐀", Zoo.wrap(x, Zoo.ZOO_COLS) * Zoo.SCALE, Zoo.wrap(y, Zoo.ZOO_ROWS) * Zoo.SCALE + 25);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Edible || hunger > 50) {
            hunger -= food.nutritionalValue;
            food.beEaten(this);
        }
    }

    @Override
    public void move(Zoo zoo) {
        int dx_, dy_ = 0;

        ArrayList<Entity> foods = zoo.findAdjacentMatches(x, y, e -> e instanceof Edible);
        if (!foods.isEmpty()) {
            Entity food = foods.get(0);

            dx_ = food.x - x;
            dy_ = food.y - y;
        } else {
            dx_ = dx;
            dy_ = dy;
        }

        x = zoo.wrapWidth(x + dx_);
        y = zoo.wrapHeight(y + dy_);
    }
}
