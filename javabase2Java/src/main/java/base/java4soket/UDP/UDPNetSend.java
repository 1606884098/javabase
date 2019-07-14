package base.java4soket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPNetSend {
    public static void main(String[] args) throws Exception {
		/*		InetAddress(IP类)
		常用的方法：
			getLocalHost();  获取本机的IP地址
			getByName("IP或者主机名") 根据一个IP地址的字符串形式或者是一个主机名生成一个IP地址对象。 (用于获取别人的IP地址对象)
			getHostAddress()  返回一个IP地址的字符串表示形式。
			getHostName()  返回计算机的主机名。*/

        //getLocalHost 获取本机的IP地址对象
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("IP地址："+address.getHostAddress());
        System.out.println("主机名："+address.getHostName());
        //获取别人机器的IP地址对象。
        //可以根据一个IP地址的字符串形式或者是一个主机名生成一个IP地址对象。
        InetAddress address1 = InetAddress.getByName("LKCNCTI55FUHM28");
        System.out.println("IP地址："+address.getHostAddress());
        System.out.println("主机名："+address.getHostName());

        InetAddress[]  arr = InetAddress.getAllByName("www.baidu.com");//域名
        System.out.println("域名："+arr);
        //UDP协议测试
        UDPServer chatReceive = new UDPServer();
        chatReceive.start();
        UDPClient chatSender = new UDPClient();
        chatSender.start();

/*		udp是一个不可靠（数据包可能会丢失）的协议
		什么情况下数据包会出现丢失呢？
			1.带宽不足 。
			2.cpu的处理能力不足。
		//建立udp的服务
		DatagramSocket socket = new DatagramSocket();
		//准备数据，数据封装到数据中发送
		DatagramPacket packet = null;
		for(int i =  0 ; i< 10; i++){  //连续发送10个数据包
			String data =i +"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
			packet = new DatagramPacket(data.getBytes(), data.getBytes().length, InetAddress.getLocalHost(), 9090);
			//发送数据包
			socket.send(packet);
		}
		//关闭资源
		socket.close();

		//建立udp的服务
		DatagramSocket socket2 = new DatagramSocket(9090);
		//建立空的数据包存储数据
		byte[] buf = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(buf, buf.length);
		//不断接收数据包
		while(true){
			socket2.receive(packet2);
			System.out.println(new String(buf,0,packet.getLength()));
			Thread.sleep(10);
		}*/
		/*
		 每个网络程序都有自己所处理的特定格式数据,如果接收到的数据不符合指定的格式，那么就会被当成垃圾数据丢弃。(加密..)
		 飞Q接收的数据格式：
		 version:time :sender : ip: flag:content ;
		 版本号          时间         发送人   :IP： 发送的标识符(32): 真正的内容;
		 在udp协议中，有一个IP地址称作为广播地址，广播地址就是主机号为255地址。
		 给广播IP地址发送消息的时候，在同一个网络段的机器都可以接收 到信息。
		 192.168.15.255
		 */
        //使用udp协议给飞Q发送消息。
        // 建立udp的服务
        DatagramSocket socket2 = new DatagramSocket();
        // 准备数据，把数据封装到数据包中
        String data = getData("feiQ你好！");
        DatagramPacket packet2 = new DatagramPacket(data.getBytes(),
                data.getBytes().length,
                InetAddress.getByName("192.168.15.255"), 2425);
        // 发送数据
        socket2.send(packet2);
        // 关闭资源
        socket2.close();
    }

    // 把数据拼接成指定格式的数据
    public static String getData(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("1.0:");
        sb.append(System.currentTimeMillis() + ":");
        sb.append("习大大:");
        sb.append("192.168.10.1:");
        sb.append("32:");
        sb.append(content);
        return sb.toString();
    }

}
