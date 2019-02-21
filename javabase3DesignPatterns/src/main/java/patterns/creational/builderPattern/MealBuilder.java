package patterns.creational.builderPattern;

import patterns.creational.builderPattern.impl.ChickenBurger;
import patterns.creational.builderPattern.impl.Coke;
import patterns.creational.builderPattern.impl.Pepsi;
import patterns.creational.builderPattern.impl.VegBurger;

/**
 * 常变化的套餐组合类
 */
public class MealBuilder {

    public Meal mealA() {
        Meal mealA=new Meal();
        mealA.addItem(new VegBurger());
        mealA.addItem(new Coke());
        return mealA;
    }

    public Meal mealB() {
        Meal mealB=new Meal();
        mealB.addItem(new ChickenBurger());
        mealB.addItem(new Pepsi());
        return mealB;
    }
}
