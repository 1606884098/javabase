package base.java3oop.communicationThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Science
 * @Date 2020/11/1 15:11
 * @Version 1.0
 */
public enum  Helper {
    instance;
    private static final ExecutorService tPool = Executors.newFixedThreadPool(2);

    public static String[] buildNoArr(int max) {
        String[] noArr = new String[max];
        for(int i=0;i<max;i++){
            noArr[i] = Integer.toString(i+1);
        }
        return noArr;
    }

    public static String[] buildCharArr(int max) {
        String[] charArr = new String[max];
        int tmp = 65;
        for(int i=0;i<max;i++){
            charArr[i] = String.valueOf((char)(tmp+i));
        }
        return charArr;
    }

    public static void print(String... input){
        if(input==null)
            return;
        for(String each:input){
            System.out.print(each);
        }
    }

    public void run(Runnable r){
        tPool.submit(r);
    }

    public void shutdown(){
        tPool.shutdown();
    }

}
