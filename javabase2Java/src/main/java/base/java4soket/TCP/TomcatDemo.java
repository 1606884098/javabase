package base.java4soket.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*            注意：
                    1.如果使用BuffrerdReader的readline方法一定要加上\r\n才把数据写出。
                    2.使用字符流一定要调用flush方法数据才会写出。
模拟Tomcat服务器   浏览器相当于是客户端 http://localhost:9090直接可以方法 有帮助理解tomcat*/
public class TomcatDemo  extends Thread {



        Socket socket;

        public TomcatDemo(Socket socket){
            this.socket = socket;
        }


        public void run() {
            try {
                //获取socket的输出流对象
                OutputStream outputStream = socket.getOutputStream();
                //把数据写到浏览器上
                outputStream.write("<html><head><title>aaa</title></head><body>你好啊浏览器</body></html>".getBytes());
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public static void main(String[] args) throws IOException {
            //建立tcp的服务端
            ServerSocket serverSocket = new ServerSocket(9090);
            //不断的接受客户端的连接
            while(true){
                Socket socket = serverSocket.accept();
                new TomcatDemo(socket).start();
            }
        }


}
