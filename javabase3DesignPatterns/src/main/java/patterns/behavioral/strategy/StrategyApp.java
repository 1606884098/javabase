package patterns.behavioral.strategy;

/**
 * what:在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改.
 * 我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的 context 对象。策略对象改变 context 对象的执行算法。
 *
 *why:在有多种算法相似的情况下，使用 if...else 所带来的复杂和难以维护。
 *  1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。
 *  2、一个系统需要动态地在几种算法中选择一种。
 *  3、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
 *  应用场景：
 *  1、诸葛亮的锦囊妙计，每一个锦囊就是一个策略。
 *  2、旅行的出游方式，选择骑自行车、坐汽车，每一种旅行方式都是一个策略。
 *  3、付款方式不同，折扣不同
 *
 *  how:定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。
 *  example:付款方式不同，折扣不同
 *  1.策略上下文：Context 根据传入策略利用工厂选择策略
 *  2.工厂类：StrategyFactory 实例化所有的策略
 *  3.付款策略接口：IStrategy 所有的付款策略都实现该接口
 *  4.付款实体类：RechargeTypeEnum
 *  类图见：http://www.runoob.com/design-pattern/strategy-pattern.html
 */
public class StrategyApp {
	public static void main(String[] args) {  
		   
	       Context context = new Context();  
	       // 网银充值100 需要付多少  
	       Double money = context.calRecharge(100D,  
	              RechargeTypeEnum.E_BANK.value());  
	       System.out.println(money);  
	   
	       // 商户账户充值100 需要付多少  
	       Double money2 = context.calRecharge(100D,  
	              RechargeTypeEnum.BUSI_ACCOUNTS.value());  
	       System.out.println(money2);  
	   
	       // 手机充值100 需要付多少  
	       Double money3 = context.calRecharge(100D,  
	              RechargeTypeEnum.MOBILE.value());  
	       System.out.println(money3);  
	   
	       // 充值卡充值100 需要付多少  
	       Double money4 = context.calRecharge(100D,  
	              RechargeTypeEnum.CARD_RECHARGE.value());  
	       System.out.println(money4);  
	    }  
}
