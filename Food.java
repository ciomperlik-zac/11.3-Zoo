
// TODO: make Food abstract
// TODO: extend Entity
public abstract class Food extends Entity implements Edible {
    protected boolean animalProduct, vegetableProduct;
    protected int nutritionalValue;

    public Food(String name, int x, int y, boolean animalProduct, boolean vegetableProduct, int nutritionalValue) {
        super(name, x, y);

        this.animalProduct = animalProduct;
        this.vegetableProduct = vegetableProduct;
        this.nutritionalValue = nutritionalValue;
    }

    @Override
    public abstract void beEaten(Animal a);
}
