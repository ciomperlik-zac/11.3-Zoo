
// TODO: make Food abstract
// TODO: extend Entity
public abstract class Food extends Entity implements Edible {
    protected int nutritionalValue;

    public Food(String name, int x, int y, int nutritionalValue) {
        super(name, x, y);

        this.nutritionalValue = nutritionalValue;
    }

    @Override
    public abstract void beEaten(Animal a);
}
