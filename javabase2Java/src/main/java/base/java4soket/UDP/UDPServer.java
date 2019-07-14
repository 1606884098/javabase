package base.java4soket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
接收端的使用步骤
1. 建立udp的服务
2. 准备空 的数据 包接收数据。
3. 调用udp的服务接收数据。
4. 关闭资源
*/
//群聊接收端
public class UDPServer extends Thread {


        @Override
        public void run() {
            try {
                //建立udp的服务,要监听一个端口
                DatagramSocket socket = new DatagramSocket(9090);
                //准备空的数据包存储数据
                byte[] buf = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                boolean flag = true;
                while(flag){
                    socket.receive(packet);//receive是一个阻塞型的方法，没有接收到数据包之前会一直等待。 数据实际上就是存储到了byte的自己数组中了。
                    // packet.getAddress() 获取对方数据 包的IP地址对象。
                    System.out.println(packet.getAddress().getHostAddress()+"说:"+new String(buf,0,packet.getLength()));// getLength() 获取数据包存储了几个字节。
                }
                //关闭资源
                socket.close();
            }catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

}
