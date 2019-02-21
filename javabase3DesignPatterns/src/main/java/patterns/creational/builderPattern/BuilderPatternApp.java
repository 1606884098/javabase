package patterns.creational.builderPattern;

/**
 * what:建造者模式（Builder Pattern）使用多个简单的对象一步一步构建成一个复杂的对象。
 * 一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。
 * <p>
 * why:主要解决在软件系统中，有时候面临着"一个复杂对象"的创建工作，其通常由各个部分的子对象用
 * 一定的算法构成；由于需求的变化，这个复杂对象的各个部分经常面临着剧烈的变化，但是将它们组合在
 * 一起的算法却相对稳定。需要生成的对象具有复杂的内部结构。需要生成的对象内部属性本身相互依赖。
 * 应用场景：
 * 1、去肯德基，汉堡、可乐、薯条、炸鸡翅等是不变的，而其组合是经常变化的，生成出所谓的"套餐"。
 * 2、JAVA 中的 StringBuilder。
 * 3、组卷
 * 4.电话卡套餐
 * <p>
 * how:一些基本部件不会变，而其组合经常变化,将变与不变分离开.
 * example:套餐
 * 我们假设一个快餐店的商业案例，其中，一个典型的套餐可以是一个汉堡（Burger）和
 * 一杯冷饮（Cold drink）。汉堡（Burger）可以是素食汉堡（Veg Burger）或鸡肉汉堡
 * （Chicken Burger），它们是包在纸盒中。冷饮（Cold drink）可以是可口可乐（coke）
 * 或百事可乐（pepsi），它们是装在瓶子中。我们将创建一个表示食物条目（比如汉堡和冷饮）
 * 的 Item 接口和实现 Item 接口的实体类，以及一个表示食物包装的 Packing 接口和实现
 * Packing 接口的实体类，汉堡是包在纸盒中，冷饮是装在瓶子中。然后我们创建一个 Meal 类，
 * 带有 Item 的 ArrayList 和一个通过结合 Item 来创建不同类型的 Meal 对象的 MealBuilder。
 * 1.套餐组合类：MealBuilder用于组合套餐
 * 2.套餐类：Meal描述套餐信息
 * 3.商品接口：item不经常变化的类，套餐成员
 * 4.商品的具体实现
 * 类图见：http://www.runoob.com/design-pattern/builder-pattern.html
 */
public class BuilderPatternApp {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal mealA = mealBuilder.mealA();
        mealA.showItems();
        System.out.println("total cost:" + mealA.getCost());


        Meal mealB = mealBuilder.mealB();
        mealB.showItems();
        System.out.println("total cost:" + mealB.getCost());


    }
}
