package base.java3oop.oop2thread;
/**
 * join方法：在a(代码段)线程中间插入一个b（代码段）线程执行完b（代码段）线程后,再执行a（接下来的代码段）线程
         * 后台线程：
         * setDaemon() 设置线程是否为守护线程，true为守护线程， false为非守护线程。	必须在启动之前设置才会设置为后台线程
         * 后台线程就是隐藏运行，直到进程结束.*/
public class Thread2BaseThread {
    public static void main(String[] args) throws Exception {
        ATest a=new ATest();
        a.start();
        ATest1 b=new ATest1();
        b.setDaemon(true);//设置守护线程当非守护线程结束，守护线程也结束
        b.start();
        System.out.println("这里加入新的线程-------------");
        ATest c=new ATest();
        c.start();
        c.join();// 一个线程如果执行join语句，那么就有新的线程加入，执行该语句的线程必须要让步给新加入的线程先完成任务，然后才能继续执行。
        System.out.println("-------------------");//main线程结束
		/*
		 线程的停止：
		 	1. 停止一个线程 我们一般都会通过一个变量去控制的。
		 	2. 如果需要停止一个处于等待状态下的线程，那么我们需要通过变量配合notify方法或者interrupt()来使用。
		 */
        Demo6 d = new Demo6("狗娃");
        d.setPriority(10);
        d.start();
        for(int i = 0 ; i<100 ; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            //当主线程的i是80的时候停止狗娃线程。
            //d.interrupt();  // interrupt()根本就是无法停止一个线程。
            if(i==80){
                d.flag = false;
                d.interrupt(); //把线程的等待状态强制清除，被清除状态的线程会接收到一个InterruptedException。
				/*synchronized (d) {
					d.notify();
				}*/
            }
        }
    }
}
class ATest extends Thread{

    @Override
    public void run() {
        int i=0;
        while(i<10){
            System.out.println("我是线程");
            try {
                sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            i++;
        }
    }
}
class ATest1 extends Thread{

    @Override
    public void run() {
        int i=0;
        while(i<100){
            System.out.println("我是守护线程");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            i++;
        }
    }
}
class Demo6 extends Thread {

    boolean flag = true;

    public Demo6(String name){
        super(name);
    }
    @Override
    public synchronized void run() {
        int i = 0 ;
        while(flag){
            try {
                this.wait(); //狗娃等待..

            } catch (InterruptedException e) {
                System.out.println("接收到了异常了....");
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
            i++;
        }
    }
}
