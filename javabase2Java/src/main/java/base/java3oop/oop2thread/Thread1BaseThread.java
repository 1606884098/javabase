package base.java3oop.oop2thread;

/**
 *  进程：正在执行的程序。负责了程序的内存空间分配，代表内存中的执行区域 ，启动时向操作系统申请内存空间
 *  线程：负责一个执行一个单元，线程负责代码执行，每个线程都有任务代码     多线程就是多个单元路径同时执行
 *  cpu分时机制：cpu给进程随机的执行权，切换执行。所以在线程也是有执行权和阻塞的
 *  一个java应用程序至少有几个线程？
 *  至少有两个线程， 一个是主线程负责main方法代码的执行，一个是垃圾回收器线程,负责了回收垃圾。
 * 每个线程都有自己的任务代码，jvm创建的主线程的任务代码就是main方法中的所有代码, 自定义线程的任务代码就写在run方法中，
 * 自定义线程负责了run方法中代码。
 *
 * 线程状态及生命周期：
 *  创建线程-->.start()可运行状态(等待cpu的执行权)-->运行（线程运行的时候认为睡眠要等唤醒才能转为可运行状态，没有执
 *  行权而阻塞编程为可运行状态）-->消亡（run方法结束线程消亡，还有一种用标记停止线程，只要控制住while(tag)）
 *  Thread1BaseThread.png
 */
public class Thread1BaseThread {

        public static void main(String[] args) throws Exception {
            Product p = new Product();  //产品
            //创建生产对象
            Producer producer = new Producer(p);
            //创建消费者
            Customer customer = new Customer(p);
            //调用start方法开启线程
            producer.start();
            customer.start();
            //测试死锁
            DeadLock thread1 = new DeadLock("张三");
            DeadLock thread2 = new DeadLock("狗娃");
            //开启线程
            thread1.start();
            thread2.start();
		/**	 线程常用的方法：
	 	 Thread(String name)     初始化线程的名字
		 setName(String name)    设置线程对象名
		 getName()             返回线程的名字
		 sleep()                 线程睡眠指定的毫秒数。 静态的方法， 那个线程执行了sleep方法代码那么就是那个线程睡眠。
		 currentThread()      返回当前的线程对象，该方法是一个静态的方法， 注意： 那个线程执行了currentThread()代码就返回那个线程 的对象。
		 getPriority()             返回当前线程对象的优先级   默认线程的优先级是5
		 setPriority(int newPriority) 设置线程的优先级    虽然设置了线程的优先级，但是具体的实现取决于底层的操作系统的实现（最大的优先级是10 ，最小的1 ， 默认是5）。*/
            System.out.println("返回线程的名字："+thread1.getName());
            thread1.setName("设置线程对象名");
            System.out.println("返回线程的名字："+thread1.getName());
            thread1.sleep(1000);
            System.out.println("我是主线程"+thread1.currentThread());
            thread1.setPriority(8);
            System.out.println("当前线程优先级："+thread1.getPriority());

        }
    }
    //产品类
    class Product{
        String name;  //名字
        double price;  //价格
        boolean flag = false; //产品是否生产完毕的标识，默认情况是没有生产完成。
    }
    /**
     * 自定义线程的创建方式:
    方式一 ：
        1. 自定义一个类继承Thread类。
        2. 重写Thread类的run方法，把自定义线程的任务代码写在run方法上。
        3. 创建Thread的子类对象，并且调用start方法启动一个线程。 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
        注意：千万不要直接调用run方法，调用start方法的时候线程就会开启，线程一旦开启就会执行run方法中代码，如果直接调用
        run方法，那么就 相当于调用了一个普通的方法而已。
    方式二：
        1. 自定义一个类实现Runnable接口。
        2. 实现Runnable接口 的run方法，把自定义线程的任务定义在run方法上。
        3. 创建Runnable实现类对象。
        4. 创建Thread类 的对象，并且把Runnable实现类的对象作为实参传递。
        5. 调用Thread对象 的start方法开启一个线程。
    问题1： 请问Runnable实现类的对象是线程对象吗？
        Runnable实现类的对象并 不是一个线程对象，只不过是实现了Runnable接口 的对象而已。
        只有是Thread或者是Thread的子类才是线程 对象。
    问题2： 为什么要把Runnable实现类的对象作为实参传递给Thread对象呢？作用是什么？
        作用就是把Runnable实现类的对象的run方法作为了线程的任务代码去执行了。
    推荐使用： 第二种。 实现Runable接口的。
    原因： 因为java单继承 ,多实现的。*/
