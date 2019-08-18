package base.java5netty.netty1.aio;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;

public class Client1 implements Runnable{

	private AsynchronousSocketChannel asc ;

	public Client1() throws Exception {
		asc = AsynchronousSocketChannel.open();
	}
	
	public void connect(){
		asc.connect(new InetSocketAddress("127.0.0.1", 8768));
	}
	
	public void write(String request){
		try {
			asc.write(ByteBuffer.wrap(request.getBytes())).get();
			read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void read() {
		ByteBuffer buf = ByteBuffer.allocate(1024);
		try {
			asc.read(buf).get();
			buf.flip();
			byte[] respByte = new byte[buf.remaining()];
			buf.get(respByte);
			System.out.println(new String(respByte,"utf-8").trim());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true){
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		Client1 c1 = new Client1();
		c1.connect();
		
		Client1 c2 = new Client1();
		c2.connect();
		
		Client1 c3 = new Client1();
		c3.connect();
		
		new Thread(c1, "c11").start();
		new Thread(c2, "c12").start();
		new Thread(c3, "c13").start();
		
		Thread.sleep(1000);
		
		c1.write("c11 aaa");
		c2.write("c12 bbbb");
		c3.write("c13 ccccc");
	}
	
}
