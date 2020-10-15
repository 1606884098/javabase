package base.java5netty.netty1.bio2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 用单线程来解决并发问题是sun开发bio的目的，redis的核心思想也是用单线程来解决并发  调用epoll函数
 * jdk底层也是调用epoll函数
 */
public class Client {
	
	final static String ADDRESS = "127.0.0.1";
	final static int PORT =8765;
	
	public static void main(String[] args) {
		for(int i=0;i<50000;i++){


		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			socket = new Socket(ADDRESS, PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			
			out.println("Client request"+i);
			
			String response = in.readLine();
			System.out.println("Client:" + response);
			
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
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
			if(socket != null){
				try {
					socket.close();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
			}
			socket = null;				
		}


		}
	}

}
