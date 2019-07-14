package base.java4soket.TCP;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/*TCP通讯协议特点：
1. tcp是基于IO流进行数据 的传输 的，面向连接。
	2. tcp进行数据传输的时候是没有大小限制的。
	3. tcp是面向连接，通过三次握手的机制保证数据的完整性。 可靠协议。
	4. tcp是面向连接的，所以速度慢。
	5. tcp是区分客户端与服务端 的。

	比如： 打电话、 QQ\feiQ的文件传输、 迅雷下载....

tcp协议下的Socket：
Socket(客户端) , tcp的客户端一旦启动马上要与服务端进行连接。
ServerSocket(服务端类)

tcp的客户端使用步骤：
1. 建立tcp的客户端服务。
2. 获取到对应的流对象。
3.写出或读取数据
4. 关闭资源。*/
public class TCPClient {
    public static void main(String[] args) throws Exception, Exception {
        //建立tcp的服务
        Socket socket = new Socket(InetAddress.getLocalHost(),9090);
        //获取socket的输入流对象
        InputStream inputStream = socket.getInputStream();
        //获取文件的输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\3.jpg");
        //边读边写
        byte[] buf = new byte[1024];
        int length = 0 ;
        while((length = inputStream.read(buf))!=-1){
            fileOutputStream.write(buf,0,length);
        }
        //关闭资源
        fileOutputStream.close();
        socket.close();
    }
}
