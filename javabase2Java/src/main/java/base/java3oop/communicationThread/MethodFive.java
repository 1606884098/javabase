package base.java3oop.communicationThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Science
 * @Date 2020/11/1 16:23
 * @Version 1.0
 * 利用AtomicInteger
 */
public class MethodFive {
    private AtomicInteger threadToGo = new AtomicInteger(1);
    public Runnable newThreadOne() {
        final String[] inputArr = Helper.buildNoArr(52);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                for (int i = 0; i < arr.length; i=i+2) {
                    while(threadToGo.get()==2){//停顿在这里
                    }
                    Helper.print(arr[i], arr[i + 1]);
                    threadToGo.set(2);
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
                    while(threadToGo.get()==1){//停顿在这里
                    }
                    Helper.print(arr[i]);
                    threadToGo.set(1);
                }
            }
        };
    }
    public static void main(String args[]) throws InterruptedException {
        MethodFive five = new MethodFive();
        Helper.instance.run(five.newThreadOne());
        Helper.instance.run(five.newThreadTwo());
        Helper.instance.shutdown();
    }
}
