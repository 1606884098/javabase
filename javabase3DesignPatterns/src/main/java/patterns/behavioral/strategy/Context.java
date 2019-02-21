package patterns.behavioral.strategy;

public class Context {

	private IStrategy strategy;
	
	public Double calRecharge(Double charge,Integer tpye){
		strategy=StrategyFactory.getInstance().creator(tpye);
		return strategy.calRecharge(charge, RechargeTypeEnum.valueOf(tpye));
	}

	public IStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IStrategy strategy) {
		this.strategy = strategy;
	}
	
	
}
