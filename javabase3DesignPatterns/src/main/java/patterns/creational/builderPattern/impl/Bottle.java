package patterns.creational.builderPattern.impl;

import patterns.creational.builderPattern.Packing;

/**
 * 用于包装饮料
 */
public class Bottle implements Packing {

    public String pack() {
        return "Bottle";
    }
}
