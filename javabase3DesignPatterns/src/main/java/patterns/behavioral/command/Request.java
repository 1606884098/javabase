package patterns.behavioral.command;

public class Request {

	private String type;
	
	private int quantity;

	public Request(String type, int quantity) {
		super();
		this.type = type;
		this.quantity = quantity;
	}
	
	public void post(){
		System.out.println("请求方式："+this.type+"--请求次数："+this.quantity);
	}
	
	public void get(){
		System.out.println("请求方式："+this.type+"--请求次数："+this.quantity);
	}
	
}
