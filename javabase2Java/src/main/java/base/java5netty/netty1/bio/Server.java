package base.java5netty.netty1.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	final static int PROT = 8765;
	
	public static void main(String[] args) {
		//while(true){//添加测试代码


		ServerSocket server = null;
		try {
			server = new ServerSocket(PROT);
			System.out.println(" server start .. ");
			//进行阻塞  阻塞的意思就是放弃了cpu
			Socket socket = server.accept();//在这个位置阻塞了  ServerSocket是专门用来处理Socket的负责连接
			//socket.getInputStream();//io流这里也是阻塞的  如果先连接上的Socket不发数据过来，那么会阻塞在这里，所以并发需要多线程来解决
			//新建一个线程执行客户端的任务  问题就在与如果一个客户端创建一个线程
			// 客户端多了 创建线程数多  资源被占用过多 线程池过多就把机器撑爆了
			new Thread(new ServerHandler(socket)).start();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(server != null){
				try {
					server.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			server = null;
		}

		}
		
	//}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
