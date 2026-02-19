
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

        if (tickCount % 10 == 0) move(zoo);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🐈", Zoo.wrap(x, Zoo.ZOO_COLS) * Zoo.SCALE, Zoo.wrap(y, Zoo.ZOO_ROWS) * Zoo.SCALE + 25);
    }

    @Override
    public void eat(Food food) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void move(Zoo zoo) {
        int dx = 0;
        int dy = 0;

        if (zoo.at(x + 1, y).stream().anyMatch(e -> e instanceof Edible)) {
            dx += 1;
        } else if (zoo.at(x - 1, y).stream().anyMatch(e -> e instanceof Edible)) {
            dx -= 1;
        } else if (zoo.at(x, y + 1).stream().anyMatch(e -> e instanceof Edible)) {
            dy += 1;
        } else if (zoo.at(x, y - 1).stream().anyMatch(e -> e instanceof Edible)) {
            dy -= 1;
        } else {
            int change = Zoo.rand.nextBoolean() ? 1 : -1;

            if (Zoo.rand.nextBoolean()) {
                dx += change;
            } else {
                dy += change;
            }
        }

        x = zoo.wrapWidth(x + dx);
        y = zoo.wrapHeight(y + dy);
    }
}
