package patterns.behavioral.command.impl;

import patterns.behavioral.command.Order;
import patterns.behavioral.command.Request;

public class PostOrder implements Order {

	private Request request;
	
	public PostOrder(Request request){
		this.request=request;
	}
	@Override
	public void execute() {
		request.get();
	}

}
