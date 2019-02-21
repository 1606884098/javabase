package patterns.creational.builderPattern.impl;

import patterns.creational.builderPattern.Packing;

/**
 * 打包汉堡
 */
public class Wrapper implements Packing {
    public String pack() {
        return "Wrapper";
    }
}
