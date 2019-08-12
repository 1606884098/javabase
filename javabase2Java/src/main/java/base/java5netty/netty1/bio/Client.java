package base.java5netty.netty1.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 3次握手的概念   就是客户端发一次消息给服务端，服务端返回信息给客户端，
 */
public class Client {

	final static String ADDRESS = "127.0.0.1";
	final static int PORT = 8765;
	
	public static void main(String[] args) {
		//while (true) {//添加测试代码
			Socket socket = null;
			BufferedReader in = null;
			PrintWriter out = null;

			try {
				socket = new Socket(ADDRESS, PORT);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				//向服务器端发送数据
				out.println("接收到客户端的请求数据...");
				String response = in.readLine();
				System.out.println("Client: " + response);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				socket = null;
			}
		}
	//}
}
