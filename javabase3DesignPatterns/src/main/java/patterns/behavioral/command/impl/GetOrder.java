package patterns.behavioral.command.impl;


import patterns.behavioral.command.Order;
import patterns.behavioral.command.Request;

public class GetOrder implements Order {

	private Request request;
	
	public GetOrder(Request request){
		this.request=request;
	}
	@Override
	public void execute() {
		request.post();
	}

}
