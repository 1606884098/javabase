package patterns.behavioral.template;

/**
 * what:模板模式（Template Pattern）一个抽象类公开定义了执行它的方法的方式/模板。
 * 它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行.
 * why:定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。
 * 模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
 * 应用场景：
 * 1、在造房子的时候，地基、走线、水管都一样，只有在建筑的后期才有加壁橱加栅栏等差异。
 * 2、西游记里面菩萨定好的 81 难，这就是一个顶层的逻辑骨架。
 * 3、spring 中对 Hibernate 的支持，将一些已经定好的方法封装起来，比如开启事务、
 * 获取 Session、关闭 Session 等，程序员不重复写那些已经规范好的代码，直接丢一个实体
 * 就可以保存。
 * 4、有多个子类共有的方法，且逻辑相同。
 * 5、重要的、复杂的方法，可以考虑作为模板方法。
 * 6、组卷思路,比如数学每张试卷都是选择、判断、简答题，这就是模板方法
 * how:将这些通用算法抽象出来,却在每一个子类都重新写了这一方法。
 * example:游戏
 * 1.游戏步骤类：Game 将通用的方法抽取出来
 * 2.具体游戏的实现类：Football 将方法按足球特性实现
 */
public class TemplateApp {

    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
