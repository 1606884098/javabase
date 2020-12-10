package base.java3oop.communicationThread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author Science
 * @Date 2020/11/1 16:31
 * @Version 1.0
 * 第四种解法，是利用BlockingQueue；
 * 顺便总结下BlockingQueue的一些内容。
 * BlockingQueue定义的常用方法如下:
 *
 * add(Object)：把Object加到BlockingQueue里，如果BlockingQueue可以容纳，则返回true，否则抛出异常。
 * offer(Object)：表示如果可能的话，将Object加到BlockingQueue里，即如果BlockingQueue可以容纳，则返回true，否则返回false。
 * put(Object)：把Object加到BlockingQueue里，如果BlockingQueue没有空间，则调用此方法的线程被阻断直到BlockingQueue里有空间再继续。
 * poll(time)：获取并删除BlockingQueue里排在首位的对象，若不能立即取出，则可以等time参数规定的时间，取不到时返回null。当不传入time值时，立刻返回。
 * peek()：立刻获取BlockingQueue里排在首位的对象，但不从队列里删除，如果队列为空，则返回null。
 * take()：获取并删除BlockingQueue里排在首位的对象，若BlockingQueue为空，阻断进入等待状态直到BlockingQueue有新的对象被加入为止。
 * BlockingQueue有四个具体的实现类：
 *
 * ArrayBlockingQueue：规定大小的BlockingQueue，其构造函数必须带一个int参数来指明其大小。其所含的对象是以FIFO（先入先出）顺序排序的。
 * LinkedBlockingQueue：大小不定的BlockingQueue，若其构造函数带一个规定大小的参数，生成的BlockingQueue有大小限制，若不带大小参数，所生成的BlockingQueue的大小由Integer.MAX_VALUE来决定。其所含的对象是以FIFO顺序排序的。
 * PriorityBlockingQueue：类似于LinkedBlockingQueue,但其所含对象的排序不是FIFO，而是依据对象的自然排序顺序或者是构造函数所带的Comparator决定的顺序。
 * SynchronousQueue：特殊的BlockingQueue，对其的操作必须是放和取交替完成的。
 * 这里我用了两种玩法：
 *
 * 一种是共享一个queue，根据peek和poll的不同来实现；
 * 第二种是两个queue，利用take()会自动阻塞来实现。
 */
public class MethodSeven {
    private final LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
    public Runnable newThreadOne() {
        final String[] inputArr = Helper.buildNoArr(52);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                for (int i = 0; i < arr.length; i=i+2) {
                    Helper.print(arr[i], arr[i + 1]);
                    queue.offer("TwoToGo");
                    while(!"OneToGo".equals(queue.peek())){}
                    queue.poll();
                }
            }
        };
    }
    public Runnable newThreadTwo() {
        final String[] inputArr = Helper.buildCharArr(26);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                for (int i = 0; i < arr.length; i++) {
                    while(!"TwoToGo".equals(queue.peek())){}
                    queue.poll();
                    Helper.print(arr[i]);
                    queue.offer("OneToGo");
                }
            }
        };
    }
    private final LinkedBlockingQueue<String> queue1 = new LinkedBlockingQueue<>();
    private final LinkedBlockingQueue<String> queue2 = new LinkedBlockingQueue<>();
    public Runnable newThreadThree() {
        final String[] inputArr = Helper.buildNoArr(52);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                for (int i = 0; i < arr.length; i=i+2) {
                    Helper.print(arr[i], arr[i + 1]);
                    try {
                        queue2.put("TwoToGo");
                        queue1.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
    public Runnable newThreadFour() {
        final String[] inputArr = Helper.buildCharArr(26);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                for (int i = 0; i < arr.length; i++) {
                    try {
                        queue2.take();
                        Helper.print(arr[i]);
                        queue1.put("OneToGo");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
    public static void main(String args[]) throws InterruptedException {
        ThreadLocal a=new ThreadLocal();
        MethodSeven seven = new MethodSeven();
/*        Helper.instance.run(seven.newThreadOne());
        Helper.instance.run(seven.newThreadTwo());
        Thread.sleep(2000);
        System.out.println("");*/
        Helper.instance.run(seven.newThreadThree());
        Helper.instance.run(seven.newThreadFour());
        Helper.instance.shutdown();
    }
}
