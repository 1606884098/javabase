package patterns.creational.builderPattern.impl;

/**
 * 素汉堡，依赖抽象
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
