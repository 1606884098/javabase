package base.java5netty.netty1.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	//线程池
	private ExecutorService executorService;
	//线程组
	private AsynchronousChannelGroup threadGroup;
	//服务器通道
	public AsynchronousServerSocketChannel assc;
	
	public Server(int port){
		try {
			//创建一个缓存池
			executorService = Executors.newCachedThreadPool();
			//创建线程组
			threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);
			//创建服务器通道   aio是通过线程组把客户端接入
			assc = AsynchronousServerSocketChannel.open(threadGroup);
			//进行绑定
			assc.bind(new InetSocketAddress(port));
			
			System.out.println("server start , port : " + port);
			//进行阻塞   并非真正意义上的阻塞  就是接入进来的意思
			assc.accept(this, new ServerCompletionHandler());
			//一直阻塞 不让服务器停止  这里的处理才是真正意义上的阻塞， 但是实际中是放在tomcat里的所有的请求都能被拦截处理
			Thread.sleep(Integer.MAX_VALUE);//为了不让程序停止
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server(8768);
	}
	
}
