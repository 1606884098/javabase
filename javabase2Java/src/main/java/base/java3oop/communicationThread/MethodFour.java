package base.java3oop.communicationThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author Science
 * @Date 2020/11/1 16:25
 * @Version 1.0
 * 第二种解法，是利用CyclicBarrierAPI；
 * CyclicBarrier可以实现让一组线程在全部到达Barrier时(执行await())，再一起同时执行，并且所有线程释放后，
 * 还能复用它,即为Cyclic。CyclicBarrier类提供两个构造器:
 * public CyclicBarrier(int parties, Runnable barrierAction) {
 * }
 * public CyclicBarrier(int parties) {
 * }
 *
 * 这里多说一点，这个API其实还是利用lock和condition，无非是多个线程去争抢CyclicBarrier的instance的lock罢
 * 了，最终barrierAction执行时，是在抢到CyclicBarrierinstance的那个线程上执行的。
 */
public class MethodFour {
    private final CyclicBarrier barrier;
    private final List<String> list;
    public MethodFour() {
        list = Collections.synchronizedList(new ArrayList<String>());
        barrier = new CyclicBarrier(2,newBarrierAction());
    }
    public Runnable newThreadOne() {
        final String[] inputArr = Helper.buildNoArr(52);
        return new Runnable() {
            private String[] arr = inputArr;
            public void run() {
                for (int i = 0, j=0; i < arr.length; i=i+2,j++) {
                    try {
                        list.add(arr[i]);
                        list.add(arr[i+1]);
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
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
                    try {
                        list.add(arr[i]);
                        barrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }
    private Runnable newBarrierAction(){//两个线程到达后执行的任务
        return new Runnable() {
            @Override
            public void run() {
                Collections.sort(list);//这里是排序操作
                list.forEach(c->System.out.print(c));
                list.clear();
            }
        };
    }
    public static void main(String args[]){
        MethodFour four = new MethodFour();
        Helper.instance.run(four.newThreadTwo());
        Helper.instance.run(four.newThreadOne());
        Helper.instance.shutdown();
    }

}
