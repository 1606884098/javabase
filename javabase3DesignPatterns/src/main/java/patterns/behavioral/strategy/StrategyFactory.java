package patterns.behavioral.strategy;


import patterns.behavioral.strategy.impl.BusiAcctStrategy;
import patterns.behavioral.strategy.impl.CardStrategy;
import patterns.behavioral.strategy.impl.EBankStrategy;
import patterns.behavioral.strategy.impl.MobileStrategy;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("")
public class StrategyFactory {
	
	private static class StrategyFactoryBuilder{
		private static final StrategyFactory FACTORY=new StrategyFactory();
	}
	
	private StrategyFactory(){};
	
	public static StrategyFactory getInstance(){
		return StrategyFactoryBuilder.FACTORY;
	}
	
	private static Map strategyMap=new HashMap();
	
	static{
	       strategyMap.put(RechargeTypeEnum.E_BANK.value(), new EBankStrategy());
	       strategyMap.put(RechargeTypeEnum.BUSI_ACCOUNTS.value(), new BusiAcctStrategy());
	       strategyMap.put(RechargeTypeEnum.MOBILE.value(), new MobileStrategy());
	       strategyMap.put(RechargeTypeEnum.CARD_RECHARGE.value(), new CardStrategy());
	}
	
	public IStrategy creator(Integer tpye){
		return (IStrategy) strategyMap.get(tpye);
	}
	
}
