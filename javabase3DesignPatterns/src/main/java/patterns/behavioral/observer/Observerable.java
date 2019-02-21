package patterns.behavioral.observer;
/**
 * 被观察者都必须具备的功能
 * @author Administrator
 *
 */
public interface Observerable {

	public void addObserver(Observer observer);
	
	public void deleteObserver(Observer observer);
	
	public void notifyObserver(String content);
	
}
