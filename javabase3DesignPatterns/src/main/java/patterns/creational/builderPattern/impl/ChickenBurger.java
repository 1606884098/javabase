package patterns.creational.builderPattern.impl;

/**
 * 鸡肉汉堡，依赖抽象
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
