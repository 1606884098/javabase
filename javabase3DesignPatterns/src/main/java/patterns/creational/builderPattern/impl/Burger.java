package patterns.creational.builderPattern.impl;

import patterns.creational.builderPattern.Item;
import patterns.creational.builderPattern.Packing;

/**
 * 汉堡包装和价格
 */
public abstract class Burger implements Item {


    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
