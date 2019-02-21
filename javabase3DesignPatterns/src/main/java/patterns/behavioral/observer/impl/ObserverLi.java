package patterns.behavioral.observer.impl;


import patterns.behavioral.observer.Observer;

public class ObserverLi implements Observer {

	@Override
	public void update(String content) {
		System.out.println("李斯：观察到韩非子有活动了！");
		reportQSH("报告完毕--李斯");
	}
	
	public void reportQSH(String reportContent){
		System.out.println("李斯报告：秦始皇！韩非子有活动！----"+reportContent);
	}

}
