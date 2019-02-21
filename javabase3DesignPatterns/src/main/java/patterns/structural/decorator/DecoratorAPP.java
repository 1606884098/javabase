package patterns.structural.decorator;

import patterns.structural.decorator.impl.Circle;
import patterns.structural.decorator.impl.Rectangle;
import patterns.structural.decorator.impl.RedShapeDecorator;

/**
 * what:装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。
 * 它是作为现有的类的一个包装。这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名
 * 完整性的前提下，提供了额外的功能.
 * why:一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展
 * 功能的增多，子类会很膨胀。可以动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相
 * 比生成子类更为灵活。如果直接实现接口的话，添加功能需要接口实现类同时修改，抽象装饰类  子类继承的时候
 * 可以直接引用已有的方法当然也可以覆盖，实现抽象的方法，动态添加子类新的方法
 * 应用场景：
 *  1、孙悟空有 72 变，当他变成"庙宇"后，他的根本还是一只猴子，但是他又有了庙宇的功能。
 *  2、不论一幅画有没有画框都可以挂在墙上，但是通常都是有画框的，并且实际上是画框被挂在墙上。
 *  在挂在墙上之前，画可以被蒙上玻璃，装到框子里；这时画、玻璃和画框形成了一个物体。
 *   3、扩展一个类的功能。
 *   4、动态增加功能，动态撤销。
 *   5、dao层封装类
 *   how:在不想增加很多子类的情况下扩展类。将具体功能职责划分，同时继承装饰者模式。
 *   example:画图
 *   1.图形接口：shape 定义基础的功能
 *   2.抽象装饰类：ShapeDecorator 并把 Shape对象作为它的实例变量。
 *   3.实体装饰类：RedShapeDecorator  动态添加功能红色边框
 */
public class DecoratorAPP {
    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
