import java.awt.*;

public class Cheese extends Food {
    
    int timesEaten = 0;

    // TODO: add constructor
    public Cheese(String name, int x, int y) {
        super(name, x, y, 10);
    }

    @Override
    public void beEaten(Animal a) {
        switch (timesEaten) {
            case 0:
                nutritionalValue = 8;
                break;

            case 1:
                nutritionalValue = 5;
                break;

            case 2:
                isAlive = false;
                break;

            default:
                break;
        }

        timesEaten ++;
    }

    @Override
    public void tick(Zoo z, int tickCount) {
        
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 25));
        g.drawString("🧀", Zoo.wrap(x, Zoo.ZOO_COLS) * Zoo.SCALE, Zoo.wrap(y, Zoo.ZOO_ROWS) * Zoo.SCALE + 25);
    }
}
