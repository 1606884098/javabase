package patterns.behavioral.strategy;
/**
 * 枚举类型:确定采用的是什么方式支付
 * @author Administrator
 *
 */
public enum RechargeTypeEnum {

	E_BANK(1,"网银"),
	BUSI_ACCOUNTS(2,"商户账号"),
	MOBILE(3,"手机充值"),
	CARD_RECHARGE(4,"充值卡");
	
	private int value;
	
	private String description;
	
	private RechargeTypeEnum(int value,String description){
		this.value=value;
		this.description=description;
	}
	
	public int value(){
		return value;
	}
	
	public String description(){
		return description;
	}
	
	public static RechargeTypeEnum valueOf(int value){
		for(RechargeTypeEnum type:RechargeTypeEnum.values()){
			if(value==type.value()){
				return type;
			}
		}
		return null;
	}
}
