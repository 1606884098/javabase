package base.java5netty.netty1.bio2;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	final static int PORT = 8765;

	public static void main(String[] args) {
		ServerSocket server = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			server = new ServerSocket(PORT);
			System.out.println("server start");
			Socket socket = null;
			/**
			 * 内部维护了一个线程池，防止bio 里面的情况发生  这个方式是伪异步的方式  1.5以前  都这么操作
			 */
			HandlerExecutorPool executorPool = new HandlerExecutorPool(50, 1000);
			int i=0;
			while(true){
				i++;
				socket = server.accept();
				executorPool.execute(new ServerHandler(socket,i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null){
				try {
					in.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(server != null){
				try {
					server.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
			server = null;				
		}
		
	
	
	}
	
	
}
