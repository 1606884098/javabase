package base.java5netty.netty1.bio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HandlerExecutorPool {

	private ExecutorService executor;
	public HandlerExecutorPool(int maxPoolSize, int queueSize){
		this.executor = new ThreadPoolExecutor(
				Runtime.getRuntime().availableProcessors(),
				maxPoolSize, //当前服务端可以创建的最大线程数
				120L, //如果120秒时间内  如果线程是空闲的就回收  也就是关闭
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(queueSize));//有界队列
	}
	
	public void execute(Runnable task){
		this.executor.execute(task);
	}
	
	
	
}
