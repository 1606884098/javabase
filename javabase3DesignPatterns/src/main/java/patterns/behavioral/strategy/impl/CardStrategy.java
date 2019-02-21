package patterns.behavioral.strategy.impl;


import patterns.behavioral.strategy.IStrategy;
import patterns.behavioral.strategy.RechargeTypeEnum;

public class CardStrategy implements IStrategy {

	@Override
	public Double calRecharge(Double charge, RechargeTypeEnum tpye) {

		return charge+charge*0.01; //充值卡冲送1%
	}

}
