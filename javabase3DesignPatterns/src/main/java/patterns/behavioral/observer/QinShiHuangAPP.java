package patterns.behavioral.observer;


import patterns.behavioral.observer.impl.ObserverLi;
import patterns.behavioral.observer.impl.ObserverWang;
import patterns.behavioral.observer.impl.ObserverableHan;

/**
 * what:观察者模式（Observer Pattern）当对象间存在一对多关系时,当一个对象被修改时，则会自动通知它的依赖对象。
 * why:一个对象状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，保证高度的协作。
 * 1、拍卖的时候，拍卖师观察最高标价，然后通知给其他竞价者竞价。
 * 2、西游记里面悟空请求菩萨降服红孩儿，菩萨洒了一地水招来一个老乌龟，这个乌龟就是观察者，他观察菩萨洒水这个动作。
 * 应用场景：
 * 一个抽象模型有两个方面，其中一个方面依赖于另一个方面。将这些方面封装在独立的对象中使它们可以各自独立地改变和复用。
 * 一个对象的改变将导致其他一个或多个对象也发生改变，而不知道具体有多少对象将发生改变，可以降低对象之间的耦合度。
 * 一个对象必须通知其他对象，而并不知道这些对象是谁。
 * 需要在系统中创建一个触发链，A对象的行为将影响B对象，B对象的行为将影响C对象……，可以使用观察者模式创建一种链式触发机制。
 * how：一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知，进行广播通知。
 * 使用面向对象技术，可以将这种依赖关系弱化。
 * 避免循环引用。如果顺序执行，某一观察者错误会导致系统卡壳，一般采用异步方式。
 * example:李斯，王斯监视韩非子 报告给秦始皇
 * 观察者接口：Observer 被通知的对象接口
 * 被观察者接口：Observerable 被监视的对象接口
 */
public class QinShiHuangAPP {

    public static void main(String[] args) throws Exception {

        Observer li = new ObserverLi();
        Observer wang = new ObserverWang();

        ObserverableHan han = new ObserverableHan();//如果是多态不能访问子类特有的方法
        han.addObserver(li);//添加观察者
        han.addObserver(wang);

        han.haveBreakfast();
        Thread.sleep(3000);
        System.out.println("----------------------现在是晚上9点---------------------");
        han.havaFun();
    }
}
