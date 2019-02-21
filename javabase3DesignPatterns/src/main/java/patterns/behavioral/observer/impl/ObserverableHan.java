package patterns.behavioral.observer.impl;


import patterns.behavioral.observer.Observer;
import patterns.behavioral.observer.Observerable;

import java.util.ArrayList;
import java.util.List;

public class ObserverableHan implements Observerable {

	private List<Observer> list=new ArrayList<Observer>();//存放观察者被通知的对象
	@Override
	public void addObserver(Observer observer) {//添加观察者
		list.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {//删除观察者
		list.remove(observer);
	}

	@Override//实际生产环境中这个一般是异步操作
	public void notifyObserver(String content) {//通知所有的观察者
		for(Observer observer:list){
			observer.update(content);
		}
	}

	public void haveBreakfast(){
		System.out.println("韩非子：我要开始吃早饭.");
		this.notifyObserver("韩非子开始吃早饭.");
	}

	public void havaFun(){
		System.out.println("韩非子：我要开始唱歌了！");
		this.notifyObserver("韩非子开始唱歌了！");
	}
}
