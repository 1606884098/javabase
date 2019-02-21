package patterns.behavioral.strategy.impl;


import patterns.behavioral.strategy.IStrategy;
import patterns.behavioral.strategy.RechargeTypeEnum;

public class MobileStrategy implements IStrategy {

	@Override
	public Double calRecharge(Double charge, RechargeTypeEnum tpye) {

		return charge;//手机充值无折扣
	}

}
