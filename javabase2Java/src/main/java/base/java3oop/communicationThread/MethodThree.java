package base.java3oop.communicationThread;

/**
 * @Author Science
 * @Date 2020/11/1 15:34
 * @Version 1.0
 * volatile 修饰的变量值直接存在main memory里面，子线程对该变量的读写直接写入main memory，而不是像其它
 * 变量一样在local thread里面产生一份copy。 volatile 能保证所修饰的变量对于多个线程可见性，即只要被修
 * 改，其它线程读到的一定是最新的值。
 */
public class MethodThree {
    private volatile ThreadToGo threadToGo = new ThreadToGo();
    class ThreadToGo {
        int value = 1;
    }
    public Runnable newThreadOne() {
        final String[] inputArr = Helper.buildNoArr(52);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                for (int i = 0; i < arr.length; i=i+2) {
                    while(threadToGo.value==2){}
                    Helper.print(arr[i], arr[i + 1]);
                    threadToGo.value=2;
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
                    while(threadToGo.value==1){}
                    Helper.print(arr[i]);
                    threadToGo.value=1;
                }
            }
        };
    }
    public static void main(String args[]) throws InterruptedException {
        MethodThree three = new MethodThree();
        Helper.instance.run(three.newThreadOne());
        Helper.instance.run(three.newThreadTwo());
        Helper.instance.shutdown();
    }

}
