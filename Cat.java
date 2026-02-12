
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
    public void tick(Zoo z, int tickCount) {
        boolean past500 = tickCount > 500;

        if (isSick) {
            if (past500) {
                isAlive = Zoo.rand.nextInt(10) != 0;
            } else {
                isAlive = Zoo.rand.nextInt(1000) != 0;
            }
        } else {
            if (past500) isAlive = Zoo.rand.nextInt(100) != 0;
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void move(Zoo zoo) {
        // TODO Auto-generated method stub
        
    }
}
