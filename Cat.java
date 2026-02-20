
import java.util.*;
import java.awt.*;

// TODO: extend Animal
public class Cat extends Animal {
    private int lives = 9;

    // TODO: add constructor
    public Cat(String name, int x, int y) {
        super(name, x, y);
    }

    // TODO: override the tick method
    @Override
    public void tick(Zoo zoo, int tickCount) {
        boolean past500 = tickCount > 500;

        // Handle Death
        if (isSick) {
            if (past500) {
                if (Zoo.percentChance(10)) lives -= 1;
            } else {
                if (Zoo.percentChance(0.1)) lives -=1;
            }
        } else if (past500) {
            if (Zoo.percentChance(1)) lives -= 1;
        }

        isAlive = lives > 0;

        // Handle movement
        if (tickCount % 10 == 0) move(zoo);

        // Handle breeding
        if (!zoo.findAdjacentMatches(x, y, e -> e instanceof Cat).isEmpty()) {
            if (Zoo.percentChance(10)) {
                
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🐈", Zoo.wrap(x, Zoo.ZOO_COLS) * Zoo.SCALE, Zoo.wrap(y, Zoo.ZOO_ROWS) * Zoo.SCALE + 25);
    }

    @Override
    public void eat(Food food) {
        if (hunger > 25) {
            if (Zoo.percentChance(99)) {
                hunger -= food.nutritionalValue;
                food.beEaten(this);
            }
        }
    }

    @Override
    public void move(Zoo zoo) {
        int dx = 0;
        int dy = 0;

        ArrayList<Entity> foods = zoo.findAdjacentMatches(x, y, e -> e instanceof Edible);

        if (!foods.isEmpty()) {
            Entity food = foods.get(0);

            dx = food.x - x;
            dy = food.y - y;
        } else {
            dx = (int) (Math.random() * 3) - 1;

            if (dx == 0) {
                dy = Zoo.rand.nextBoolean() ? -1 : 1;
            } else {
                dy = (int) (Math.random() * 3) - 1;
            }
        }

        if (!zoo.atMatches(x + dx, y + dy, e -> e instanceof Animal && !(e instanceof Rat)).isEmpty()) {
                dx *= -1;
                dy *= -1;
        }

        x = zoo.wrapWidth(x + dx);
        y = zoo.wrapHeight(y + dy);
    }
}