//生产者
    class Producer extends Thread{
        Product  p ;  	//产品
        public Producer(Product p) {
            this.p  = p ;
        }
        @Override
        public void run() {
            int i = 0 ;
            while(true){
/**			线程安全问题：
			线程安全出现 的根本原因：
				1. 存在两个或者两个以上 的线程对象共享同一个资源。
				2. 多线程操作共享资源的代码 有多句。
			线程安全问题的解决方案：
				方式一： 可以使用同步代码块去解决。同步代码块(开发中不到万不得已不用，影响性能)
				格式：
					synchronized(锁对象){
						需要被同步的代码
					}
			同步代码块要注意的事项：
			  	锁对象：每个java都有且仅有一个内置锁对象，当对象具有同步方法代码是内置锁才会起作用
       			创建锁 可以是任意 一般非静态同步函数 用this 代码块自定义 因为java对象有且仅有一个锁，当一对象获得该线程对象锁的时候别的对象就必须等待
        		这个对象释放锁，才会有资格执行同步代码块，保证了线程安全
				1. 锁对象可以是任意的一个对象。
				2. 一个线程在同步代码块中sleep了，并不会释放锁对象。
				3. 如果不存在着线程安全问题，千万不要使用同步代码块，因为会降低效率。
				4. 锁对象必须是多线程共享的一个资源，否则锁不住。
				方式二：同步函数  ：  同步函数就是使用synchronized修饰一个函数。
				同步函数要注意的事项 ：
					1. 如果是一个非静态的同步函数的锁 对象是this对象，如果是静态的同步函数的锁 对象是当前函数所属的类的字节码文件（class对象）。
					2. 同步函数的锁对象是固定的，不能由你来指定 的
				推荐使用： 同步代码块。
					原因：
						1. 同步代码块的锁对象可以由我们随意指定，方便控制。同步函数的锁对象是固定 的，不能由我们来指定。
						2. 同步代码块可以很方便控制需要被同步代码的范围，同步函数必须是整个函数 的所有代码都被同步了。*/
                synchronized (p) {
                    if(p.flag==false){
                        if(i%2==0){
                            p.name = "苹果";
                            p.price = 6.5;
                        }else{
                            p.name="香蕉";
                            p.price = 2.0;
                        }
                        System.out.println("生产者生产出了："+ p.name+" 价格是："+ p.price);
                        p.flag = true;
                        i++;
/**				 线程通讯： 一个线程完成了自己的任务时，要通知另外一个线程去完成另外一个任务.
				 生产者与消费者
				 wait():  等待   如果线程执行了wait方法，那么该线程会进入等待的状态，等待状态下的线程必须要被其他线程调用notify方法才能唤醒。
				 notify()： 唤醒    唤醒线程池等待线程其中的一个。
				 notifyAll() : 唤醒线程池所有等待 线程。
				 wait与notify方法要注意的事项：
				 	1. wait方法与notify方法是属于Object对象 的。
				 	2. wait方法与notify方法必须要在同步代码块或者是同步函数中才能 使用。
				 	3. wait方法与notify方法必需要由锁对象调用。
				 问题一：出现了线程安全问题。 价格错乱了...*/
                        p.notifyAll(); //唤醒消费者去消费
                    }else{
                        //已经生产 完毕，等待消费者先去消费
                        try {
                            p.wait();   //生产者等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //消费者
    class Customer extends Thread{
        Product p;
        public  Customer(Product p) {
            this.p = p;
        }
        @Override
        public void run() {
            while(true){
                synchronized (p) {
                    if(p.flag==true){  //产品已经生产完毕
                        System.out.println("消费者消费了"+p.name+" 价格："+ p.price);
                        p.flag = false;
                        p.notifyAll(); // 唤醒生产者去生产
                    }else{
                        //产品还没有生产,应该 等待生产者先生产。
                        try {
                            p.wait(); //消费者也等待了...
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    /**
    java中同步机制解决了线程安全问题，但是也同时引发死锁现象。
    死锁现象：
    死锁现象出现 的根本原因：
        1. 存在两个或者两个以上的线程。
        2. 存在两个或者两个以上的共享资源。
    死锁现象的解决方案： 没有方案。只能尽量避免发生而已。
     */
    class DeadLock extends Thread{
        public DeadLock(String name){
            super(name);
        }
        public void run() {
            if("张三".equals(Thread.currentThread().getName())){
                synchronized ("遥控器") {
                    System.out.println("张三拿到了遥控器，准备 去拿电池!!");
                    synchronized ("电池") {
                        System.out.println("张三拿到了遥控器与电池了，开着空调爽歪歪的吹着...");
                    }
                }
            }else if("狗娃".equals(Thread.currentThread().getName())){
                synchronized ("电池") {
                    System.out.println("狗娃拿到了电池，准备去拿遥控器!!");
                    synchronized ("遥控器") {
                        System.out.println("狗娃拿到了遥控器与电池了，开着空调爽歪歪的吹着...");
                    }
                }
            }
        }

}
