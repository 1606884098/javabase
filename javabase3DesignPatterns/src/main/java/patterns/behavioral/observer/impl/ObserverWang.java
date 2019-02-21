package patterns.behavioral.observer.impl;


import patterns.behavioral.observer.Observer;

public class ObserverWang implements Observer {

	@Override
	public void update(String content) {
		System.out.println("王斯：观察到韩非子有活动，我在监视！");
		this.report(content);
		System.out.println("王斯：报告完毕！");
	}
	
	public void report(String content){
		System.out.println("王斯：报告"+content);
	}

}
