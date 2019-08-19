package base.java5netty.netty1.nio.finalFromNetExample;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
//nio 服务端
public class Server implements Runnable {
    //1 多路复用器
    private Selector selector;
    //2 建立缓冲区
    private ByteBuffer readBuf=ByteBuffer.allocate(1024*100);
    private ByteBuffer writeBuf=ByteBuffer.allocate(1024*100);
    //构造函数
    public Server(int port){
        try {
            //1 打开多路复用器
            this.selector=Selector.open();
            //2 打开服务器通道
            ServerSocketChannel ssc = ServerSocketChannel.open();
            //3 设置服务器通道为非阻塞方式
            ssc.configureBlocking(false);
            //4 绑定ip
            ssc.bind(new InetSocketAddress(port));
            //5 把服务器通道注册到多路复用器上,只有非阻塞信道才可以注册选择器.并在注册过程中指出该信道可以进行Accept操作
            ssc.register(this.selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器已经启动.....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while(true){//一直循环
            try {
                this.selector.select();//多路复用器开始监听
                //获取已经注册在多了复用器上的key通道集
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();
                //遍历
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();//获取key
                    //如果是有效的
                    if(key.isValid()){
                        // 如果为阻塞状态,一般是服务端通道
                        if(key.isAcceptable()){
                            this.accept(key);
                        }
                        // 如果为可读状态,一般是客户端通道
                        if(key.isReadable()){
                            this.read(key);
                        }
                    }
                    //从容器中移除处理过的key
                    keys.remove();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    //从客户端通道获取数据并进行处理
    private void read(SelectionKey key) {
        try {
            //1 清空缓冲区旧的数据
            this.readBuf.clear();
            //2 获取之前注册的socket通道对象
            SocketChannel sc = (SocketChannel) key.channel();
            //3 读取数据
            int count = sc.read(this.readBuf);
            //4 如果没有数据
            if(count == -1){
                key.channel().close();
                key.cancel();
                return;
            }
            //5 有数据则进行读取 读取之前需要进行复位方法(把position 和limit进行复位)
            this.readBuf.flip();
            //6 根据缓冲区的数据长度创建相应大小的byte数组，接收缓冲区的数据
            byte[] bytes = new byte[this.readBuf.remaining()];
            //7 接收缓冲区数据
            this.readBuf.get(bytes);
            //8 打印结果
            String body = new String(bytes).trim();
            System.out.println("服务端接受到客户端请求的数据: " + body);
            //9 告诉客户端已收到数据
            writeBuf.put(("你好,客户端,我已收到数据"+"客户端内容是--"+body).getBytes());
            //对缓冲区进行复位
            writeBuf.flip();
            //写出数据到服务端
            sc.write(writeBuf);
            //清空缓冲区数据
            writeBuf.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //接受一个客户端socket进行处理
    private void accept(SelectionKey key) {
        try {
            //1 获取服务通道
            ServerSocketChannel ssc =  (ServerSocketChannel) key.channel();
            //2 执行阻塞方法,当有客户端请求时,返回客户端通信通道
            SocketChannel sc = ssc.accept();
            //3 设置阻塞模式
            sc.configureBlocking(false);
            //4 注册到多路复用器上，并设置可读标识
            sc.register(this.selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //启动服务器
        new Thread(new Server(9527)).start();
    }


}
