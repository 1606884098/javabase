package patterns.behavioral.strategy.impl;


import patterns.behavioral.strategy.IStrategy;
import patterns.behavioral.strategy.RechargeTypeEnum;

public class EBankStrategy implements IStrategy {

	@Override
	public Double calRecharge(Double charge, RechargeTypeEnum tpye) {

		return charge*0.85;//银行充值85折扣
	}

}
