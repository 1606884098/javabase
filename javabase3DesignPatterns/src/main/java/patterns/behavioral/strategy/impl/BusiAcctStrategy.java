package patterns.behavioral.strategy.impl;


import patterns.behavioral.strategy.IStrategy;
import patterns.behavioral.strategy.RechargeTypeEnum;

public class BusiAcctStrategy implements IStrategy {

	@Override
	public Double calRecharge(Double charge, RechargeTypeEnum tpye) {

		return charge*0.9;//商户充值9折扣
	}

}
