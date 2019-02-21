package patterns.creational.builderPattern.impl;

import patterns.creational.builderPattern.Item;
import patterns.creational.builderPattern.Packing;

/**
 * 饮料包装
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
